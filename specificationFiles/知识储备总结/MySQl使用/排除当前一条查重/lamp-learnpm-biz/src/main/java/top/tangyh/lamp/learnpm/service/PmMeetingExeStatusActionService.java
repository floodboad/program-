package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExeStatusAction;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingExeStatusAction;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingExeStatusActionPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingExeStatusActionResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingExeStatusActionSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExeStatusActionUpdateVO;
/**
 * <p>
 * 会议执行状态操作表业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmMeetingExeStatusActionService extends SuperService<Long, PmMeetingExeStatusAction, PmMeetingExeStatusActionSaveVO, PmMeetingExeStatusActionUpdateVO, PmMeetingExeStatusActionPageQuery, PmMeetingExeStatusActionResultVO> {

}
