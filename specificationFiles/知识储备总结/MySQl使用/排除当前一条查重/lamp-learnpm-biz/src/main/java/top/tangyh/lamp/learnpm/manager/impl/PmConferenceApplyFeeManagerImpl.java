package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.PmConferenceApplyFeeMapper;
import top.tangyh.lamp.learnpm.entity.PmConferenceApplyFee;
import top.tangyh.lamp.learnpm.manager.PmConferenceApplyFeeManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 会议申请费用表Manager
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class PmConferenceApplyFeeManagerImpl extends SuperManagerImpl<PmConferenceApplyFeeMapper, PmConferenceApplyFee> implements PmConferenceApplyFeeManager {

}
