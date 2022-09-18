package top.tangyh.lamp.learnpm.wechatsevice.impl;/**
 * @author xuchunlong
 * @create 2022-06-30-12:48
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.common.utils.StringUtils;
import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.manager.MsAudienceInfoManager;
import top.tangyh.lamp.learnpm.wechatsevice.AudienceService;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.manager.tenant.DefUserManager;


/**
 * @author: xucl
 * @create: 2022/6/30
 * @Description:
 * @FileName: AudienceServiceImpl
 * @History:
 * @自定义内容：
 */

@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AudienceServiceImpl implements AudienceService {
    @Autowired
    private MsAudienceInfoManager msAudienceInfoManager;

    @Autowired
    private DefUserManager defUserManager;

    @Override
    public Boolean AudienceInformationEntry(String json) {
        // 由json字符串得到java对象进行赋值
        MsAudienceInfo msAudienceInfo = JSON.parseObject(json , MsAudienceInfo.class);
        // 将MsAudienceInfo实体类对象转化为def_user
        DefUser defUser = new DefUser();
        defUser.setUsername(msAudienceInfo.getName());
        defUser.setMobile(msAudienceInfo.getPhone());
        // def_user 与 MsAudienceInfo校验数据库是否存在
        MsAudienceInfo returnValue1 = msAudienceInfoManager.selectPhone(msAudienceInfo.getPhone());
        DefUser returnValue2 = defUserManager.getUserByMobile(msAudienceInfo.getPhone());
        boolean flag1 = returnValue1 == null? true:false;
        boolean flag2 = returnValue2 == null? true:false;
        if (flag1 || flag2){
            if (flag1){
                msAudienceInfoManager.save(msAudienceInfo);
            }else if (flag2){
                defUserManager.save(defUser);
            }
            return true;
        }
        return false;
    }
}