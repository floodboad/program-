package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.vo.query.PmProcessPhaseInstancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseInstanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseInstanceUpdateVO;
/**
 * <p>
 * 流程环节实例业务接口
 * 
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
public interface PmProcessPhaseInstanceService extends SuperService<Long, PmProcessPhaseInstance, PmProcessPhaseInstanceSaveVO, PmProcessPhaseInstanceUpdateVO, PmProcessPhaseInstancePageQuery, PmProcessPhaseInstanceResultVO> {
    /**
     * 获取下一个节点页面视图
     * @param pmApprovalProcessInstanceId
     * @return
     */
    String getNextNodePage(long pmApprovalProcessInstanceId) throws Exception;
}
