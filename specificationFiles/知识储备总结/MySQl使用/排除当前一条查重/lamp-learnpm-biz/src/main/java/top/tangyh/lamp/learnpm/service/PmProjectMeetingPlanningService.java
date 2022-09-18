package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProject;
import top.tangyh.lamp.learnpm.entity.PmProjectAudit;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingPlanningPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingPlanningResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingPlanningSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanningUpdateVO;
import top.tangyh.lamp.learnpm.wechat.WO;

import top.tangyh.lamp.workflow.vo.AuditVO;

import java.util.List;

/**
 * <p>
 * 项目会议规划业务接口
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmProjectMeetingPlanningService extends SuperService<Long, PmProjectMeetingPlanning, PmProjectMeetingPlanningSaveVO, PmProjectMeetingPlanningUpdateVO, PmProjectMeetingPlanningPageQuery, PmProjectMeetingPlanningResultVO> {
    /**
     * 会议规划新增。
     */
    void insert(PmProjectMeetingPlanningSaveVO saveVO) throws Exception;
    /**
     * 会议规划修改。
     */
    void update(PmProjectMeetingPlanningUpdateVO updateVO) throws Exception;
    /**
     * 会议规划提交审核。
     */
    void commitAudit(Long projectId) throws Exception;
    /**
     * 会议调整提交审核。
     */
    void commitPlanAdjustAudit(Long projectId) throws Exception;

    /**
     *审核页面展示数据
     */
    PmProjectAudit auditPage(Long projectId) throws Exception;
    /**
     *审批回调接口（通过不通过专用）
     */
    void audit(AuditVO auditVO) throws Exception;

    /**
     * 规划调整接口
     */
    void adjustPlan(PmProjectMeetingPlanningUpdateVO updateVO) throws Exception;

    List<PmProjectMeetingPlanning> getByPhone(String phone);

}
