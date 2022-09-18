package top.tangyh.lamp.learnpm.wechatcontroller;

import cn.hutool.crypto.SecureUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.lamp.com.meituan.sqt.client.SqtService;
import top.tangyh.lamp.com.meituan.sqt.request.staff.StaffBatchAddReq;
import top.tangyh.lamp.com.meituan.sqt.request.staff.StaffInfo;
import top.tangyh.lamp.com.meituan.sqt.response.StaffBatchAddResp;
import top.tangyh.lamp.com.meituan.sqt.utils.JsonUtil;
import top.tangyh.lamp.dfhcglock.service.lock.PessimisticLockClientService;
//import top.tangyh.lamp.learnpm.client.DefUserClient;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechatsevice.WechatService;
import top.tangyh.lamp.msg.vo.result.MsgResultVO;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.service.tenant.DefUserService;
import top.tangyh.lamp.system.vo.update.tenant.DefUserPasswordResetVO;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 小程序接口专用
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-15
 */
@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat")
@Api(value = "login", tags = " 微信登录")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class WeChatController {
    private final String REDIS_KEY_EXIST = "存储用户信息失败，请重试！";

    private final WechatService wechatService;
    private final DefUserService userService;

    @Resource(name = "redisTemplate")
    private final RedisTemplate<String, Object> redisTemplate;

    private final PessimisticLockClientService lockClientService;
    private final SqtService sqtService;

    //private final DefUserClient userClient;

    /**
     * 注册
     * @param request
     * @param user
     * @return
     */
    @ApiOperation(value = "注册", notes = "注册")
    @PostMapping(value = "/register")
    @RequestMapping(value = "register", method = RequestMethod.POST, produces = "application/json")
    public R registerLogin(HttpServletRequest request,
                           DefUser user) {
        String phone = user.getMobile();
        //手机号格式校验

        if (StringUtils.isEmpty(phone) && phone.length() != 11) {
            return R.fail("手机号有误");
        }
        DefUser userByMobile = userService.getUserByMobile(phone);
        if (userByMobile == null) {
            return R.fail("手机号已存在");
        }
        //添加美团商企通企业成员
        ArrayList<StaffInfo> staffInfos = new ArrayList<>();
        StaffBatchAddReq req = new StaffBatchAddReq();
        StaffInfo staffInfo = new StaffInfo();
        staffInfo.setPhone(phone);
        staffInfo.setName(user.getUsername());
        if(!(user.getEmail()==null)){
            staffInfo.setEmail(user.getEmail());
        }
        staffInfos.add(staffInfo);
        String s = sqtService.batchAddStaff(req);

        userService.register(user);

        /*String token;
        try {
            //获取token
            //token = weChatService.doLoginInfo(request,phone);
        } catch (Exception ex) {
            log.error(ex.getMessage());
            return R.fail("失败");
        }*/
        return R.success();
    }

    /**
     * 登录
     *
     * @param phone
     * @param password
     * @return
     */

    @ApiOperation(value = "登录", notes = "登录")
    @PostMapping(value = "/login")
    public R login(HttpServletRequest request, String phone, String password) {

        String tokenKey = UUID.randomUUID().toString().replace("-", "");
        //手机号格式校验
        if (StringUtils.isEmpty(phone) && phone.length() != 11) {
            return R.fail("手机号有误");
        }

        //通过手机号获取用户信息
        DefUser user = userService.getUserByMobile(phone);

        if (user == null) {
            return R.fail("您的手机号还未注册，请先注册！");
        }

        //TODO 判断密码（有加密）
        String salt = user.getSalt();
        String psd = SecureUtil.sha256(password + salt);
        log.info("密码校验:" + psd);
        if (!psd.equals(user.getPassword())) {
            return R.fail("密码错误！请重新输入");
        }

        //将用户信息存入到Redis中
        Boolean expire = redisTemplate.hasKey(tokenKey);

        try {
            lockClientService.lock(DSConstant.TOKEN, tokenKey);

            if (expire) {
                return R.fail(REDIS_KEY_EXIST);
            }
            redisTemplate.opsForValue().set(tokenKey, user, 1, TimeUnit.DAYS);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                lockClientService.unLock(DSConstant.TOKEN);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


        /*if (result == null) {
            HashMap<Long, Object> map = new HashMap<>();
            result = map;
            map.put(userId, user);
            //String jsonString = JSONObject.toJSONString(result);
            redisTemplate.opsForValue().set(DSConstant.TOKEN, result);
        } else {
            if (result.get(userId) == null) {
                result.put(userId, user);
                //String jsonString = JSONObject.toJSONString(result);
                redisTemplate.opsForValue().set(DSConstant.TOKEN, result);
            }
        }*/

        //封装返回Map
        HashMap<String, Object> map = new HashMap<>();
        map.put(DSConstant.TOKEN, tokenKey);
        map.put(DSConstant.USER_INFO, user);
        //String result = JSON.toJSONString(map);

        return R.success(map);
    }

    /**
     * 忘记密码
     *
     * @param mobile
     * @param verificationCode
     * @param password
     * @param newPassword
     * @return
     */
    @ApiOperation(value = "忘记密码", notes = "忘记密码")
    @GetMapping("/forget")
    public R shortMessageForgetPassword(String mobile, String verificationCode, String password, String newPassword) {

        DefUser user = userService.getUserByMobile(mobile);
        if (org.springframework.util.StringUtils.isEmpty(user)) {
            return R.fail("手机号码不正确！");
        }

        if (!redisTemplate.hasKey(mobile)) {
            return R.fail("验证码过期，请重新获取验证码。");
        }

        String code = (String) redisTemplate.opsForValue().get(mobile);
        if (!verificationCode.equals(code)) {
            return R.fail("验证码错误");
        }

        if (!password.equals(newPassword)) {
            return R.fail("密码不一致，请重新输入！");
        }

        DefUserPasswordResetVO vo = new DefUserPasswordResetVO();
        vo.setId(user.getId());
        vo.setPassword(password);
        vo.setIsUseSystemPassword(false);
        vo.setConfirmPassword(newPassword);
        Boolean result = userService.resetPassword(vo);
        //wechatService.forgetPassword(mobile, verificationCode, password, newPassword)
        return R.success(result);
    }

    /**
     * 短信验证码
     *
     * @param mobile
     * @return
     */
    @ApiOperation(value = "短信验证码", notes = "短信验证码")
    @GetMapping("/messageAuth")
    public R messageAuth(String mobile) {

        if (StringUtils.isEmpty(mobile) && mobile.length() != 11) {
            return R.fail("手机号有误");
        }

        DefUser user = userService.getUserByMobile(mobile);
        if (user == null) {
            return R.fail("手机号不存在，请重新输入！");
        }

        if (redisTemplate.hasKey(mobile)) {
            return R.fail("验证码发送频繁！默认两分钟可以发一次");
        }

        //随机生成6位数
        Random random = new Random();
        String code = String.valueOf(random.nextInt(999999 - 100000) + 100000 + 1);

        redisTemplate.opsForValue().set(mobile, code, 2, TimeUnit.MINUTES);

        return R.success(code);
    }


    //@ApiOperation(value = "验证Feign", notes = "验证Feign")
    //@GetMapping("/checkFeign")
    //public R<MsgResultVO> getMap(Long id) {
    //    //Long id = 134679874654165454L;
    //    R<MsgResultVO> msgResultVOR = userClient.get(id);
    //    return userClient.get(id);
    //}
}

