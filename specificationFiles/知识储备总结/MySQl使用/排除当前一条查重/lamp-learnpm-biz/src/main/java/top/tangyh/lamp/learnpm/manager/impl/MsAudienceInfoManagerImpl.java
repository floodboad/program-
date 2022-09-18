package top.tangyh.lamp.learnpm.manager.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import top.tangyh.basic.base.manager.impl.SuperManagerImpl;
import top.tangyh.lamp.learnpm.mapper.MsAudienceInfoMapper;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.manager.MsAudienceInfoManager;
import lombok.extern.slf4j.Slf4j;
/**
 * <p>
 * 听众信息表Manager
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class MsAudienceInfoManagerImpl extends SuperManagerImpl<MsAudienceInfoMapper, MsAudienceInfo> implements MsAudienceInfoManager {

    private final MsAudienceInfoMapper audienceInfoMapper;

    /**
     * 数据库校验手机号
     * @param phone
     * @return
     */
    @Override
    public MsAudienceInfo selectPhone(String phone) {
        return audienceInfoMapper.selectPhone(phone);
    }
}
