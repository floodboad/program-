package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOrderFood;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOrderFood;
import top.tangyh.lamp.learnpm.vo.query.PmOrderFoodPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOrderFoodResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderFoodSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOrderFoodUpdateVO;
/**
 * <p>
 * 订餐业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
public interface PmOrderFoodService extends SuperService<Long, PmOrderFood, PmOrderFoodSaveVO, PmOrderFoodUpdateVO, PmOrderFoodPageQuery, PmOrderFoodResultVO> {
    PmOrderFoodSaveVO orderFood(Long applyId);
}
