package top.tangyh.lamp.learnpm.wechatsevice.impl;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.manager.MsAudienceInfoManager;
import top.tangyh.lamp.learnpm.vo.query.MsAudienceInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsAudienceInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsAudienceInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsAudienceInfoUpdateVO;
import top.tangyh.lamp.learnpm.wechatsevice.WechatService;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.manager.tenant.DefUserManager;

import javax.annotation.RegEx;
import java.util.regex.Pattern;

/**
 * <p>
 * 听众信息表业务实现类
 *
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WechatServiceImpl implements WechatService {

    private final MsAudienceInfoManager audienceInfoManager;
    private final DefUserManager userManager;

    /**
     * 登录
     * @param phone
     * @return
     */
    @Override
    public DefUser login(String phone) {

        return userManager.getUserByMobile(phone);
    }

    /**
     * 忘记密码
     *
     * @param phone
     * @param verificationCode
     * @param newPassword
     * @return
     */
    @Override
    public R forgetPassword(String phone, String verificationCode, String password, String newPassword) {
        if (StringUtils.isEmpty(phone) || !this.checkMobile(phone)) {
            return R.fail("手机号码不正确！");
        }
        //if (StringUtils.isEmpty(password) || !this.checkPassword(password)) {
        //    return R.fail("密码格式错误！");
        //}
        if (StringUtils.isEmpty(password)) {
            return R.fail("密码不能为空！");
        }

        if (StringUtils.isEmpty(verificationCode)) {
            return R.fail("请输入验证码！");
        }
        if (!password.equals(newPassword)) {
            return R.fail("密码不一致！");
        }
        DefUser userInfo = userManager.getUserByMobile(phone);
        if (userInfo == null) {
            return R.fail("用户不存在！");
        }

        //TODO  把新的密码存到数据库
        String salt = userInfo.getSalt();
        DefUser defUser = new DefUser();
        BeanUtils.copyProperties(defUser,userInfo);

        if (StrUtil.isEmpty(salt)) {
            salt = RandomUtil.randomString(20);
        }
        String defPassword = SecureUtil.sha256(newPassword + salt);
        defUser.setPassword(defPassword);
        userManager.updateById(defUser);

        return R.success(defUser);
    }

    public boolean checkMobile(String content) {
        if (content == null) {
            return false;
        }
        String regex = "^1[3|4|5|6|7|8|9][0-9]{9}$";
        return Pattern.matches(regex, content);
    }

    //密码强度正则，最少6位
    public boolean checkPassword(String content){
        if(content==null) {
            return false;
        }
        //String regex= "^.*(?=.{6,})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$"; 包括至少1个大写字母，1个小写字母，1个数字，1个特殊字符
        String regex= "^[0-9A-Za-z]{6,12}$";
        return Pattern.matches(regex, content);
    }
}
