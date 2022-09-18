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
import top.tangyh.lamp.learnpm.entity.PmDesignRequirement;
import top.tangyh.lamp.learnpm.service.PmDesignRequirementService;
import top.tangyh.lamp.learnpm.vo.query.PmDesignRequirementPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmDesignRequirementResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmDesignRequirementSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmDesignRequirementUpdateVO;

/**
 * <p>
 * 设计要求前端控制器
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/pmDesignRequirement")
@Api(value = "PmDesignRequirement", tags = " 设计要求")
public class PmDesignRequirementController extends SuperController<PmDesignRequirementService, Long, PmDesignRequirement, PmDesignRequirementSaveVO, PmDesignRequirementUpdateVO, PmDesignRequirementPageQuery, PmDesignRequirementResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
