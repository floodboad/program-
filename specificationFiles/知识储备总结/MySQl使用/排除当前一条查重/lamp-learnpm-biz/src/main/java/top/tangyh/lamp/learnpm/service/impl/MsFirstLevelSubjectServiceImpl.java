package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsFirstLevelSubject;
import top.tangyh.lamp.learnpm.manager.MsFirstLevelSubjectManager;
import top.tangyh.lamp.learnpm.service.MsFirstLevelSubjectService;
import top.tangyh.lamp.learnpm.vo.query.MsFirstLevelSubjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsFirstLevelSubjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsFirstLevelSubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsFirstLevelSubjectUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 一级科目维护业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsFirstLevelSubjectServiceImpl extends SuperServiceImpl<MsFirstLevelSubjectManager, Long, MsFirstLevelSubject, MsFirstLevelSubjectSaveVO, MsFirstLevelSubjectUpdateVO, MsFirstLevelSubjectPageQuery, MsFirstLevelSubjectResultVO>
        implements MsFirstLevelSubjectService {
    
}
