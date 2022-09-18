package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsExecutionSessionType;
import top.tangyh.lamp.learnpm.manager.MsExecutionSessionTypeManager;
import top.tangyh.lamp.learnpm.service.MsExecutionSessionTypeService;
import top.tangyh.lamp.learnpm.vo.query.MsExecutionSessionTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExecutionSessionTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExecutionSessionTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExecutionSessionTypeUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 执行场次类型业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsExecutionSessionTypeServiceImpl extends SuperServiceImpl<MsExecutionSessionTypeManager, Long, MsExecutionSessionType, MsExecutionSessionTypeSaveVO, MsExecutionSessionTypeUpdateVO, MsExecutionSessionTypePageQuery, MsExecutionSessionTypeResultVO>
        implements MsExecutionSessionTypeService {
    
}
