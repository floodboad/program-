package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandard;
import top.tangyh.lamp.learnpm.manager.PmExpertServiceStandardManager;
import top.tangyh.lamp.learnpm.service.PmExpertServiceStandardService;
import top.tangyh.lamp.learnpm.vo.query.PmExpertServiceStandardPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertServiceStandardResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.util.List;

/**
 * <p>
 * 会议规划专家劳务标准业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmExpertServiceStandardServiceImpl extends SuperServiceImpl<PmExpertServiceStandardManager, Long, PmExpertServiceStandard, PmExpertServiceStandardSaveVO, PmExpertServiceStandardUpdateVO, PmExpertServiceStandardPageQuery, PmExpertServiceStandardResultVO>
        implements PmExpertServiceStandardService {
    /**
     * @author dz
     * @date 2022-06-27
     * @param id 会议规划id
     * @return 专家劳务标准列
     */
    @Override
    public List<PmExpertServiceStandard> getExpertServiceStandards(Long id) {
        List<PmExpertServiceStandard> list = superManager.list(Wraps.<PmExpertServiceStandard>lbQ()
                                    .eq(PmExpertServiceStandard::getPmProjectMeetingPlanningId, id));
        return list;
    }
}
