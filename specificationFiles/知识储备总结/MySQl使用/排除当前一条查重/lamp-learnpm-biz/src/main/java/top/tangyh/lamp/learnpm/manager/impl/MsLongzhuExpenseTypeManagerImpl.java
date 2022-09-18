package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsLongzhuExpenseTypeMapper;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;
import top.tangyh.lamp.learnpm.manager.MsLongzhuExpenseTypeManager;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 七龙珠费用类型设置Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-28
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsLongzhuExpenseTypeManagerImpl extends SuperManagerImpl<MsLongzhuExpenseTypeMapper, MsLongzhuExpenseType> implements MsLongzhuExpenseTypeManager {

    @Autowired
    private MsLongzhuExpenseTypeMapper msLongzhuExpenseTypeMapper;

    @Override
    public ArrayList<String> returnFeeNameList() {
        return msLongzhuExpenseTypeMapper.returnFeeNameList();
    }
}
