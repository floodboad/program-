package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;
import top.tangyh.lamp.learnpm.manager.MsWorkExperienceManager;
import top.tangyh.lamp.learnpm.service.MsWorkExperienceService;
import top.tangyh.lamp.learnpm.vo.query.MsWorkExperiencePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsWorkExperienceResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsWorkExperienceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsWorkExperienceUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 工作经历业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsWorkExperienceServiceImpl extends SuperServiceImpl<MsWorkExperienceManager, Long, MsWorkExperience, MsWorkExperienceSaveVO, MsWorkExperienceUpdateVO, MsWorkExperiencePageQuery, MsWorkExperienceResultVO>
        implements MsWorkExperienceService {
    
}
