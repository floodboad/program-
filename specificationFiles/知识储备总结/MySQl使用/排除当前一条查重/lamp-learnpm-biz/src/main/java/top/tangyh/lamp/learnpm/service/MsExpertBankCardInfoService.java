package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpertBankCardInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpertBankCardInfo;
import top.tangyh.lamp.learnpm.vo.query.MsExpertBankCardInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpertBankCardInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpertBankCardInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpertBankCardInfoUpdateVO;
/**
 * <p>
 * 专家银行卡信息业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
public interface MsExpertBankCardInfoService extends SuperService<Long, MsExpertBankCardInfo, MsExpertBankCardInfoSaveVO, MsExpertBankCardInfoUpdateVO, MsExpertBankCardInfoPageQuery, MsExpertBankCardInfoResultVO> {

}
