package top.tangyh.lamp.learnpm.wechatsevice;

import top.tangyh.basic.base.R;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.vo.query.MsAudienceInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsAudienceInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsAudienceInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsAudienceInfoUpdateVO;
import top.tangyh.lamp.system.entity.tenant.DefUser;

/**
 * <p>
 * 听众信息表业务接口
 *
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
public interface WechatService {

    //登录接口
    DefUser login(String phone);

    //忘记密码
    R forgetPassword(String phone, String verificationCode, String password, String newPassword);
}
