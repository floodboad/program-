package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmSenderReceiverMapper;
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;
import top.tangyh.lamp.learnpm.manager.PmSenderReceiverManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 收发件人Manager
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmSenderReceiverManagerImpl extends SuperManagerImpl<PmSenderReceiverMapper, PmSenderReceiver> implements PmSenderReceiverManager {

}
