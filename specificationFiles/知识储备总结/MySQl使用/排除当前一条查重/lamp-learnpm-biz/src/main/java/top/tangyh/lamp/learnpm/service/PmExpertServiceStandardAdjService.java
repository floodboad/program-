package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandardAdj;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmExpertServiceStandardAdj;
import top.tangyh.lamp.learnpm.vo.query.PmExpertServiceStandardAdjPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmExpertServiceStandardAdjResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardAdjSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardAdjUpdateVO;
/**
 * <p>
 * 会议规划专家劳务标准调整记录业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmExpertServiceStandardAdjService extends SuperService<Long, PmExpertServiceStandardAdj, PmExpertServiceStandardAdjSaveVO, PmExpertServiceStandardAdjUpdateVO, PmExpertServiceStandardAdjPageQuery, PmExpertServiceStandardAdjResultVO> {

}
