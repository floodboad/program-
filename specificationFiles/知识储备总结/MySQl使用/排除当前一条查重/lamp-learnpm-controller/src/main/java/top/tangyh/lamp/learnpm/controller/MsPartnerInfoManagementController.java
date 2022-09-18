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
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.entity.MsPartnerInfoManagement;
import top.tangyh.lamp.learnpm.service.MsPartnerInfoManagementService;
import top.tangyh.lamp.learnpm.vo.query.MsPartnerInfoManagementPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsPartnerInfoManagementResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsPartnerInfoManagementSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsPartnerInfoManagementUpdateVO;

/**
 * <p>
 * 合作方信息管理前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/msPartnerInfoManagement")
@Api(value = "MsPartnerInfoManagement", tags = " 合作方信息管理")
public class MsPartnerInfoManagementController extends SuperController<MsPartnerInfoManagementService, Long, MsPartnerInfoManagement, MsPartnerInfoManagementSaveVO, MsPartnerInfoManagementUpdateVO, MsPartnerInfoManagementPageQuery, MsPartnerInfoManagementResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
