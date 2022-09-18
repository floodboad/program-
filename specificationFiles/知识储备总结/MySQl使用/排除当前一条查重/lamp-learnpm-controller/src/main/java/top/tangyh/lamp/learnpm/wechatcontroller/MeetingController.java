package top.tangyh.lamp.learnpm.wechatcontroller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanAllocationPageQuery;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingApplyPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanAllocationResultVO;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingApplyResultVO;
import top.tangyh.lamp.learnpm.vo.result.PmProjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingMaterialsRegSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderExpressSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmSenderReceiverSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmWebcastSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmSenderReceiverUpdateVO;
import top.tangyh.lamp.learnpm.wechat.OrderExpress;
import top.tangyh.lamp.learnpm.vo.result.*;
import top.tangyh.lamp.learnpm.vo.save.MsExpertBankCardInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpertInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmConferenceExpertServicesUpdateVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingApplyUpdateVO;
import top.tangyh.lamp.learnpm.wechat.MsExpertRelationInfo;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechat.WPage;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.nio.file.Watchable;
import java.util.*;

import static top.tangyh.lamp.common.constant.SwaggerConstants.*;
import static top.tangyh.lamp.common.constant.SwaggerConstants.PARAM_TYPE_QUERY;

/**
 * @Class: MeetingController
 * @Author: MrSnow
 * @Date: 2022/6/29 8:59
 */
