package top.tangyh.lamp.learnpm.service;

import java.util.List;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsSecondarySubject;
import top.tangyh.lamp.learnpm.vo.save.MsSecondarySubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsSecondarySubjectUpdateVO;
import top.tangyh.lamp.learnpm.vo.result.MsSecondarySubjectResultVO;
import top.tangyh.lamp.learnpm.vo.query.MsSecondarySubjectPageQuery;


/**
 * <p>
 * 业务接口
 * 二级科目维护
 * </p>
 *
 * @author zuihou
 * @date 2022-06-17 11:55:05
 * @create [2022-06-17 11:55:05] [zuihou] [代码生成器生成]
 */
public interface MsSecondarySubjectService extends SuperService<Long, MsSecondarySubject, MsSecondarySubjectSaveVO,
    MsSecondarySubjectUpdateVO, MsSecondarySubjectPageQuery, MsSecondarySubjectResultVO> {

    /**
     * 查询树结构
     *
     * @param query 参数
     * @return 树
     */
    List<MsSecondarySubject> findTree(MsSecondarySubjectPageQuery query);
}


