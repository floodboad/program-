package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOrderExpress;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOrderExpress;
import top.tangyh.lamp.learnpm.vo.query.PmOrderExpressPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOrderExpressResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOrderExpressSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOrderExpressUpdateVO;
import top.tangyh.lamp.learnpm.wechat.OrderExpress;

/**
 * <p>
 * 定快递业务接口
 *
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmOrderExpressService extends SuperService<Long, PmOrderExpress, PmOrderExpressSaveVO, PmOrderExpressUpdateVO, PmOrderExpressPageQuery, PmOrderExpressResultVO> {
    /**
     * 订单新增。
     * m:  会议费用id
     * s：发件人id
     * r: 收件人id
     */
    PmOrderExpress insert(OrderExpress orderExpress) throws Exception;
}
