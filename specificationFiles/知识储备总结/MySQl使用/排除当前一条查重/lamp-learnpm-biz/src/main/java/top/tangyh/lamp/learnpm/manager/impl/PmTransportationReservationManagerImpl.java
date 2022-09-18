package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmTransportationReservationMapper;
import top.tangyh.lamp.learnpm.entity.PmTransportationReservation;
import top.tangyh.lamp.learnpm.manager.PmTransportationReservationManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 交通预定Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmTransportationReservationManagerImpl extends SuperManagerImpl<PmTransportationReservationMapper, PmTransportationReservation> implements PmTransportationReservationManager {

}
