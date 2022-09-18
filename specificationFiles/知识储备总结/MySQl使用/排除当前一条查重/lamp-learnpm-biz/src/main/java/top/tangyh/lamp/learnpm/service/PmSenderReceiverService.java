package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmSenderReceiver;
import top.tangyh.lamp.learnpm.vo.query.PmSenderReceiverPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmSenderReceiverResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmSenderReceiverSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmSenderReceiverUpdateVO;
/**
 * <p>
 * 收发件人业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
public interface PmSenderReceiverService extends SuperService<Long, PmSenderReceiver, PmSenderReceiverSaveVO, PmSenderReceiverUpdateVO, PmSenderReceiverPageQuery, PmSenderReceiverResultVO> {

}
