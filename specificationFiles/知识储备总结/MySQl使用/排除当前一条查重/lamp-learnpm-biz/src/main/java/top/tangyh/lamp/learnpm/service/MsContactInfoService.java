package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import top.tangyh.lamp.learnpm.vo.query.MsContactInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsContactInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsContactInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsContactInfoUpdateVO;
/**
 * <p>
 * 联系人信息业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
public interface MsContactInfoService extends SuperService<Long, MsContactInfo, MsContactInfoSaveVO, MsContactInfoUpdateVO, MsContactInfoPageQuery, MsContactInfoResultVO> {

}
