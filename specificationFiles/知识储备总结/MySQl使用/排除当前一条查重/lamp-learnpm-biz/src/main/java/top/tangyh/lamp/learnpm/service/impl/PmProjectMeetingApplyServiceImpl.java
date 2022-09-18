package top.tangyh.lamp.learnpm.service.impl;

import cn.hutool.core.net.Ipv4Util;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;

import java.math.BigDecimal;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sun.net.util.IPAddressUtil;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.manager.*;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingApplyMapper;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingApplyPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingApplyResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.*;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.workflowservice.WorkFlowService;
import top.tangyh.lamp.workflow.vo.SearchToDoVO;
import top.tangyh.lamp.workflow.vo.StartVO;

import javax.annotation.Resource;

/**
 * <p>
 * 项目会议申请业务实现类
 *
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmProjectMeetingApplyServiceImpl extends SuperServiceImpl<PmProjectMeetingApplyManager, Long, PmProjectMeetingApply, PmProjectMeetingApplySaveVO, PmProjectMeetingApplyUpdateVO, PmProjectMeetingApplyPageQuery, PmProjectMeetingApplyResultVO>
        implements PmProjectMeetingApplyService {
    private final PmConferenceApplyFeeManager conferenceApplyFeeManager;
    private final PmConferenceExpertServicesManager conferenceExpertServicesManager;
    private final PmMeetingMaterialsRegManager meetingMaterialsRegManager;
    private final PmOnlineMeetingPublishManager onlineMeetingPublishManager;
    private final PmOtherExpensesRegManager otherExpensesRegManager;
    private final PmProjectMeetingApplyMapper pmProjectMeetingApplyMapper;
    @Resource
    private PmConferenceExpertServicesService pmConferenceExpertServicesService;
    private final PmExpertReplaceRecordService pmExpertReplaceRecordService;
    private final PmExpertReplaceRecordManager pmExpertReplaceRecordManager;
    private final PmProjectService pmProjectService;
    private final PmProjectMeetingPlanningService pmProjectMeetingPlanningService;
    private final WorkFlowService workFlowService;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除会议申请费用表
        conferenceApplyFeeManager.remove(Wraps.<PmConferenceApplyFee>lbQ().in(PmConferenceApplyFee::getPmProjectMeetingApplyId, ids));
        //删除会议专家劳务
        conferenceExpertServicesManager.remove(Wraps.<PmConferenceExpertServices>lbQ().in(PmConferenceExpertServices::getPmProjectMeetingApplyId, ids));
        //删除会议合规材料登记
        meetingMaterialsRegManager.remove(Wraps.<PmMeetingMaterialsReg>lbQ().in(PmMeetingMaterialsReg::getPmProjectMeetingApplyId, ids));
        //删除线上会议发布
        onlineMeetingPublishManager.remove(Wraps.<PmOnlineMeetingPublish>lbQ().in(PmOnlineMeetingPublish::getPmProjectMeetingApplyId, ids));
        //删除会议执行费用支付录入
        otherExpensesRegManager.remove(Wraps.<PmOtherExpensesReg>lbQ().in(PmOtherExpensesReg::getPmProjectMeetingApplyId,ids));
        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProjectMeetingApply save(PmProjectMeetingApplySaveVO saveVO) {
        PmProjectMeetingApply entity = BeanPlusUtil.toBean(saveVO, PmProjectMeetingApply.class);
        superManager.save(entity);
        //循环保存子表
        //保存会议申请费用表
        savePmConferenceApplyFeePmProjectMeetingApplyIdItem(saveVO.getPmConferenceApplyFeePmProjectMeetingApplyIdInsertList(), entity);
        //保存会议专家劳务
        savePmConferenceExpertServicesPmProjectMeetingApplyIdItem(saveVO.getPmConferenceExpertServicesPmProjectMeetingApplyIdInsertList(), entity);
        //保存会议合规材料登记
        savePmMeetingMaterialsRegPmProjectMeetingApplyIdItem(saveVO.getPmMeetingMaterialsRegPmProjectMeetingApplyIdInsertList(), entity);
        //保存线上会议发布
        savePmOnlineMeetingPublishPmProjectMeetingApplyIdItem(saveVO.getPmOnlineMeetingPublishPmProjectMeetingApplyIdInsertList(), entity);
        //保存会议执行费用支付录入
        savePmOtherExpensesRegPmProjectMeetingApplyIdItem(saveVO.getPmOtherExpensesRegPmProjectMeetingApplyIdInsertList(),entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProjectMeetingApply updateById(PmProjectMeetingApplyUpdateVO updateVO) {
        PmProjectMeetingApply old = getById(updateVO.getId());

        PmProjectMeetingApply entity = BeanPlusUtil.toBean(updateVO, PmProjectMeetingApply.class);
        //每次修改内容都需要提交审核，并且把会议置于不可用状态（未审核）
        entity.setMeetingStatus(DSConstant.DICTIONARY_MEETING_STATUS_02);
        superManager.updateById(entity);
        //开启工作流
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            SearchToDoVO searchToDoVO = new SearchToDoVO();
            searchToDoVO.setBusinessId(entity.getPmProjectId());
            searchToDoVO.setBusinessType(DSConstant.DICTIONARY_BUSINESS_TYPE_02);
            searchToDoVO.setProcessName(DSConstant.DICTIONARY_PROCESS_NAME_MEETING_APPLY);
            searchToDoVO.setProcessInstanceId(0);

            StartVO startVO = StartVO.builder().businessType(DSConstant.DICTIONARY_BUSINESS_TYPE_02)
                    .businessId(entity.getId())
                    .toDoId(workFlowService.getToDoList(searchToDoVO))
                    .processName(DSConstant.DICTIONARY_PROCESS_NAME_MEETING_APPLY)
                    .businessInfo(objectMapper.writeValueAsString(entity))
                    .applicantId(ContextUtil.getApplicationId())
                    .applicantName(ContextUtil.getUserName())
                    .build();
            workFlowService.startFlow(startVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //循环保存和更新子表
        //保存会议申请费用表
        savePmConferenceApplyFeePmProjectMeetingApplyIdItem(updateVO.getPmConferenceApplyFeePmProjectMeetingApplyIdInsertList(), entity);
        //更新会议申请费用表
        updatePmConferenceApplyFeePmProjectMeetingApplyIdItem(updateVO.getPmConferenceApplyFeePmProjectMeetingApplyIdUpdateList(), entity, old);
        //删除会议申请费用表
        removePmConferenceApplyFeePmProjectMeetingApplyIdSubByIds(updateVO.getPmConferenceApplyFeePmProjectMeetingApplyIdDeleteList());
        //保存会议专家劳务
        savePmConferenceExpertServicesPmProjectMeetingApplyIdItem(updateVO.getPmConferenceExpertServicesPmProjectMeetingApplyIdInsertList(), entity);
        //*****更新专家调整记录表*************
        recordExpertChanges(updateVO.getPmConferenceExpertServicesPmProjectMeetingApplyIdUpdateList(), updateVO);
        //更新会议专家劳务
        updatePmConferenceExpertServicesPmProjectMeetingApplyIdItem(updateVO.getPmConferenceExpertServicesPmProjectMeetingApplyIdUpdateList(), entity, old);
        //删除会议专家劳务
        removePmConferenceExpertServicesPmProjectMeetingApplyIdSubByIds(updateVO.getPmConferenceExpertServicesPmProjectMeetingApplyIdDeleteList());
        //保存会议合规材料登记
        savePmMeetingMaterialsRegPmProjectMeetingApplyIdItem(updateVO.getPmMeetingMaterialsRegPmProjectMeetingApplyIdInsertList(), entity);
        //更新会议合规材料登记
        updatePmMeetingMaterialsRegPmProjectMeetingApplyIdItem(updateVO.getPmMeetingMaterialsRegPmProjectMeetingApplyIdUpdateList(), entity, old);
        //删除会议合规材料登记
        removePmMeetingMaterialsRegPmProjectMeetingApplyIdSubByIds(updateVO.getPmMeetingMaterialsRegPmProjectMeetingApplyIdDeleteList());
        //保存线上会议发布
        savePmOnlineMeetingPublishPmProjectMeetingApplyIdItem(updateVO.getPmOnlineMeetingPublishPmProjectMeetingApplyIdInsertList(), entity);
        //更新线上会议发布
        updatePmOnlineMeetingPublishPmProjectMeetingApplyIdItem(updateVO.getPmOnlineMeetingPublishPmProjectMeetingApplyIdUpdateList(), entity, old);
        //删除线上会议发布
        removePmOnlineMeetingPublishPmProjectMeetingApplyIdSubByIds(updateVO.getPmOnlineMeetingPublishPmProjectMeetingApplyIdDeleteList());
        //保存会议执行费用支付录入
        savePmOtherExpensesRegPmProjectMeetingApplyIdItem(updateVO.getPmOtherExpensesRegPmProjectMeetingApplyIdInsertList(),entity);
        //更新会议执行费用支付录入
        updatePmOtherExpensesRegPmProjectMeetingApplyIdItem(updateVO.getPmOtherExpensesRegPmProjectMeetingApplyIdUpdateList(),entity,old);
        //删除会议执行费用支付录入
        removePmOtherExpensesRegPmProjectMeetingApplyIdSubByIds(updateVO.getPmMeetingMaterialsRegPmProjectMeetingApplyIdDeleteList());
        return entity;
    }

    //保存会议申请费用表
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePmConferenceApplyFeePmProjectMeetingApplyIdItem(List<PmConferenceApplyFeeSaveVO> insertList, PmProjectMeetingApply entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }
        List<PmConferenceApplyFee> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            Long ApplyId = entity.getId();
            PmConferenceApplyFee item = new PmConferenceApplyFee();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(ApplyId);
            itemList.add(item);
        });
        conferenceApplyFeeManager.saveBatch(itemList);
    }

    @Override
    public Integer getByPmProjectMeetingPlanningid(Long id) {

        return pmProjectMeetingApplyMapper.getByPmProjectMeetingPlanningid(id);
    }

    //更新会议申请费用表
    private void updatePmConferenceApplyFeePmProjectMeetingApplyIdItem(List<PmConferenceApplyFeeUpdateVO> updateInsert, PmProjectMeetingApply entity, PmProjectMeetingApply old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmConferenceApplyFee> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmConferenceApplyFee item = new PmConferenceApplyFee();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        conferenceApplyFeeManager.updateBatchById(itemList);
    }

    //删除会议申请费用表
    private boolean removePmConferenceApplyFeePmProjectMeetingApplyIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return conferenceApplyFeeManager.removeByIds(idList);
    }

    //保存会议专家劳务
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void savePmConferenceExpertServicesPmProjectMeetingApplyIdItem(List<PmConferenceExpertServicesSaveVO> insertList, PmProjectMeetingApply entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmConferenceExpertServices> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmConferenceExpertServices item = new PmConferenceExpertServices();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        conferenceExpertServicesManager.saveBatch(itemList);
    }

    //更新会议专家劳务
    private void updatePmConferenceExpertServicesPmProjectMeetingApplyIdItem(List<PmConferenceExpertServicesUpdateVO> updateInsert, PmProjectMeetingApply entity, PmProjectMeetingApply old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmConferenceExpertServices> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmConferenceExpertServices item = new PmConferenceExpertServices();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        conferenceExpertServicesManager.updateBatchById(itemList);
    }

    //删除会议专家劳务
    private boolean removePmConferenceExpertServicesPmProjectMeetingApplyIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return conferenceExpertServicesManager.removeByIds(idList);
    }

    //保存会议合规材料登记
    private void savePmMeetingMaterialsRegPmProjectMeetingApplyIdItem(List<PmMeetingMaterialsRegSaveVO> insertList, PmProjectMeetingApply entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmMeetingMaterialsReg> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmMeetingMaterialsReg item = new PmMeetingMaterialsReg();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        meetingMaterialsRegManager.saveBatch(itemList);
    }

    //更新会议合规材料登记
    private void updatePmMeetingMaterialsRegPmProjectMeetingApplyIdItem(List<PmMeetingMaterialsRegUpdateVO> updateInsert, PmProjectMeetingApply entity, PmProjectMeetingApply old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmMeetingMaterialsReg> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmMeetingMaterialsReg item = new PmMeetingMaterialsReg();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        meetingMaterialsRegManager.updateBatchById(itemList);
    }

    //删除会议合规材料登记
    private boolean removePmMeetingMaterialsRegPmProjectMeetingApplyIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return meetingMaterialsRegManager.removeByIds(idList);
    }

    //保存线上会议发布
    private void savePmOnlineMeetingPublishPmProjectMeetingApplyIdItem(List<PmOnlineMeetingPublishSaveVO> insertList, PmProjectMeetingApply entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmOnlineMeetingPublish> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmOnlineMeetingPublish item = new PmOnlineMeetingPublish();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        onlineMeetingPublishManager.saveBatch(itemList);
    }

    //更新线上会议发布
    private void updatePmOnlineMeetingPublishPmProjectMeetingApplyIdItem(List<PmOnlineMeetingPublishUpdateVO> updateInsert, PmProjectMeetingApply entity, PmProjectMeetingApply old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmOnlineMeetingPublish> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmOnlineMeetingPublish item = new PmOnlineMeetingPublish();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        onlineMeetingPublishManager.updateBatchById(itemList);
    }

    //删除线上会议发布
    private boolean removePmOnlineMeetingPublishPmProjectMeetingApplyIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return onlineMeetingPublishManager.removeByIds(idList);
    }

    //保存会议执行费用支付录入
    private void savePmOtherExpensesRegPmProjectMeetingApplyIdItem(List<PmOtherExpensesRegSaveVO> insertList, PmProjectMeetingApply entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmOtherExpensesReg> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmOtherExpensesReg item = new PmOtherExpensesReg();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        otherExpensesRegManager.saveBatch(itemList);
    }
    //更新会议执行费用支付录入
    private void updatePmOtherExpensesRegPmProjectMeetingApplyIdItem(List<PmOtherExpensesRegUpdateVO> updateInsert, PmProjectMeetingApply entity, PmProjectMeetingApply old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmOtherExpensesReg> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmOtherExpensesReg item = new PmOtherExpensesReg();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingApplyId(entity.getId());
            itemList.add(item);
        });
        otherExpensesRegManager.updateBatchById(itemList);
    }
    //删除会议执行费用支付录入
    private boolean removePmOtherExpensesRegPmProjectMeetingApplyIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return otherExpensesRegManager.removeByIds(idList);
    }



    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProjectMeetingApply copy(Long id) {
        PmProjectMeetingApply old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        PmProjectMeetingApply entity = BeanPlusUtil.toBean(old, PmProjectMeetingApply.class);
        entity.setId(null);
        superManager.save(entity);
        //循环复制子��
        LbQueryWrap<PmConferenceApplyFee> pmConferenceApplyFeePmProjectMeetingApplyIdwrap = Wraps.<PmConferenceApplyFee>lbQ().eq(PmConferenceApplyFee::getPmProjectMeetingApplyId, old.getId());
        List<PmConferenceApplyFee> itemList0 = conferenceApplyFeeManager.list(pmConferenceApplyFeePmProjectMeetingApplyIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingApplyId(entity.getId());
        });
        conferenceApplyFeeManager.saveBatch(itemList0);
        LbQueryWrap<PmConferenceExpertServices> pmConferenceExpertServicesPmProjectMeetingApplyIdwrap = Wraps.<PmConferenceExpertServices>lbQ().eq(PmConferenceExpertServices::getPmProjectMeetingApplyId, old.getId());
        List<PmConferenceExpertServices> itemList1 = conferenceExpertServicesManager.list(pmConferenceExpertServicesPmProjectMeetingApplyIdwrap);
        itemList1.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingApplyId(entity.getId());
        });
        conferenceExpertServicesManager.saveBatch(itemList1);
        LbQueryWrap<PmMeetingMaterialsReg> pmMeetingMaterialsRegPmProjectMeetingApplyIdwrap = Wraps.<PmMeetingMaterialsReg>lbQ().eq(PmMeetingMaterialsReg::getPmProjectMeetingApplyId, old.getId());
        List<PmMeetingMaterialsReg> itemList2 = meetingMaterialsRegManager.list(pmMeetingMaterialsRegPmProjectMeetingApplyIdwrap);
        itemList2.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingApplyId(entity.getId());
        });
        meetingMaterialsRegManager.saveBatch(itemList2);
        LbQueryWrap<PmOnlineMeetingPublish> pmOnlineMeetingPublishPmProjectMeetingApplyIdwrap = Wraps.<PmOnlineMeetingPublish>lbQ().eq(PmOnlineMeetingPublish::getPmProjectMeetingApplyId, old.getId());
        List<PmOnlineMeetingPublish> itemList3 = onlineMeetingPublishManager.list(pmOnlineMeetingPublishPmProjectMeetingApplyIdwrap);
        itemList3.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingApplyId(entity.getId());
        });
        onlineMeetingPublishManager.saveBatch(itemList3);
        LbQueryWrap<PmOtherExpensesReg> pmOtherExpensesRegPmProjectMeetingApplyIdwrap = Wraps.<PmOtherExpensesReg>lbQ().eq(PmOtherExpensesReg::getPmProjectMeetingApplyId,old.getId());
        List<PmOtherExpensesReg> itemList4 = otherExpensesRegManager.list(pmOtherExpensesRegPmProjectMeetingApplyIdwrap);
        itemList4.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingApplyId(entity.getId());
        });
        otherExpensesRegManager.saveBatch(itemList4);


        return entity;
    }

    /**
     * 更新专家调整记录表
     *
     * @param updateVOs 只有更换专家时才会产生记录，新填专家信息时不会进入这里！
     */
    @Transactional(rollbackFor = Exception.class)
    public void recordExpertChanges(List<PmConferenceExpertServicesUpdateVO> updateVOs, PmProjectMeetingApplyUpdateVO updateVO) {
        if (updateVOs.isEmpty()) {
            return;
        }
        updateVOs.forEach(insert -> {
            //根据新增VO在新增前查询出旧数据
            Long id = insert.getId();
            PmConferenceExpertServices oldRecord = pmConferenceExpertServicesService.getOldRecord(id);
            //判断是否更换了专家,更换了则产生记录
            if (oldRecord.getExpertInfoName() != null && !oldRecord.getExpertInfoName().equals(insert.getExpertInfoName())) {
                //创建更新记录表的插入VO（新数据）
                PmExpertReplaceRecord pmExpertReplaceRecord = pmExpertReplaceRecordService.saveRecord(insert);
                //取出旧数据装入记录数据
                pmExpertReplaceRecord.setOldExpertInfoName(oldRecord.getExpertInfoName());
                pmExpertReplaceRecord.setOldMsExpertInfoId(oldRecord.getMsExpertInfoId());
                //设置会议编号
                pmExpertReplaceRecord.setMeetingNoName(updateVO.getMeetingNoName());
                //插入新记录
                pmExpertReplaceRecordManager.save(pmExpertReplaceRecord);
            }
        });
    }

    /**
     * 更新场次信息，回填申请场次
     * @param longs
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void updateAppliedNum(List<Long> longs){
        //取出申请id，获得一条申请来获得他们的规划与项目
        Long applyId = longs.get(0);
        PmProjectMeetingApply apply = getById(applyId);
        //查规划与项目的id
        Long planningId = apply.getPmProjectMeetingPlanningId();
        Long projectId = apply.getPmProjectId();
        //拿到规划和项目的id，组装成updateVO更新场次
        PmProject project = pmProjectService.getById(projectId);
        PmProjectUpdateVO projectUpdateVO = BeanPlusUtil.toBean(project, PmProjectUpdateVO.class);
        project.setAppliedNum(project.getAppliedNum()-longs.size());
        PmProjectMeetingPlanning planning = pmProjectMeetingPlanningService.getById(planningId);
        PmProjectMeetingPlanningUpdateVO planningUpdateVO = BeanPlusUtil.toBean(planning, PmProjectMeetingPlanningUpdateVO.class);
        //更新场次
        try {
            pmProjectMeetingPlanningService.update(planningUpdateVO);
            pmProjectService.update(projectUpdateVO);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
