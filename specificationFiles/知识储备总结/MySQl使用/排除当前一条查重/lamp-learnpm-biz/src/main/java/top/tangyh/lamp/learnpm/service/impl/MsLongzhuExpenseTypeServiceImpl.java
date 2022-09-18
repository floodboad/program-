package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;
import top.tangyh.lamp.learnpm.manager.MsLongzhuExpenseTypeManager;
import top.tangyh.lamp.learnpm.service.MsLongzhuExpenseTypeService;
import top.tangyh.lamp.learnpm.vo.query.MsLongzhuExpenseTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsLongzhuExpenseTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsLongzhuExpenseTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsLongzhuExpenseTypeUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
/**
 * <p>
 * 七龙珠费用类型设置业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsLongzhuExpenseTypeServiceImpl extends SuperServiceImpl<MsLongzhuExpenseTypeManager, Long, MsLongzhuExpenseType, MsLongzhuExpenseTypeSaveVO, MsLongzhuExpenseTypeUpdateVO, MsLongzhuExpenseTypePageQuery, MsLongzhuExpenseTypeResultVO>
        implements MsLongzhuExpenseTypeService {
    
}
