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
import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import top.tangyh.lamp.learnpm.service.MsContactInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsContactInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsContactInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsContactInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsContactInfoUpdateVO;

/**
 * <p>
 * 联系人信息前端控制器
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
@RequestMapping("/msContactInfo")
@Api(value = "MsContactInfo", tags = " 联系人信息")
public class MsContactInfoController extends SuperController<MsContactInfoService, Long, MsContactInfo, MsContactInfoSaveVO, MsContactInfoUpdateVO, MsContactInfoPageQuery, MsContactInfoResultVO> {

    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
