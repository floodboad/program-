package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.awt.geom.AreaOp;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.service.MsExpertInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsExpertInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpertInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpertInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpertInfoUpdateVO;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 * 专家信息前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msExpertInfo")
@Api(value = "MsExpertInfo", tags = " 专家信息")
public class MsExpertInfoController extends SuperController<MsExpertInfoService, Long, MsExpertInfo, MsExpertInfoSaveVO, MsExpertInfoUpdateVO, MsExpertInfoPageQuery, MsExpertInfoResultVO> {

    private final MsExpertInfoService msExpertInfoService;
    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    @RequestMapping("/queryHospitalInfoDept")
    public Map<String,ArrayList<String>> queryHospitalDeptInfo(){
        // 获取医院信息和科室信息
        Map<String,ArrayList<String>> map = msExpertInfoService.queryHospitalDeptInfo();
        return null;
    }


}
