package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMaterialProduction;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMaterialProduction;
import top.tangyh.lamp.learnpm.vo.query.PmMaterialProductionPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMaterialProductionResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMaterialProductionSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMaterialProductionUpdateVO;
/**
 * <p>
 * 物料制作业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmMaterialProductionService extends SuperService<Long, PmMaterialProduction, PmMaterialProductionSaveVO, PmMaterialProductionUpdateVO, PmMaterialProductionPageQuery, PmMaterialProductionResultVO> {

}
