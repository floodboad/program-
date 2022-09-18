package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;
import top.tangyh.lamp.learnpm.manager.PmMeetingMaterialsRegManager;
import top.tangyh.lamp.learnpm.service.PmMeetingMaterialsRegService;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingMaterialsRegPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingMaterialsRegResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingMaterialsRegSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingMaterialsRegUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 会议合规材料登记业务实现类
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmMeetingMaterialsRegServiceImpl extends SuperServiceImpl<PmMeetingMaterialsRegManager, Long, PmMeetingMaterialsReg, PmMeetingMaterialsRegSaveVO, PmMeetingMaterialsRegUpdateVO, PmMeetingMaterialsRegPageQuery, PmMeetingMaterialsRegResultVO>
        implements PmMeetingMaterialsRegService {
    
}
