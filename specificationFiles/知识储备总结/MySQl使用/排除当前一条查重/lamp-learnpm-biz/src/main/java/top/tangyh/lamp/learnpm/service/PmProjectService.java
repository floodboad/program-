package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProject;
import top.tangyh.lamp.learnpm.vo.query.PmProjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectUpdateVO;
import top.tangyh.lamp.learnpm.wechat.WO;

import top.tangyh.lamp.workflow.vo.AuditVO;

import java.util.List;

/**
 * <p>
 * 项目信息业务接口
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmProjectService extends SuperService<Long, PmProject, PmProjectSaveVO, PmProjectUpdateVO, PmProjectPageQuery, PmProjectResultVO> {
    /**
     * 项目立项新增。
     */
    void insert(PmProjectSaveVO saveVO) throws Exception;
    /**
     * 项目立项修改。
     */
    void update(PmProjectUpdateVO updateVO) throws Exception;
    /**
     *审批回调接口（通过不通过专用）
     */
    void audit(AuditVO auditVO) throws Exception;


    Object getPmProjectList(WO wo);
    /**
     * 项目调整
     */
    void projectAdjust(PmProjectUpdateVO updateVO) throws Exception;


    List<PmProject> getByid(Long id);
}
