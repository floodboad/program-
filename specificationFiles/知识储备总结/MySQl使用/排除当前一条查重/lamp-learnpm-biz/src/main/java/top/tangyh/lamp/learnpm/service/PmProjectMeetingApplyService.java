package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingApply;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingApplyPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingApplyResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingApplySaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingApplyUpdateVO;

import java.util.List;

/**
 * <p>
 * 项目会议申请业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
public interface PmProjectMeetingApplyService extends SuperService<Long, PmProjectMeetingApply, PmProjectMeetingApplySaveVO, PmProjectMeetingApplyUpdateVO, PmProjectMeetingApplyPageQuery, PmProjectMeetingApplyResultVO> {
    public void savePmConferenceExpertServicesPmProjectMeetingApplyIdItem(List<PmConferenceExpertServicesSaveVO> insertList, PmProjectMeetingApply entity);
    public void savePmConferenceApplyFeePmProjectMeetingApplyIdItem(List<PmConferenceApplyFeeSaveVO> insertList, PmProjectMeetingApply entity);

    Integer getByPmProjectMeetingPlanningid(Long id);

    void updateAppliedNum(List<Long> longs);
}
