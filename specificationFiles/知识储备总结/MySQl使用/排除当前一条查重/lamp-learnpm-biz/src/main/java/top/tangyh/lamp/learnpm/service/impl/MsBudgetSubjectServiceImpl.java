package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsBudgetSubject;
import top.tangyh.lamp.learnpm.manager.MsBudgetSubjectManager;
import top.tangyh.lamp.learnpm.service.MsBudgetSubjectService;
import top.tangyh.lamp.learnpm.vo.query.MsBudgetSubjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsBudgetSubjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsBudgetSubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsBudgetSubjectUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.util.List;

/**
 * <p>
 * 预算科目业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsBudgetSubjectServiceImpl extends SuperServiceImpl<MsBudgetSubjectManager, Long, MsBudgetSubject, MsBudgetSubjectSaveVO, MsBudgetSubjectUpdateVO, MsBudgetSubjectPageQuery, MsBudgetSubjectResultVO>
        implements MsBudgetSubjectService {
    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsBudgetSubject getIds(String subjectName, String SecondarySubjectName){
        List<MsBudgetSubject> list = superManager.list(Wraps.<MsBudgetSubject>lbQ().eq(MsBudgetSubject::getSubjectName, subjectName)
                .eq(MsBudgetSubject::getSecondarySubjectName, SecondarySubjectName));
        if(CollectionUtils.isEmpty(list)){
            R.fail("没有找到和"+subjectName+","+SecondarySubjectName+"相关的信息！");
        }
        MsBudgetSubject msBudgetSubject = list.get(0);
        return msBudgetSubject;
    }
    
}
