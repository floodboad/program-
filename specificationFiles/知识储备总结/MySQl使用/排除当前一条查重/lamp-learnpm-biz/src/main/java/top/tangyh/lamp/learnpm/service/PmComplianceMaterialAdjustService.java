package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterialAdjust;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterialAdjust;
import top.tangyh.lamp.learnpm.vo.query.PmComplianceMaterialAdjustPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmComplianceMaterialAdjustResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialAdjustSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialAdjustUpdateVO;
/**
 * <p>
 * 项目合规材料调整业务接口
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
public interface PmComplianceMaterialAdjustService extends SuperService<Long, PmComplianceMaterialAdjust, PmComplianceMaterialAdjustSaveVO, PmComplianceMaterialAdjustUpdateVO, PmComplianceMaterialAdjustPageQuery, PmComplianceMaterialAdjustResultVO> {

}
