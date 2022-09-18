package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;
import top.tangyh.lamp.learnpm.manager.PmWkNodeTypeConfManager;
import top.tangyh.lamp.learnpm.service.PmWkNodeTypeConfService;
import top.tangyh.lamp.learnpm.vo.query.PmWkNodeTypeConfPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmWkNodeTypeConfResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmWkNodeTypeConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmWkNodeTypeConfUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.util.List;

/**
 * <p>
 * 工作流节点类型配置业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmWkNodeTypeConfServiceImpl extends SuperServiceImpl<PmWkNodeTypeConfManager, Long, PmWkNodeTypeConf, PmWkNodeTypeConfSaveVO, PmWkNodeTypeConfUpdateVO, PmWkNodeTypeConfPageQuery, PmWkNodeTypeConfResultVO>
        implements PmWkNodeTypeConfService {


}
