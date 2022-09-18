package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterials;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmComplianceMaterials;
import top.tangyh.lamp.learnpm.vo.query.PmComplianceMaterialsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmComplianceMaterialsResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmComplianceMaterialsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmComplianceMaterialsUpdateVO;
/**
 * <p>
 * 项目合规材料业务接口
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-28
 */
public interface PmComplianceMaterialsService extends SuperService<Long, PmComplianceMaterials, PmComplianceMaterialsSaveVO, PmComplianceMaterialsUpdateVO, PmComplianceMaterialsPageQuery, PmComplianceMaterialsResultVO> {

}