@Slf4j
@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/api/wechat/meeting")
@Api(value = "meeting" ,tags = "会议")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class MeetingController {
    private final PmMeetingPlanAllocationService pmMeetingPlanAllocationService;
    @Resource
    private  PmProjectMeetingApplyService pmProjectMeetingApplyService;
    private final PmConferenceApplyFeeService pmConferenceApplyFeeService;
    private final PmConferenceExpertServicesService pmConferenceExpertServicesService;
    private final PmOnlineMeetingPublishService pmOnlineMeetingPublishService;
    private final PmMeetingMaterialsRegService pmMeetingMaterialsRegService;
    private final PmOtherExpensesRegService pmOtherExpensesRegService;
    private final EchoService echoService;
    private final PmSenderReceiverService pmSenderReceiverService;
    private final PmOrderExpressService pmOrderExpressService;
    private final PmWebcastService pmWebcastService;
    private final MsExpertInfoService msExpertInfoService;
    private final MsExpertBankCardInfoService msExpertBankCardInfoService;

    /**
     * 根据名称查找会议
     * @param wPage
     * @param request
     * @return
     */
    @ApiOperation(value = "根据名称查找会议",notes = "根据名称查找会议")
    @PostMapping(value = "/SearchMeetingByName",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R<IPage<PmProjectMeetingApplyResultVO>> searchMeetingByName(@RequestBody WPage wPage,HttpServletRequest request){
        IPage<PmProjectMeetingApply> page = wPage.getPageParams().buildPage();
        //查当前登陆人负责的会议规划分配id用来过滤查询
        List<PmMeetingPlanAllocation> allocations = pmMeetingPlanAllocationService.list(Wraps.<PmMeetingPlanAllocation>lbQ()
                .eq(PmMeetingPlanAllocation::getChargePersonId,WO.getUserId(request)));
        ArrayList<Long> allocationIds = new ArrayList<>();
        allocations.forEach(allocation ->{
            allocationIds.add(allocation.getId());
        });
        //查询负责人分配到的会议规划下的会议
        LbQueryWrap<PmProjectMeetingApply> wrap = Wraps.<PmProjectMeetingApply>lbQ()
                .in(PmProjectMeetingApply::getMeetingAllocationId,allocationIds)
                .like(PmProjectMeetingApply::getMeetingNoName, wPage.getData());
        pmProjectMeetingApplyService.page(page, wrap);
        IPage<PmProjectMeetingApplyResultVO> voPage = BeanPlusUtil.toBeanPage(page, PmProjectMeetingApplyResultVO.class);
        echoService.action(voPage);
        return R.success(voPage,"查询成功");
    }

    /**
     * 会议分配列表
     * @param wPage
     * @param request
     * @return
     */
    @ApiOperation(value = "获取会议分配列表",notes = "获取会议分配列表")
    @PostMapping(value = "/PageAllocations",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R<Map> pageAllocations(
            @RequestBody WPage wPage,HttpServletRequest request){
        IPage<PmMeetingPlanAllocation> page = wPage.getPageParams().buildPage();
        LbQueryWrap<PmMeetingPlanAllocation> wrap = Wraps.<PmMeetingPlanAllocation>lbQ()
                .eq(PmMeetingPlanAllocation::getChargePersonId, WO.getUserId(request));
        pmMeetingPlanAllocationService.page(page,wrap);
        IPage<PmMeetingPlanAllocationResultVO> voPage = BeanPlusUtil.toBeanPage(page, PmMeetingPlanAllocationResultVO.class);
        echoService.action(voPage);
        HashMap map = new HashMap<>(3);
        map.put("result",voPage);
        //查询已执行场次
        List<PmMeetingPlanAllocationResultVO> records = voPage.getRecords();
        records.forEach(allocation ->{
            List<PmProjectMeetingApply> list1 = pmProjectMeetingApplyService.list(Wraps.<PmProjectMeetingApply>lbQ()
                    .eq(PmProjectMeetingApply::getMeetingStatus, DSConstant.DICTIONARY_MEETING_STATUS_05)
                    .eq(PmProjectMeetingApply::getMeetingAllocationId, allocation.getId()));
            map.put("executedTimes",list1.size());
        });
        //查询执行中场次
        records.forEach(allocation -> {
            List<PmProjectMeetingApply> list2 = pmProjectMeetingApplyService.list(Wraps.<PmProjectMeetingApply>lbQ()
                    .eq(PmProjectMeetingApply::getMeetingStatus, DSConstant.DICTIONARY_MEETING_STATUS_04)
                    .eq(PmProjectMeetingApply::getMeetingFinalAccountStatus,DSConstant.DICTIONARY_MEETING_FINAL_ACCOUNT_STATUS_01)
                    .eq(PmProjectMeetingApply::getMeetingAllocationId, allocation.getId()));
            map.put("executingTime",list2.size());
        });
        return R.success(map,"查询成功！");
    }

    /**
     * 会议申请
     * @param wo
     * @return
     */
    @ApiOperation(value = "会议申请", notes = "会议申请")
    @PostMapping(value = "/ApplyMeeting", produces = "application/json")
    public R applyMeeting(@RequestBody WO wo){
        Long allocationId = wo.getDataId();
        R result = pmMeetingPlanAllocationService.meetingApply(allocationId);
        if (result.getData() instanceof PmProjectMeetingApply){
            return R.success(result.getData(),result.getMsg());
        }
        return R.fail("申请失败："+result.getMsg());
    }

    /**
     * 会议详情
     * @param wo 请在wo中填入dataId取值为MeetingApplyId ; userId
     * @return
     */
    @ApiOperation(value = "获取会议详情", notes = "获取会议详情")
    @PostMapping(value = "/MeetingDetail", produces = "application/json")
    public R getMeetingDetail(@RequestBody WO wo){
        HashMap<String,List> meetingDetailMap = new HashMap<>();
        Long meetingApplyId = wo.getDataId();
        //会议信息主表查询
        PmProjectMeetingApply meeting = pmProjectMeetingApplyService.getById(meetingApplyId);
        meetingDetailMap.put("PmProjectMeetingApply", Collections.singletonList(meeting));
        try {
            //申请费用查询
            List<PmConferenceApplyFee> applyFeeList = pmConferenceApplyFeeService.list(Wraps.<PmConferenceApplyFee>lbQ()
                    .eq(PmConferenceApplyFee::getPmProjectMeetingApplyId, meetingApplyId));
            meetingDetailMap.put("PmConferenceApplyFee", applyFeeList);
            //专家劳务查询
            List<PmConferenceExpertServices> expertServicesList = pmConferenceExpertServicesService.list(Wraps.<PmConferenceExpertServices>lbQ()
                    .eq(PmConferenceExpertServices::getPmProjectMeetingApplyId, meetingApplyId));
            meetingDetailMap.put("PmConferenceExpertServices",expertServicesList);
            //会议发布查询
            List<PmOnlineMeetingPublish> onlineMeetingPublishList = pmOnlineMeetingPublishService.list(Wraps.<PmOnlineMeetingPublish>lbQ()
                    .eq(PmOnlineMeetingPublish::getPmProjectMeetingApplyId, meetingApplyId));
            meetingDetailMap.put("PmOnlineMeetingPublish",onlineMeetingPublishList);
            //合规材料查询
            List<PmMeetingMaterialsReg> meetingMaterialsRegList = pmMeetingMaterialsRegService.list(Wraps.<PmMeetingMaterialsReg>lbQ()
                    .eq(PmMeetingMaterialsReg::getPmProjectMeetingApplyId, meetingApplyId));
            meetingDetailMap.put("PmMeetingMaterialsReg",meetingMaterialsRegList);
            //会议执行费用支付录入
            List<PmOtherExpensesReg> pmOtherExpensesRegList = pmOtherExpensesRegService.list(Wraps.<PmOtherExpensesReg>lbQ()
                    .eq(PmOtherExpensesReg::getPmProjectMeetingApplyId, meetingApplyId));
            meetingDetailMap.put("PmOtherExpensesReg",pmOtherExpensesRegList);
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("查询时出现异常");
        }

        return R.success(meetingDetailMap,"查询成功");
    }

    /**
     * 会议列表查询
     * @param wPage
     * @return
     */
    @ApiOperation(value = "会议列表查询", notes = "会议列表查询")
    @PostMapping(value = "/PageMeetings", produces = "application/json")
    public R<IPage<PmProjectMeetingApplyResultVO>> getMeetingList(@RequestBody WPage wPage,HttpServletRequest request){
        IPage page = wPage.getPageParams().buildPage();
        LbQueryWrap<PmProjectMeetingApply> wrap=null;
        String status = wPage.getData();
        //未提交的会议
        if (status.equals("00")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request));
        }
        //申请中的会议列表
        if (status.equals("01")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus,
                            DSConstant.DICTIONARY_MEETING_STATUS_02,
                            DSConstant.DICTIONARY_MEETING_STATUS_03)
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request));
        }
        //待发布的会议列表
        if (status.equals("02")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus, DSConstant.DICTIONARY_MEETING_STATUS_04)
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request))
                    .eq(PmProjectMeetingApply::getPublishStatus,DSConstant.DICTIONARY_PUBLISH_STATUS2_01);
        }
        //未开始的会议列表
        if (status.equals("03")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus,"04")
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request))
                    .eq(PmProjectMeetingApply::getPublishStatus, DSConstant.DICTIONARY_PUBLISH_STATUS2_02);
        }
        //进行中的会议列表
        if(status.equals("04")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus,"04")
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request));
        }
        //已结束的会议列表
        if(status.equals("04")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus,"04")
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request));
        }
        //结算中的会议列表
        if (status.equals("04")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus,"04")
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request));
        }
        //已完成的会议列表
        if (status.equals("05")){
            wrap = Wraps.<PmProjectMeetingApply>lbQ()
                    .in(PmProjectMeetingApply::getMeetingStatus,"05")
                    .eq(PmProjectMeetingApply::getChargePersonId,WO.getUserId(request));
        }
        //全部的会议列表
        pmProjectMeetingApplyService.page(page,wrap);
        IPage voPage = BeanPlusUtil.toBeanPage(page, PmProjectMeetingApplyResultVO.class);
        return R.success(voPage,"查询完成");
    }

    /**
     * 撤销未提交的会议申请
     * @param wo
     * @return
     */
    @ApiOperation(value = "撤销会议申请", notes = "撤销会议申请")
    @PostMapping(value = "/RemoveApply", produces = "application/json")
    public R removeApply(@RequestBody WO wo){
        String data = wo.getData();
        List<Long> ids = JSONObject.parseObject(data,ArrayList.class);
        for(Long id:ids){
            PmProjectMeetingApply apply = pmProjectMeetingApplyService.getById(id);
            if (!apply.getMeetingStatus().equals(DSConstant.DICTIONARY_MEETING_STATUS_01)){
                return R.fail("不可删除已经提交了的会议！");
            }
        }
        boolean b = pmProjectMeetingApplyService.removeByIds(ids);
        //更新场次信息，回填申请场次
        pmProjectMeetingApplyService.updateAppliedNum(ids);
        return R.success(b,"作废了"+ids.size()+"条会议申请！");
    }

    /**
     * retur结算
     * @param wo
     * @
     */
    public R meetingBalance(WO wo){
        return R.success("结算完成！");
    }

    /**
     * 收发件地址
     */
    @ApiOperation(value = "收发件地址列表",notes = "收发件地址列表")
    @PostMapping(value = "/senderReceiver",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R senderReceiver(HttpServletRequest request){
      try {
          String userId = request.getParameter("userId");
          if(StringUtils.isEmpty(userId)){
              return R.fail("用户信息异常！");
          }
          QueryWrapper<PmSenderReceiver> queryWrapper = new QueryWrapper();
          queryWrapper.eq("USER_ID",Long.valueOf(userId));
          return R.success(pmSenderReceiverService.list(queryWrapper));
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("收发件地址查询失败！");
      }
    }
    /**
     * 收发件地址新增
     */
    @ApiOperation(value = "收发件地址新增",notes = "收发件地址新增")
    @PostMapping(value = "/senderReceiver/save",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R senderReceiverSave(@RequestBody PmSenderReceiverSaveVO saveVO, HttpServletRequest request){
      try {
          if(saveVO==null){
              return R.fail("信息不能为空！");
          }
          return R.success(pmSenderReceiverService.save(saveVO));
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("收发件地址新增失败！");
      }

    }
    /**
     * 收发件地址更新
     */
    @ApiOperation(value = "收发件地址更新",notes = "收发件地址更新")
    @PostMapping(value = "/senderReceiver/update",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R senderReceiverUpdate(@RequestBody PmSenderReceiverUpdateVO updateVO, HttpServletRequest request) {
        try {
            if (updateVO == null) {
                return R.fail("信息不能为空！");
            }
            return R.success(pmSenderReceiverService.updateById(updateVO));
        } catch (Exception e) {
            e.printStackTrace();
            return R.fail("收发件地址更新失败！");
        }
    }
      /**
     * 快递下单接口
     */

    @ApiOperation(value = "快递下单接口",notes = "快递下单接口")
    @PostMapping(value = "/expressage/placeOrder",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R placeOrder(@RequestBody OrderExpress orderExpress){
      try {
         if(orderExpress == null){
             return R.fail("参数异常！");
         }
          return R.success(pmOrderExpressService.insert(orderExpress));
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("下单失败！");
      }

    }
    /**
     * 查询快递预算
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meetingId", value = "会议id", dataType = DATA_TYPE_LONG, paramType = PARAM_TYPE_QUERY),
    })
    @ApiOperation(value = "查询快递预算",notes = "查询快递预算")
    @PostMapping(value = "/expressage/fee",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R expressageFee(@RequestParam Long meetingId){
      try {
          if(meetingId == null){
              return R.fail("会议id不能为空！");
          }
          QueryWrapper<PmConferenceApplyFee> queryWrapper = new QueryWrapper<>();
          queryWrapper.eq("PM_PROJECT_MEETING_APPLY_ID",meetingId);
          List<PmConferenceApplyFee> list = pmConferenceApplyFeeService.list(queryWrapper);
          PmConferenceApplyFee fee = new PmConferenceApplyFee();
          for (PmConferenceApplyFee pmConferenceApplyFee : list) {
              if (pmConferenceApplyFee.getFeeName().equals("快递费用")) {
                  fee = pmConferenceApplyFee;
              }
          }
          return R.success(fee);
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("下单失败！");
      }

    }
    /**
     * 直播频道费用信息
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meetingId", value = "会议id", dataType = DATA_TYPE_LONG, paramType = PARAM_TYPE_QUERY),
    })
    @ApiOperation(value = "直播频道费用信息",notes = "直播频道费用信息")
    @PostMapping(value = "/webcastFee",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R webcastFee(@RequestParam Long meetingId, HttpServletRequest request){
      try {
          if(meetingId == null){
              return R.fail("会议id不能为空！");
          }
          QueryWrapper<PmConferenceApplyFee> queryWrapper = new QueryWrapper<>();
          queryWrapper.eq("PM_PROJECT_MEETING_APPLY_ID",meetingId);
          List<PmConferenceApplyFee> list = pmConferenceApplyFeeService.list(queryWrapper);
          PmConferenceApplyFee fee = new PmConferenceApplyFee();
          for (PmConferenceApplyFee pmConferenceApplyFee : list) {
              if (pmConferenceApplyFee.getFeeName().equals("直播费用")) {
                  fee = pmConferenceApplyFee;
              }
          }
          return R.success(fee);
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("查询费用失败！");
      }

    }

    /**
     * 直播频道申请接口
     */
    @ApiOperation(value = "直播频道申请接口",notes = "直播频道申请接口")
    @PostMapping(value = "/webcastApply",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R webcastApply(@RequestBody PmWebcastSaveVO webcastSaveVO, HttpServletRequest request){
      try {
          if(webcastSaveVO == null){
              return R.fail("直播信息不能为空！");
          }
        pmWebcastService.save(webcastSaveVO);
          return R.success();
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("申请失败！");
      }

    }
    /**
     * 合规材料信息
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "meetingId", value = "会议id", dataType = DATA_TYPE_LONG, paramType = PARAM_TYPE_QUERY),
    })
    @ApiOperation(value = "合规材料信息",notes = "合规材料信息")
    @PostMapping(value = "/meetingMaterials",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R meetingMaterials(@RequestParam Long meetingId, HttpServletRequest request){
      try {
          if(meetingId == null){
              return R.fail("会议id不能为空！");
          }
          //合规材料查询
          List<PmMeetingMaterialsReg> meetingMaterialsRegList = pmMeetingMaterialsRegService.list(Wraps.<PmMeetingMaterialsReg>lbQ()
                  .eq(PmMeetingMaterialsReg::getPmProjectMeetingApplyId, meetingId));
          return R.success(meetingMaterialsRegList);
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("申请失败！");
      }

    }
    /**
     * 合规材料上传
     */
    @ApiOperation(value = "合规材料上传",notes = "合规材料上传")
    @PostMapping(value = "/meetingMaterialsUpload",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R meetingMaterialsUpload(@RequestBody PmMeetingMaterialsRegSaveVO materialsRegSaveVO , HttpServletRequest request, @RequestParam("file") MultipartFile file){
      try {
          if(materialsRegSaveVO == null){
              return R.fail("会议id不能为空！");
          }
          if (file == null || file.isEmpty()) {
              return R.fail("附件不能为空！");
          }
           pmMeetingMaterialsRegService.save(materialsRegSaveVO);
          return R.success();
      }catch (Exception e){
          e.printStackTrace();
          return R.fail("申请失败！");
      }

    }





    /**
     * 会议申请——专家添加——查询
     * @param wPage
     * @decription 会议申请时，1）先查数据库中已经录有专家信息列表，后续（选择想要的一条专家记录）此接口只做到分页查询返回列表
     * @return
     */
    @ApiOperation(value = "会议申请专家查询",notes = "会议申请专家查询")
    @PostMapping(value = "/meetingApplicationExpertQuery",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R<IPage<MsExpertInfoResultVO>> meetingApplicationExpertQuery(@RequestBody WPage wPage){
        IPage page = wPage.getPageParams().buildPage();
        LbQueryWrap<MsExpertInfo> wrap= Wraps.<MsExpertInfo>lbQ()
                .in(MsExpertInfo::getStatus,01,02);
        msExpertInfoService.page(page,wrap);
        IPage voPage = BeanPlusUtil.toBeanPage(page, MsExpertInfoResultVO.class);
        echoService.action(voPage);
        return R.success(voPage,"查询完成");
    }


    /**
     * 会议申请——专家劳务批量修改
     * @param wo
     * @decription
     * @return
     */
    @ApiOperation(value = "专家劳务批量修改",notes = "专家劳务批量修改")
    @PostMapping(value = "/batchUpdateExpertServices",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R meetingApplicationExpertAdd(@RequestBody WO wo){

        String data = wo.getData();
        PmProjectMeetingApplyUpdateVO updateVO = JSONObject.parseObject(data,PmProjectMeetingApplyUpdateVO.class);
        pmProjectMeetingApplyService.updateById(updateVO);
        // 调用方法，传参list与传入meetingApplyId
        //boolean flag = pmConferenceExpertServicesService.batchUpdateExpertServices(list,meetingApplyId);
        if (false){
            return R.success("会议专家劳务信息修改成功");
        }
        return R.fail("会议专家劳务信息修改失败");
    }

    /**
     * 会议申请——专家添加——添加
     * @param wo
     * @decription 弹窗查询的列表没有申请人实际要添加的专家。
     * @return
     */
    @ApiOperation(value = "会议申请专家新增",notes = "会议申请专家新增")
    @PostMapping(value = "/meetingApplicationExpertAdded",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R meetingApplicationExpertAdded(@RequestBody WO wo ){

        // 获取会议申请id 和 MsExpertRelationInfo对象的json串
        String data = wo.getData();
        MsExpertRelationInfo expertRelationInfo = JSONObject.parseObject(data,MsExpertRelationInfo.class);
        if (msExpertInfoService.judgeExpertExit(expertRelationInfo.getName(),expertRelationInfo.getTel())){
            MsExpertInfoSaveVO expertInfoSaveVO = MsExpertInfoSaveVO.builder()
                    .name(expertRelationInfo.getName())
                    .tel(expertRelationInfo.getTel())
                    .workingHospital(expertRelationInfo.getWorkingHospital())
                    .department(expertRelationInfo.getDepartment())
                    .certificateCode(expertRelationInfo.getCertificateCode())
                    .expertProfile(expertRelationInfo.getExpertProfile())
                    .build();
            MsExpertInfo expertInfo = msExpertInfoService.save(expertInfoSaveVO);

            // 获取刚刚存入专家信息表的记录，获取专家id存入子表银行卡表中
            MsExpertBankCardInfoSaveVO bankCardInfoSaveVO = MsExpertBankCardInfoSaveVO.builder()
                    .bankBranchName(expertRelationInfo.getBankBranchName())
                    .account(expertRelationInfo.getAccount())
                    .msExpertInfoId(expertInfo.getId())
                    .build();
            msExpertBankCardInfoService.save(bankCardInfoSaveVO);

            // msExpertInfo加入专家信息的同时，专家劳务表更新一条记录,这条记录关联专家劳务
            //msExpertInfoService.insertExpertRelationInfo(expertInfo,expertServicesId);
            return R.success("添加一个新专家录入会议申请");
        }
        return R.fail("回列表选专家录入会议申请");
    }

    /**
     * 预览发布——专家介绍
     * @param wPage
     * @description 翻页查询当前会议所有专家劳务，且状态是已签署、费用已支付状态。
     * @return
     */
    @ApiOperation(value = "预发布专家列表",notes = "预发布专家列表")
    @PostMapping(value = "/PrePublishExpertList",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R<IPage<PmConferenceExpertServicesResultVO>> PrePublishExpertList(@RequestBody WPage wPage){
        // 获取会议申请id
        long meetingApplyId = wPage.getDataId();
        IPage page = wPage.getPageParams().buildPage();
        LbQueryWrap<PmConferenceExpertServices> wrap= Wraps.<PmConferenceExpertServices>lbQ()
                .notIn(PmConferenceExpertServices::getStatus,01,02)
                .eq(PmConferenceExpertServices::getPmProjectMeetingApplyId,meetingApplyId)
                .isNotNull(PmConferenceExpertServices::getStatus);
        pmConferenceExpertServicesService.page(page,wrap);
        IPage voPage = BeanPlusUtil.toBeanPage(page, PmConferenceExpertServicesResultVO.class);
        echoService.action(voPage);
        return R.success(voPage,"查询完成");
    }

    /**
     * 会议信息——专家劳务列表
     * @param wPage
     * @description 翻页查询当前会议所有专家劳务
     * @return
     */
    @ApiOperation(value = "会议信息专家劳务列表",notes = "会议信息专家劳务列表")
    @PostMapping(value = "/meetingInfoExpertList",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R<IPage<PmConferenceExpertServicesResultVO>> meetingInfoExpertList(@RequestBody WPage wPage){
        // 获取会议申请id
        long meetingApplyId = wPage.getDataId();
        IPage page = wPage.getPageParams().buildPage();
        LbQueryWrap<PmConferenceExpertServices> wrap= Wraps.<PmConferenceExpertServices>lbQ()
                .eq(PmConferenceExpertServices::getPmProjectMeetingApplyId,meetingApplyId);
        pmConferenceExpertServicesService.page(page,wrap);
        IPage voPage = BeanPlusUtil.toBeanPage(page, PmConferenceExpertServicesResultVO.class);
        echoService.action(voPage);
        return R.success(voPage,"查询完成");
    }


    /**
     * 预览发布——专家详情
     * @param wo
     * @description 单体查询
     * @return
     */
    @ApiOperation(value = "专家详情",notes = "专家详情")
    @PostMapping(value = "/expertServicesDetails",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R expertServicesDetails(@RequestBody WO wo){
        // 专家劳务的id查询专家劳务相关具体内容
        long expertServicesId = wo.getDataId();
        long expertInfoId = pmConferenceExpertServicesService.getById(expertServicesId).getMsExpertInfoId();
        // 获取头像，职务，技术职称具体专家信息
        //HashMap<String,Object> map = pmConferenceExpertServicesService.getMoreExpertSpecificInfo(expertInfoId);
        return R.success("查询当前的专家劳务信息");
    }


    /**
     * 设计申请
     * @param wo
     * @description    入参是项目会议申请id，查出多条不同费用名称的会议申请费用记录计算总金额
     * @return
     */
    @ApiOperation(value = "设计申请",notes = "设计申请")
    @PostMapping(value = "/designApplication",produces = "application/json")
    @CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
    public R designApplication(@RequestBody WO wo){

        // 获取会议申请id
        long meetingApplyId = wo.getDataId();
        String meetingApplyName = pmProjectMeetingApplyService.getById(meetingApplyId).getMeetingSupportProjectName();
        // 获取预算剩余金额
        BigDecimal budgetRemainingAmount = pmProjectMeetingApplyService.getById(meetingApplyId).getBudgetRemainingAmount();
        LbQueryWrap<PmConferenceApplyFee> wrap= Wraps.<PmConferenceApplyFee>lbQ()
                .eq(PmConferenceApplyFee::getPmProjectMeetingApplyId,meetingApplyId)
                .eq(PmConferenceApplyFee::getFeeName,"设计费用");
        List<PmConferenceApplyFee> list = pmConferenceApplyFeeService.list(wrap);
        // 调用方法获取设计预算，可支配金额，订单金额
        HashMap<String, Object> map = pmConferenceApplyFeeService.designApplicationAmount(list,budgetRemainingAmount);
        map.put("会议名称",meetingApplyName);
        String json = JSON.toJSONString(map);
        return R.success(json,"拿到设计申请表单内容");
    }
}
