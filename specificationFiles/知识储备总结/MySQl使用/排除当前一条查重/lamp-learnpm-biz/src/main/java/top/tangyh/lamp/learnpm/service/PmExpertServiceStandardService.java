package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandard;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandard;
import top.tangyh.lamp.learnpm.vo.query.PmExpertServiceStandardPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertServiceStandardResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardUpdateVO;

import java.util.List;

/**
 * <p>
 * 会议规划专家劳务标准业务接口
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmExpertServiceStandardService extends SuperService<Long, PmExpertServiceStandard, PmExpertServiceStandardSaveVO, PmExpertServiceStandardUpdateVO, PmExpertServiceStandardPageQuery, PmExpertServiceStandardResultVO> {
    List<PmExpertServiceStandard> getExpertServiceStandards(Long id);
}
