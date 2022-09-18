package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsBudgetSubject;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsBudgetSubject;
import top.tangyh.lamp.learnpm.vo.query.MsBudgetSubjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsBudgetSubjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsBudgetSubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsBudgetSubjectUpdateVO;
/**
 * <p>
 * 预算科目业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
public interface MsBudgetSubjectService extends SuperService<Long, MsBudgetSubject, MsBudgetSubjectSaveVO, MsBudgetSubjectUpdateVO, MsBudgetSubjectPageQuery, MsBudgetSubjectResultVO> {

    // 获取预算科目和二级科目的id xucl
    MsBudgetSubject getIds(String subjectName, String SecondarySubjectName);
}
