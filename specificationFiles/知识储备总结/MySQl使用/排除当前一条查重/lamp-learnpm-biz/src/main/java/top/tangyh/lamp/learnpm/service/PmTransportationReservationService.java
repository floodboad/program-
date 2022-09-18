package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmTransportationReservation;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmTransportationReservation;
import top.tangyh.lamp.learnpm.vo.query.PmTransportationReservationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmTransportationReservationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmTransportationReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmTransportationReservationUpdateVO;
/**
 * <p>
 * 交通预定业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmTransportationReservationService extends SuperService<Long, PmTransportationReservation, PmTransportationReservationSaveVO, PmTransportationReservationUpdateVO, PmTransportationReservationPageQuery, PmTransportationReservationResultVO> {
    PmTransportationReservationSaveVO orderCar(Long id);
}
