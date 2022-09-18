package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.R;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingPlanAllocation;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanAllocationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanAllocationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanAllocationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanAllocationUpdateVO;
import top.tangyh.lamp.learnpm.wechat.Allocation;

/**
 * <p>
 * 会议规划分配业务接口
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
public interface PmMeetingPlanAllocationService extends SuperService<Long, PmMeetingPlanAllocation, PmMeetingPlanAllocationSaveVO, PmMeetingPlanAllocationUpdateVO, PmMeetingPlanAllocationPageQuery, PmMeetingPlanAllocationResultVO> {
    /**
     * 会议分配增。
     */
    void insert(PmMeetingPlanAllocationSaveVO saveVO) throws Exception;
    /**
     * 会议分配修改。
     */
    void update(PmMeetingPlanAllocationUpdateVO updateVO) throws Exception;

    /**
     * meetingApply
     * @param id
     * @return
     */
    R meetingApply(Long id);

 



    Object savemeeting(Allocation allocation);
}
