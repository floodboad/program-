package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsDepartmentInfo;
import top.tangyh.lamp.learnpm.manager.MsDepartmentInfoManager;
import top.tangyh.lamp.learnpm.service.MsDepartmentInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsDepartmentInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsDepartmentInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsDepartmentInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsDepartmentInfoUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 科室信息业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-13
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsDepartmentInfoServiceImpl extends SuperServiceImpl<MsDepartmentInfoManager, Long, MsDepartmentInfo, MsDepartmentInfoSaveVO, MsDepartmentInfoUpdateVO, MsDepartmentInfoPageQuery, MsDepartmentInfoResultVO>
        implements MsDepartmentInfoService {
    
}
