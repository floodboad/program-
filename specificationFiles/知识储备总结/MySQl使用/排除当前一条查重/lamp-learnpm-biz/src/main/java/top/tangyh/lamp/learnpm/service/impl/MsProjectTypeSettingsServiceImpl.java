package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.MsProjectTypeSettings;
import top.tangyh.lamp.learnpm.manager.MsProjectTypeSettingsManager;
import top.tangyh.lamp.learnpm.service.MsProjectTypeSettingsService;
import top.tangyh.lamp.learnpm.vo.query.MsProjectTypeSettingsPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsProjectTypeSettingsResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsProjectTypeSettingsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsProjectTypeSettingsUpdateVO;
/**
 * <p>
 * 项目类型设置业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsProjectTypeSettingsServiceImpl extends SuperServiceImpl<MsProjectTypeSettingsManager, Long, MsProjectTypeSettings, MsProjectTypeSettingsSaveVO, MsProjectTypeSettingsUpdateVO, MsProjectTypeSettingsPageQuery, MsProjectTypeSettingsResultVO>
        implements MsProjectTypeSettingsService {
    
}
