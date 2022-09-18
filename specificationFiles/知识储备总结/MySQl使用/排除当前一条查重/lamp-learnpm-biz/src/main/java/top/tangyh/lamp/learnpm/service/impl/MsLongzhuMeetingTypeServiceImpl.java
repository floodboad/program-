package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsLongzhuExpenseType;
import top.tangyh.lamp.learnpm.entity.MsLongzhuMeetingType;
import top.tangyh.lamp.learnpm.manager.MsLongzhuExpenseTypeManager;
import top.tangyh.lamp.learnpm.manager.MsLongzhuMeetingTypeManager;
import top.tangyh.lamp.learnpm.service.MsLongzhuExpenseTypeService;
import top.tangyh.lamp.learnpm.service.MsLongzhuMeetingTypeService;
import top.tangyh.lamp.learnpm.vo.query.MsLongzhuMeetingTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsLongzhuMeetingTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsLongzhuMeetingTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsLongzhuMeetingTypeUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.system.entity.application.DefApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 会议类型七龙珠配置业务实现类
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
public class MsLongzhuMeetingTypeServiceImpl extends SuperServiceImpl<MsLongzhuMeetingTypeManager, Long, MsLongzhuMeetingType, MsLongzhuMeetingTypeSaveVO, MsLongzhuMeetingTypeUpdateVO, MsLongzhuMeetingTypePageQuery, MsLongzhuMeetingTypeResultVO>
        implements MsLongzhuMeetingTypeService {

    @Autowired
    private MsLongzhuExpenseTypeManager msLongzhuExpenseTypeManager;

    @Override
    public ArrayList<String> returnFeeNameList() {
        //List<MsLongzhuExpenseType> list = list(Wraps.<DefApplication>lbQ().orderByAsc(MsLongzhuExpenseType::getId));
        //List<String> applicationIdList = list.stream().map(MsLongzhuExpenseType::getId).collect(Collectors.toList());

        // 获取所有FEE_NAME的数据
        ArrayList<String> list = msLongzhuExpenseTypeManager.returnFeeNameList();
        return list;
    }
}
