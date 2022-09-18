package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmOrderExpressMapper;
import top.tangyh.lamp.learnpm.entity.PmOrderExpress;
import top.tangyh.lamp.learnpm.manager.PmOrderExpressManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 定快递Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmOrderExpressManagerImpl extends SuperManagerImpl<PmOrderExpressMapper, PmOrderExpress> implements PmOrderExpressManager {

}
