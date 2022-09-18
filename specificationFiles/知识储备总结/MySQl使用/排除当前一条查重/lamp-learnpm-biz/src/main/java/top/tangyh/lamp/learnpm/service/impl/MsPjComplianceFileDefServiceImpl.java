package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsPjComplianceFileDef;
import top.tangyh.lamp.learnpm.manager.MsPjComplianceFileDefManager;
import top.tangyh.lamp.learnpm.service.MsPjComplianceFileDefService;
import top.tangyh.lamp.learnpm.vo.query.MsPjComplianceFileDefPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsPjComplianceFileDefResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsPjComplianceFileDefSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsPjComplianceFileDefUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目合规文件定义业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsPjComplianceFileDefServiceImpl extends SuperServiceImpl<MsPjComplianceFileDefManager, Long, MsPjComplianceFileDef, MsPjComplianceFileDefSaveVO, MsPjComplianceFileDefUpdateVO, MsPjComplianceFileDefPageQuery, MsPjComplianceFileDefResultVO>
        implements MsPjComplianceFileDefService {
    
}
