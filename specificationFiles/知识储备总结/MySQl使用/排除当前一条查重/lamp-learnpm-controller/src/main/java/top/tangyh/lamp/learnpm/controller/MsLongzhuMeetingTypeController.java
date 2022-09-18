package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.tangyh.basic.annotation.constraints.NotEmptyPattern;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.entity.MsLongzhuMeetingType;
import top.tangyh.lamp.learnpm.service.MsLongzhuMeetingTypeService;
import top.tangyh.lamp.learnpm.vo.query.MsLongzhuMeetingTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsLongzhuMeetingTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsLongzhuMeetingTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsLongzhuMeetingTypeUpdateVO;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 会议类型七龙珠配置前端控制器
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
@RequestMapping("/msLongzhuMeetingType")
@Api(value = "MsLongzhuMeetingType", tags = " 会议类型七龙珠配置")
public class MsLongzhuMeetingTypeController extends SuperController<MsLongzhuMeetingTypeService, Long, MsLongzhuMeetingType, MsLongzhuMeetingTypeSaveVO, MsLongzhuMeetingTypeUpdateVO, MsLongzhuMeetingTypePageQuery, MsLongzhuMeetingTypeResultVO> {

    private final MsLongzhuMeetingTypeService msLongzhuMeetingTypeService;
    private final EchoService echoService;
    
    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    @RequestMapping("returnFeeName")
    public ArrayList<String> returnFeeName(){
        // 返回七龙珠类型的所有费用的名称
        ArrayList<String> list = msLongzhuMeetingTypeService.returnFeeNameList();
        return list;
    }
}
