package top.tangyh.lamp.learnpm.controller;


import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tangyh.basic.base.R;
import top.tangyh.lamp.com.meituan.sqt.client.SqtService;
import top.tangyh.lamp.com.meituan.sqt.enums.StaffIdType;
import top.tangyh.lamp.com.meituan.sqt.h5.SqtH5Service;
import top.tangyh.lamp.com.meituan.sqt.request.staff.StaffInfo;
import top.tangyh.lamp.com.meituan.sqt.request.staff.StaffBatchAddReq;
import top.tangyh.lamp.com.meituan.sqt.request.staff.StaffBatchQueryReq;
import top.tangyh.lamp.com.meituan.sqt.response.StaffBatchAddResp;
import top.tangyh.lamp.com.meituan.sqt.utils.JsonUtil;

import java.util.Arrays;
import java.util.List;

/**
 * @Class: SqtController
 * @Author: MrSnow
 * @Date: 2022/6/16 10:58
 */
@Slf4j
@RestController
@RequestMapping(value = "/meituan")
@Api(value = "sqtTest",tags = "商企通测试")
public class SqtController {
    @Autowired
    private SqtService sqtService;
    @Autowired
    private SqtH5Service sqtH5Service;

    @PostMapping(value = "/ReceivePush")
    public R receiveTripApplyPush(Object obj){
        return null;
    }
    /**
     * 测试用
     * @return
     */
    @PostMapping(value = "/SqtApi")
    public String testApi() {
        StaffBatchQueryReq req = new StaffBatchQueryReq();
        req.setStaffIdType(StaffIdType.PHONE_TYPE.getCode());
        req.setStaffIdentifiers(Arrays.asList("18838938925", "18010032569"));
        String result = sqtService.batchQueryStaff(req);
        System.out.println(result);
        return result;
    }
    @PostMapping(value = "/Register")
    public String Register(List<StaffInfo> staffInfos ){
        StaffBatchAddReq req = new StaffBatchAddReq();
//        StaffInfo staffInfo = new StaffInfo();
//        staffInfo.setPhone("18010032569");
//        staffInfo.setName("张三");
//        staffInfo.setCity("北京");
//        staffInfos.add(staffInfo);
        String result = sqtService.batchAddStaff(req);
        StaffBatchAddResp resp = JsonUtil.json2Object(result, StaffBatchAddResp.class);
        return result ;
    }

    /**
     * 测试用
     * @param staffPhoneNo   免登美团app的手机号，手机号注册需要通过sqtApi录入商企通。
     * @param productType    在ProductType接口中选择
     * @return
     */
    @PostMapping(value = "/SqtH5")
    public String testH5(String staffPhoneNo,String productType){
        return sqtH5Service.getH5Url(staffPhoneNo,productType);
    }




}
