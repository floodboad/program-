package top.tangyh.lamp.learnpm.manager;

import top.tangyh.basic.base.manager.SuperManager;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;

/**
 * <p>
 * 听众信息表业务层
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
public interface MsAudienceInfoManager extends SuperManager<MsAudienceInfo> {

    //根据手机号获取用户信息
    MsAudienceInfo selectPhone(String phone);
}
