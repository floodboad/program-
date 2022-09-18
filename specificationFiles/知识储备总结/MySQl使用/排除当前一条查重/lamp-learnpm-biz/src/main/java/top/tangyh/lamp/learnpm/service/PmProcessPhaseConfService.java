package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.vo.query.PmProcessPhaseConfPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseConfResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseConfUpdateVO;
/**
 * <p>
 * 流程环节配置业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
public interface PmProcessPhaseConfService extends SuperService<Long, PmProcessPhaseConf, PmProcessPhaseConfSaveVO, PmProcessPhaseConfUpdateVO, PmProcessPhaseConfPageQuery, PmProcessPhaseConfResultVO> {

    // 流程环节id控制环节次序，同一流程id下不能有相同环节次序
    Boolean controlLinkIdCheck(PmProcessPhaseConfSaveVO pmProcessPhaseConfSaveVO);


    // 流程环节的是否结束字段的一些要求：不为空，且只能有一个结束节点，内容是（0或1），
    Boolean isEndrequirements(PmProcessPhaseConfSaveVO pmProcessPhaseConfSaveVO);
}
