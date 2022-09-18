package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import top.tangyh.lamp.learnpm.manager.MsContactInfoManager;
import top.tangyh.lamp.learnpm.service.MsContactInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsContactInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsContactInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsContactInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsContactInfoUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 联系人信息业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsContactInfoServiceImpl extends SuperServiceImpl<MsContactInfoManager, Long, MsContactInfo, MsContactInfoSaveVO, MsContactInfoUpdateVO, MsContactInfoPageQuery, MsContactInfoResultVO>
        implements MsContactInfoService {
    
}
