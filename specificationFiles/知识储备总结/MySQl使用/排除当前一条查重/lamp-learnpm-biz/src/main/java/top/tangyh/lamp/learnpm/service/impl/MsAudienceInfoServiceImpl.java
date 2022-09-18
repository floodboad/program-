package top.tangyh.lamp.learnpm.service.impl;

import com.alibaba.nacos.common.utils.StringUtils;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.manager.MsAudienceInfoManager;
import top.tangyh.lamp.learnpm.service.MsAudienceInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsAudienceInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsAudienceInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsAudienceInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsAudienceInfoUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.sql.Struct;

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
public class MsAudienceInfoServiceImpl extends SuperServiceImpl<MsAudienceInfoManager, Long, MsAudienceInfo, MsAudienceInfoSaveVO, MsAudienceInfoUpdateVO, MsAudienceInfoPageQuery, MsAudienceInfoResultVO>
        implements MsAudienceInfoService {

    @Autowired
    private MsAudienceInfoManager msAudienceInfoManager;

    @Override
    public boolean uniquePhoneNumsSave(String phoneNums) {
        MsAudienceInfo msAudienceInfo = msAudienceInfoManager.selectPhone(phoneNums);
        boolean flag = msAudienceInfo == null?true:false;
        return flag;
    }
}
