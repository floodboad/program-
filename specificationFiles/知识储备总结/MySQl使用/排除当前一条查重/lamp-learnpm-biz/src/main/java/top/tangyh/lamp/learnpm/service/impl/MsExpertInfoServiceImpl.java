package top.tangyh.lamp.learnpm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;

import java.util.*;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.manager.*;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.query.MsExpertInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpertInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.*;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wechat.WO;

import javax.annotation.Resource;

/**
 * <p>
 * 专家信息业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsExpertInfoServiceImpl extends SuperServiceImpl<MsExpertInfoManager, Long, MsExpertInfo, MsExpertInfoSaveVO, MsExpertInfoUpdateVO, MsExpertInfoPageQuery, MsExpertInfoResultVO>
        implements MsExpertInfoService {

    private final MsExpertInfoManager msExpertInfoManager;
    private final MsExpertBankCardInfoManager expertBankCardInfoManager;
    private final MsQualificationManager qualificationManager;
    private final MsWorkExperienceManager workExperienceManager;

    @Autowired
    private MsHospitalDepartmentManager msHospitalDepartmentManager;

    @Autowired
    private MsUpdateOperationRecordService msUpdateOperationRecordService;
    @Resource
    private PmConferenceExpertServicesService pmConferenceExpertServicesService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除专家银行卡信息
        expertBankCardInfoManager.remove(Wraps.<MsExpertBankCardInfo>lbQ().in(MsExpertBankCardInfo::getMsExpertInfoId, ids));
        //删除资格证书
        qualificationManager.remove(Wraps.<MsQualification>lbQ().in(MsQualification::getMsExpertInfoId, ids));
        //删除工作经历
        workExperienceManager.remove(Wraps.<MsWorkExperience>lbQ().in(MsWorkExperience::getMsExpertInfoId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsExpertInfo save(MsExpertInfoSaveVO saveVO) {
        MsExpertInfo entity = BeanPlusUtil.toBean(saveVO, MsExpertInfo.class);
        superManager.save(entity);
        //添加记录
        msUpdateOperationRecordService.saveRecord(saveVO);
        //循环保存子表
        //保存专家银行卡信息
        saveMsExpertBankCardInfoMsExpertInfoIdItem(saveVO.getMsExpertBankCardInfoMsExpertInfoIdInsertList(), entity);
        //保存资格证书
        saveMsQualificationMsExpertInfoIdItem(saveVO.getMsQualificationMsExpertInfoIdInsertList(), entity);
        //保存工作经历
        saveMsWorkExperienceMsExpertInfoIdItem(saveVO.getMsWorkExperienceMsExpertInfoIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsExpertInfo updateById(MsExpertInfoUpdateVO updateVO) {
        MsExpertInfo old = getById(updateVO.getId());

        MsExpertInfo entity = BeanPlusUtil.toBean(updateVO, MsExpertInfo.class);
        superManager.updateById(entity);
        //添加记录
        msUpdateOperationRecordService.saveRecord(updateVO);
        //循环保存和更新子表
        //保存专家银行卡信息
        saveMsExpertBankCardInfoMsExpertInfoIdItem(updateVO.getMsExpertBankCardInfoMsExpertInfoIdInsertList(), entity);
        //更新专家银行卡信息
        updateMsExpertBankCardInfoMsExpertInfoIdItem(updateVO.getMsExpertBankCardInfoMsExpertInfoIdUpdateList(), entity, old);
        //删除专家银行卡信息
        removeMsExpertBankCardInfoMsExpertInfoIdSubByIds(updateVO.getMsExpertBankCardInfoMsExpertInfoIdDeleteList());
        //保存资格证书
        saveMsQualificationMsExpertInfoIdItem(updateVO.getMsQualificationMsExpertInfoIdInsertList(), entity);
        //更新资格证书
        updateMsQualificationMsExpertInfoIdItem(updateVO.getMsQualificationMsExpertInfoIdUpdateList(), entity, old);
        //删除资格证书
        removeMsQualificationMsExpertInfoIdSubByIds(updateVO.getMsQualificationMsExpertInfoIdDeleteList());
        //保存工作经历
        saveMsWorkExperienceMsExpertInfoIdItem(updateVO.getMsWorkExperienceMsExpertInfoIdInsertList(), entity);
        //更新工作经历
        updateMsWorkExperienceMsExpertInfoIdItem(updateVO.getMsWorkExperienceMsExpertInfoIdUpdateList(), entity, old);
        //删除工作经历
        removeMsWorkExperienceMsExpertInfoIdSubByIds(updateVO.getMsWorkExperienceMsExpertInfoIdDeleteList());


        return entity;
    }

    //保存专家银行卡信息
    private void saveMsExpertBankCardInfoMsExpertInfoIdItem(List<MsExpertBankCardInfoSaveVO> insertList, MsExpertInfo entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<MsExpertBankCardInfo> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            MsExpertBankCardInfo item = new MsExpertBankCardInfo();
            BeanPlusUtil.copyProperties(insert, item);
            msUpdateOperationRecordService.saveRecord(insert);
            item.setMsExpertInfoId(entity.getId());
            itemList.add(item);
        });
        expertBankCardInfoManager.saveBatch(itemList);
    }

    //更新专家银行卡信息
    private void updateMsExpertBankCardInfoMsExpertInfoIdItem(List<MsExpertBankCardInfoUpdateVO> updateInsert, MsExpertInfo entity, MsExpertInfo old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<MsExpertBankCardInfo> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            MsExpertBankCardInfo item = new MsExpertBankCardInfo();
            BeanPlusUtil.copyProperties(insert, item);
            msUpdateOperationRecordService.saveRecord(insert);
            item.setMsExpertInfoId(entity.getId());
            itemList.add(item);
        });
        expertBankCardInfoManager.updateBatchById(itemList);
    }

    //删除专家银行卡信息
    private boolean removeMsExpertBankCardInfoMsExpertInfoIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return expertBankCardInfoManager.removeByIds(idList);
    }

    //保存资格证书
    private void saveMsQualificationMsExpertInfoIdItem(List<MsQualificationSaveVO> insertList, MsExpertInfo entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<MsQualification> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            MsQualification item = new MsQualification();
            BeanPlusUtil.copyProperties(insert, item);
            msUpdateOperationRecordService.saveRecord(insert);
            item.setMsExpertInfoId(entity.getId());
            itemList.add(item);
        });
        qualificationManager.saveBatch(itemList);
    }

    //更新资格证书
    private void updateMsQualificationMsExpertInfoIdItem(List<MsQualificationUpdateVO> updateInsert, MsExpertInfo entity, MsExpertInfo old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<MsQualification> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            MsQualification item = new MsQualification();
            BeanPlusUtil.copyProperties(insert, item);
            msUpdateOperationRecordService.saveRecord(insert);
            item.setMsExpertInfoId(entity.getId());
            itemList.add(item);
        });
        qualificationManager.updateBatchById(itemList);
    }

    //删除资格证书
    private boolean removeMsQualificationMsExpertInfoIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return qualificationManager.removeByIds(idList);
    }

    //保存工作经历
    private void saveMsWorkExperienceMsExpertInfoIdItem(List<MsWorkExperienceSaveVO> insertList, MsExpertInfo entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<MsWorkExperience> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            MsWorkExperience item = new MsWorkExperience();
            BeanPlusUtil.copyProperties(insert, item);
            msUpdateOperationRecordService.saveRecord(insert);
            item.setMsExpertInfoId(entity.getId());
            itemList.add(item);
        });
        workExperienceManager.saveBatch(itemList);
    }

    //更新工作经历
    private void updateMsWorkExperienceMsExpertInfoIdItem(List<MsWorkExperienceUpdateVO> updateInsert, MsExpertInfo entity, MsExpertInfo old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<MsWorkExperience> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            MsWorkExperience item = new MsWorkExperience();
            BeanPlusUtil.copyProperties(insert, item);
            msUpdateOperationRecordService.saveRecord(insert);
            item.setMsExpertInfoId(entity.getId());
            itemList.add(item);
        });
        workExperienceManager.updateBatchById(itemList);
    }

    //删除工作经历
    private boolean removeMsWorkExperienceMsExpertInfoIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return workExperienceManager.removeByIds(idList);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsExpertInfo copy(Long id) {
        MsExpertInfo old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        MsExpertInfo entity = BeanPlusUtil.toBean(old, MsExpertInfo.class);
        entity.setId(null);
        superManager.save(entity);
        //循环复制子表
        LbQueryWrap<MsExpertBankCardInfo> msExpertBankCardInfoMsExpertInfoIdwrap = Wraps.<MsExpertBankCardInfo>lbQ().eq(MsExpertBankCardInfo::getMsExpertInfoId, old.getId());
        List<MsExpertBankCardInfo> itemList0 = expertBankCardInfoManager.list(msExpertBankCardInfoMsExpertInfoIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setMsExpertInfoId(entity.getId());
        });
        expertBankCardInfoManager.saveBatch(itemList0);
        LbQueryWrap<MsQualification> msQualificationMsExpertInfoIdwrap = Wraps.<MsQualification>lbQ().eq(MsQualification::getMsExpertInfoId, old.getId());
        List<MsQualification> itemList1 = qualificationManager.list(msQualificationMsExpertInfoIdwrap);
        itemList1.forEach(item -> {
            item.setId(null);
            item.setMsExpertInfoId(entity.getId());
        });
        qualificationManager.saveBatch(itemList1);
        LbQueryWrap<MsWorkExperience> msWorkExperienceMsExpertInfoIdwrap = Wraps.<MsWorkExperience>lbQ().eq(MsWorkExperience::getMsExpertInfoId, old.getId());
        List<MsWorkExperience> itemList2 = workExperienceManager.list(msWorkExperienceMsExpertInfoIdwrap);
        itemList2.forEach(item -> {
            item.setId(null);
            item.setMsExpertInfoId(entity.getId());
        });
        workExperienceManager.saveBatch(itemList2);


        return entity;
    }

    @Override
    public Map<String, ArrayList<String>> queryHospitalDeptInfo() {

        // 所要获取的数据是 "一个key：医院名称"-->对应--->"多个value值：科室信息"放入map.
        Map<String, ArrayList<String>> destMap = new HashMap<>();

        // 第一步拿出所有的key -- > list集合,去重查询放到list集合中
        ArrayList<String> keys = msHospitalDepartmentManager.selectDistinctHospitalName();
        for (String item : keys) {
            destMap.put(item, new ArrayList<String>());
        }
        ArrayList<String> deptNameList = new ArrayList<>();
        // 第二步通过查重的字段筛选集合加入map
        for (int i = 0; i < keys.size() - 1; ++i) {
            deptNameList = msHospitalDepartmentManager.selectHospitalDeptName(keys.get(i));
            destMap.put(keys.get(i), deptNameList);
            deptNameList.clear();
        }
        return destMap;
    }

    @Override
    public boolean judgeExpertExit(String name, String tel) {
        QueryWrap<MsExpertInfo> queryWrap = new QueryWrap<>();
        queryWrap.eq("NAME",name)
                .eq("TEL",tel);
        List<MsExpertInfo> list = msExpertInfoManager.list(queryWrap);
        if (CollectionUtils.isEmpty(list)){
            return true;
        }
        return false;
    }

    //@Override
    //public void insertExpertRelationInfo(MsExpertInfo expertInfo, long expertServicesId) {
    //   // 更新一条专家劳务记录将专家信息、会议信息录入
    //    PmConferenceExpertServicesUpdateVO servicesUpdateVO = PmConferenceExpertServicesUpdateVO.builder()
    //            .msExpertInfoId(expertInfo.getId())
    //            .expertInfoName(expertInfo.getName())
    //            .hospitalName(expertInfo.getWorkingHospital())
    //            .departmentInfoName(expertInfo.getDepartment())
    //            .build();
    //    pmConferenceExpertServicesService.updateById(servicesUpdateVO);
    //
    //}

}
