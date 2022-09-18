package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmHotelReservationMapper;
import top.tangyh.lamp.learnpm.entity.PmHotelReservation;
import top.tangyh.lamp.learnpm.manager.PmHotelReservationManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 订酒店Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmHotelReservationManagerImpl extends SuperManagerImpl<PmHotelReservationMapper, PmHotelReservation> implements PmHotelReservationManager {

}
