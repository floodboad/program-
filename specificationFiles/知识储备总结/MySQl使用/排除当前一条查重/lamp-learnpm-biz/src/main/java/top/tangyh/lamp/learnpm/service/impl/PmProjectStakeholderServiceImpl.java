package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmProjectStakeholder;
import top.tangyh.lamp.learnpm.manager.PmProjectStakeholderManager;
import top.tangyh.lamp.learnpm.mapper.PmProjectStakeholderMapper;
import top.tangyh.lamp.learnpm.service.PmProjectStakeholderService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectStakeholderPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectStakeholderResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectStakeholderSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectStakeholderUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 项目干系人业务实现类
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmProjectStakeholderServiceImpl extends SuperServiceImpl<PmProjectStakeholderManager, Long, PmProjectStakeholder, PmProjectStakeholderSaveVO, PmProjectStakeholderUpdateVO, PmProjectStakeholderPageQuery, PmProjectStakeholderResultVO>
        implements PmProjectStakeholderService {

    private final PmProjectStakeholderMapper pmProjectStakeholderMapper;

    @Override
    public PmProjectStakeholder getByPhone(String phone) {
        return pmProjectStakeholderMapper.getByPhone(phone);
    }
}
