package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsBudgetSubjectMapper;
import top.tangyh.lamp.learnpm.entity.MsBudgetSubject;
import top.tangyh.lamp.learnpm.manager.MsBudgetSubjectManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 预算科目Manager
 * </p>
 *
 * @author zyq
 * @date 2022-06-22
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsBudgetSubjectManagerImpl extends SuperManagerImpl<MsBudgetSubjectMapper, MsBudgetSubject> implements MsBudgetSubjectManager {

}
