package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmHotelReservation;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmHotelReservation;
import top.tangyh.lamp.learnpm.vo.query.PmHotelReservationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmHotelReservationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmHotelReservationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmHotelReservationUpdateVO;
/**
 * <p>
 * 订酒店业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmHotelReservationService extends SuperService<Long, PmHotelReservation, PmHotelReservationSaveVO, PmHotelReservationUpdateVO, PmHotelReservationPageQuery, PmHotelReservationResultVO> {
    PmHotelReservationSaveVO orderHotel(Long id);
}
