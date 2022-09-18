package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectStakeholder;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectStakeholder;
import top.tangyh.lamp.learnpm.vo.query.PmProjectStakeholderPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectStakeholderResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectStakeholderSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectStakeholderUpdateVO;
/**
 * <p>
 * 项目干系人业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmProjectStakeholderService extends SuperService<Long, PmProjectStakeholder, PmProjectStakeholderSaveVO, PmProjectStakeholderUpdateVO, PmProjectStakeholderPageQuery, PmProjectStakeholderResultVO> {
    PmProjectStakeholder getByPhone(String phone);
}
