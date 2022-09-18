package top.tangyh.lamp.learnpm.service.impl



        ;

import java.util.List;

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.utils.TreeUtil;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.service.MsSecondarySubjectService;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.learnpm.manager.MsSecondarySubjectManager;
import top.tangyh.lamp.learnpm.entity.MsSecondarySubject;
import top.tangyh.lamp.learnpm.vo.save.MsSecondarySubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsSecondarySubjectUpdateVO;
import top.tangyh.lamp.learnpm.vo.result.MsSecondarySubjectResultVO;
import top.tangyh.lamp.learnpm.vo.query.MsSecondarySubjectPageQuery;

/**
 * <p>
 * 业务实现类
 * 二级科目维护
 * </p>
 *
 * @author zuihou
 * @date 2022-06-17 11:55:05
 * @create [2022-06-17 11:55:05] [zuihou] [代码生成器生成]
 */
@Slf4j
@RequiredArgsConstructor
@Service
@DS(DSConstant.DS_LEARN_PW)
@Transactional(readOnly = true)
public class MsSecondarySubjectServiceImpl extends SuperServiceImpl<MsSecondarySubjectManager, Long, MsSecondarySubject, MsSecondarySubjectSaveVO,
    MsSecondarySubjectUpdateVO, MsSecondarySubjectPageQuery, MsSecondarySubjectResultVO> implements MsSecondarySubjectService {

    @Override
    public List<MsSecondarySubject> findTree(MsSecondarySubjectPageQuery query) {
    List<MsSecondarySubject> list = superManager.list(Wraps.<MsSecondarySubject>lbQ().orderByAsc(MsSecondarySubject::getSortValue));
        return TreeUtil.buildTree(list);
    }

}


