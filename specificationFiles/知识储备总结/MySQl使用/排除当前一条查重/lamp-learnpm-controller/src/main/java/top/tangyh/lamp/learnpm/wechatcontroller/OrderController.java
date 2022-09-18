package top.tangyh.lamp.learnpm.wechatcontroller;

import cn.hutool.http.HttpRequest;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.jwt.TokenUtil;
import top.tangyh.lamp.com.meituan.sqt.client.SqtService;
import top.tangyh.lamp.com.meituan.sqt.enums.ProductType;
import top.tangyh.lamp.com.meituan.sqt.enums.SqtURI;
import top.tangyh.lamp.com.meituan.sqt.h5.SqtH5Service;
import top.tangyh.lamp.com.meituan.sqt.model.apply.OutRepastApply;
import top.tangyh.lamp.com.meituan.sqt.model.apply.RepastCity;
import top.tangyh.lamp.com.meituan.sqt.request.staff.StaffInfo;
import top.tangyh.lamp.com.meituan.sqt.response.apply.RepastApplySyncResult;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.save.PmHotelReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderFoodSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmTransportationReservationSaveVO;
import top.tangyh.lamp.learnpm.wechat.WO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.lang.ref.PhantomReference;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @Class: OrderController
 * @Author: MrSnow
 * @Date: 2022/6/30 11:29
 */
