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
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;
import top.tangyh.lamp.learnpm.service.MsLongzhuExpenseTypeService;
import top.tangyh.lamp.learnpm.vo.query.MsLongzhuExpenseTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsLongzhuExpenseTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsLongzhuExpenseTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsLongzhuExpenseTypeUpdateVO;

/**
 * <p>
 * 七龙珠费用类型设置前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msLongzhuExpenseType")
@Api(value = "MsLongzhuExpenseType", tags = " 七龙珠费用类型设置")
public class MsLongzhuExpenseTypeController extends SuperController<MsLongzhuExpenseTypeService, Long, MsLongzhuExpenseType, MsLongzhuExpenseTypeSaveVO, MsLongzhuExpenseTypeUpdateVO, MsLongzhuExpenseTypePageQuery, MsLongzhuExpenseTypeResultVO> {


    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }
}
