package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectBudgetInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectBudgetInfo;
import top.tangyh.lamp.learnpm.vo.query.PmProjectBudgetInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectBudgetInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectBudgetInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectBudgetInfoUpdateVO;
/**
 * <p>
 * 项目预算信息业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
public interface PmProjectBudgetInfoService extends SuperService<Long, PmProjectBudgetInfo, PmProjectBudgetInfoSaveVO, PmProjectBudgetInfoUpdateVO, PmProjectBudgetInfoPageQuery, PmProjectBudgetInfoResultVO> {

}