@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/wechat/order")
@Api(value = "order", tags = "订单类")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class OrderController {
    private final SqtH5Service sqtH5Service;
    private final SqtService sqtService;
    private final PmOrderFoodService pmOrderFoodService;
    private final PmHotelReservationService pmHotelReservationService;
    private final PmTransportationReservationService pmTransportationReservationService;
    private final PmProjectMeetingApplyService pmProjectMeetingApplyService;
    @Resource
    PmConferenceApplyFeeService pmConferenceApplyFeeService;

    /**
     * 订交通
     * @param wo 请在dataId处填写PmProjectMeetingApplyId，data中存入PmOrderFoodSaveVO的JSON字符串,phone为当前登陆人的phone
     * @return
     */
    @ApiOperation(value = "美团外卖订餐", notes = "美团外卖订餐")
    @PostMapping(value = "/Food", produces = "application/json")
    public R orderFood(@RequestBody WO wo, HttpServletRequest request) {
        HashMap map = new HashMap();
        //创建新的订餐记录
        PmOrderFoodSaveVO pmOrderFoodSaveVO = pmOrderFoodService.orderFood(wo.getDataId());
        map.put("pmOderFoodSaveVO",pmOrderFoodSaveVO);
        Long applyId = wo.getDataId();
        PmProjectMeetingApply meeting = pmProjectMeetingApplyService.getById(applyId);
        map.put("applyCode",meeting.getMeetingNoName()+"CF");
        try {
            //同步申请单，获取商企通申请单单号
            RepastApplySyncResult repastApplySyncResult = repastApplySync(wo,request);
            //返回h5免登URL
            String h5Url = sqtH5Service.getH5Url(WO.getPhone(request), ProductType.MT_WAIMAI);
            map.put("H5Url",h5Url);
            return R.success(map, "跳转到美团外卖");
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("服务器开小差了~");
        }
    }

    /**
     * 订酒店
     * @param wo 请在dataId处填写PmProjectMeetingApplyId，data中存入PmHotelReservationSaveVO的JSON字符串,phone为当前登陆人的phone
     * @return
     */
    @ApiOperation(value = "美团订酒店", notes = "美团订酒店")
    @PostMapping(value = "/Hotel", produces = "application/json")
    public R orderHotel(@RequestBody WO wo,HttpServletRequest request) {
        String data = wo.getData();
        PmHotelReservationSaveVO pmHotelReservation = JSONObject.parseObject(data, PmHotelReservationSaveVO.class);
        try {
            pmHotelReservationService.save(pmHotelReservation);
            //设置费用申请表id
            pmHotelReservation.setPmConferenceApplyFeeId(getHotelConferenceApplyFee(wo.getDataId()).getId());
            String h5Url = sqtH5Service.getH5Url(WO.getPhone(request), ProductType.MT_HOTEL);
            return R.success(h5Url, "跳转到美团订酒店");
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("服务器开小差了~");
        }
    }

    /**
     * 订交通
     * @param wo 请在dataId处填写PmProjectMeetingApplyId，pmTransportationReservationSaveVO,phone为当前登陆人的phone
     * @return
     */
    @ApiOperation(value = "美团定交通", notes = "美团定交通")
    @PostMapping(value = "/Car", produces = "application/json")
    public R orderTransportation(@RequestBody WO wo,HttpServletRequest request) {
        String data = wo.getData();
        PmTransportationReservationSaveVO pmTransportationReservationSaveVO = JSONObject.parseObject(data, PmTransportationReservationSaveVO.class);
        try {
            pmTransportationReservationService.save(pmTransportationReservationSaveVO);
            //设置费用申请表id
            pmTransportationReservationSaveVO.setPmConferenceApplyFeeId(getTransportationConferenceApplyFee
                    (wo.getDataId()).getId());
            String h5Url = sqtH5Service.getH5Url(WO.getPhone(request), ProductType.MT_CAR);
            return R.success(h5Url, "跳转到美团打车");
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("服务器开小差了~");
        }
    }

    /**
     * 用餐订单
     * @param wo
     * @return
     */
    @ApiOperation(value = "用餐订单", notes = "用餐订单")
    @PostMapping(value = "/foodOrderList", produces = "application/json")
    public R foodOrderList(@RequestBody WO wo){

        return R.success("查询完成");
    }

    /**
     * 用餐申请单同步
     * @param wo
     * @param request
     * @return
     */
    public RepastApplySyncResult repastApplySync(@RequestBody WO wo,HttpServletRequest request){
        PmOrderFoodSaveVO saveVO = JSONObject.parseObject(wo.getData(), PmOrderFoodSaveVO.class);
        Long meetingApplyId = saveVO.getPmProjectMeetingApplyId();
        PmProjectMeetingApply meeting = pmProjectMeetingApplyService.getById(meetingApplyId);

        //创建同步申请单所需的列表
        ArrayList<RepastCity> cities = new ArrayList<>();
        ArrayList<StaffInfo> staffInfos = new ArrayList<>();
        ArrayList<OutRepastApply> outRepastApplies = new ArrayList<>();
        //城市信息
        cities.add(new RepastCity(meeting.getMeetingCityCode().toString(),meeting.getMeetingCityName()));
        //提交人信息
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setEntStaffNum(WO.getPhone(request));
        staffInfos.add(staffInfo);
        //申请参数
        OutRepastApply outRepastApply = new OutRepastApply();
        outRepastApply.setSceneType(4);
        outRepastApply.setOutRepastApplyNo(meeting.getMeetingNoName()+"CF");
        outRepastApply.setSubmitStaff(staffInfo);
        outRepastApply.setStartTime(meeting.getSupportProjectPlanStartTime().getTime());
        outRepastApply.setEndTime(meeting.getSupportProjectPlanEndTime().getTime());
        //协办人（和提交人相同）
        outRepastApply.setAssistantStaffList(staffInfos);
        outRepastApply.setRepastCityList(cities);
        outRepastApplies.add(outRepastApply);
        String s = sqtService.repastApplySync(outRepastApplies);
        return JSONObject.parseObject(s,RepastApplySyncResult.class);
    }

    /**
     * 获取会议申请费用表实例（商企通交通费）
     * @param id
     * @return
     */
    public PmConferenceApplyFee getTransportationConferenceApplyFee(Long id){
        return pmConferenceApplyFeeService.getSuperManager().getOne(Wraps.<PmConferenceApplyFee>lbQ()
                .eq(PmConferenceApplyFee::getFeeName, "交通费用")
                .eq(PmConferenceApplyFee::getPmProjectMeetingApplyId, id)
                );
    }

    /**
     * 获取会议申请费用表实例（商企通酒店费用）
     * @param id
     * @return
     */
    public PmConferenceApplyFee getHotelConferenceApplyFee(Long id){
        return pmConferenceApplyFeeService.getSuperManager().getOne(Wraps.<PmConferenceApplyFee>lbQ()
                .eq(PmConferenceApplyFee::getFeeName, "酒店费用")
                .eq(PmConferenceApplyFee::getPmProjectMeetingApplyId, id)
                );
    }
    @ApiOperation(value = "token测试", notes = "测试")
    @PostMapping(value = "/TokenTest", produces = "application/json")
    public R tokenTest(HttpServletRequest request){
        String userID = request.getHeader("userID");
        String phone = request.getHeader("phone");

        return R.success(userID+phone,"ok");
    }

}
