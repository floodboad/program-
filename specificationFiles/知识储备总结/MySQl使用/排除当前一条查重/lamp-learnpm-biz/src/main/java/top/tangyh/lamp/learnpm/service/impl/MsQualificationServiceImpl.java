package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsQualification;
import top.tangyh.lamp.learnpm.manager.MsQualificationManager;
import top.tangyh.lamp.learnpm.service.MsQualificationService;
import top.tangyh.lamp.learnpm.vo.query.MsQualificationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsQualificationResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsQualificationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsQualificationUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 资格证书业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsQualificationServiceImpl extends SuperServiceImpl<MsQualificationManager, Long, MsQualification, MsQualificationSaveVO, MsQualificationUpdateVO, MsQualificationPageQuery, MsQualificationResultVO>
        implements MsQualificationService {
    
}
