package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmOrderFoodMapper;
import top.tangyh.lamp.learnpm.entity.PmOrderFood;
import top.tangyh.lamp.learnpm.manager.PmOrderFoodManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 订餐Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmOrderFoodManagerImpl extends SuperManagerImpl<PmOrderFoodMapper, PmOrderFood> implements PmOrderFoodManager {

}
