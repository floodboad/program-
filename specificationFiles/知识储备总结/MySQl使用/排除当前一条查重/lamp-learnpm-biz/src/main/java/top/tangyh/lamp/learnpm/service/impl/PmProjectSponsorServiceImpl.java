package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmProjectSponsor;
import top.tangyh.lamp.learnpm.manager.PmProjectSponsorManager;
import top.tangyh.lamp.learnpm.service.PmProjectSponsorService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectSponsorPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectSponsorResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSponsorSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectSponsorUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目赞助企业业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmProjectSponsorServiceImpl extends SuperServiceImpl<PmProjectSponsorManager, Long, PmProjectSponsor, PmProjectSponsorSaveVO, PmProjectSponsorUpdateVO, PmProjectSponsorPageQuery, PmProjectSponsorResultVO>
        implements PmProjectSponsorService {
    
}
