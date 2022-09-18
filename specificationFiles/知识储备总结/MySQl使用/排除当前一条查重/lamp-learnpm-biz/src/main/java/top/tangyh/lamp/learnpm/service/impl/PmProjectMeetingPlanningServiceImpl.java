package top.tangyh.lamp.learnpm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.manager.*;
import top.tangyh.lamp.learnpm.mapper.PmProjectPlanAdjustRecordMapper;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingPlanningMapper;
import top.tangyh.lamp.learnpm.service.PmProjectMeetingPlanningService;
import top.tangyh.lamp.learnpm.service.PmProjectService;
import top.tangyh.lamp.learnpm.service.PmProjectStakeholderService;
import top.tangyh.lamp.learnpm.vo.query.PmProjectMeetingPlanningPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectMeetingPlanningResultVO;
import top.tangyh.lamp.learnpm.vo.save.*;
import top.tangyh.lamp.learnpm.vo.update.*;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanExeStandardsSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanExeStandardsUpdateVO;
import top.tangyh.lamp.learnpm.vo.save.PmExpertServiceStandardSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmExpertServiceStandardUpdateVO;
import top.tangyh.lamp.learnpm.workflowservice.WorkFlowService;
import top.tangyh.lamp.workflow.vo.AuditVO;
import top.tangyh.lamp.workflow.vo.SearchToDoVO;
import top.tangyh.lamp.workflow.vo.StartVO;

import javax.annotation.Resource;

import top.tangyh.lamp.learnpm.vo.save.PmMeetingExecutionReqSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingExecutionReqUpdateVO;
import top.tangyh.lamp.learnpm.wechat.WO;

/**
 * <p>
 * 项目会议规划业务实现类
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class PmProjectMeetingPlanningServiceImpl extends SuperServiceImpl<PmProjectMeetingPlanningManager, Long, PmProjectMeetingPlanning, PmProjectMeetingPlanningSaveVO, PmProjectMeetingPlanningUpdateVO, PmProjectMeetingPlanningPageQuery, PmProjectMeetingPlanningResultVO>
        implements PmProjectMeetingPlanningService {
private final PmMeetingPlanExeStandardsManager meetingPlanExeStandardsManager;
private final PmExpertServiceStandardManager expertServiceStandardManager;
private final PmMeetingExecutionReqManager meetingExecutionReqManager;
private final PmProjectMeetingPlanningMapper pmProjectMeetingPlanningMapper;

private final PmProjectService projectService;
private final PmProjectStakeholderService pmProjectStakeholderService;
private final WorkFlowService workFlowService;
private final PmProjectMeetingPlanAdjustService pmProjectMeetingPlanAdjustService;
private final PmProjectPlanAdjustRecordService pmProjectPlanAdjustRecordService;
private final PmExpertServiceStandardAdjService pmExpertServiceStandardAdjService;
private final PmMeetingPlanExeStandardsAdjService pmMeetingPlanExeStandardsAdjService;
private final PmMeetingExecutionReqAdjustService pmMeetingExecutionReqAdjustService;
private final PmComplianceMaterialsManager complianceMaterialsManager;
    private final PmProjectPlanAdjustRecordMapper pmProjectPlanAdjustRecordMapper;
 @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除会议规划执行标准
        meetingPlanExeStandardsManager.remove(Wraps.<PmMeetingPlanExeStandards>lbQ().in(PmMeetingPlanExeStandards::getPmProjectMeetingPlanningId, ids));
        //删除会议规划专家劳务标准
        expertServiceStandardManager.remove(Wraps.<PmExpertServiceStandard>lbQ().in(PmExpertServiceStandard::getPmProjectMeetingPlanningId, ids));
        //删除会议执行要求
        meetingExecutionReqManager.remove(Wraps.<PmMeetingExecutionReq>lbQ().in(PmMeetingExecutionReq::getPmProjectMeetingPlanningId, ids));
    //删除项目合规材料
     complianceMaterialsManager.remove(Wraps.<PmComplianceMaterials>lbQ().in(PmComplianceMaterials::getPmProjectMeetingPlanningId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProjectMeetingPlanning save(PmProjectMeetingPlanningSaveVO saveVO) {
        PmProjectMeetingPlanning entity = BeanPlusUtil.toBean(saveVO,  PmProjectMeetingPlanning.class);
        superManager.save(entity);
		//循环保存子表
        //保存会议规划执行标准
        savePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdItem(saveVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList(), entity);
        //保存会议规划专家劳务标准
        savePmExpertServiceStandardPmProjectMeetingPlanningIdItem(saveVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdInsertList(), entity);
        //保存会议执行要求
        savePmMeetingExecutionReqPmProjectMeetingPlanningIdItem(saveVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList(), entity);
        //保存项目合规材料
        savePmComplianceMaterialsPmProjectMeetingPlanningIdItem(saveVO.getPmComplianceMaterialsPmProjectMeetingPlanningIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProjectMeetingPlanning updateById(PmProjectMeetingPlanningUpdateVO updateVO) {
        PmProjectMeetingPlanning old = getById(updateVO.getId());
        //其中专家劳务费用
        BigDecimal inExpertServiceExpenses = BigDecimal.ZERO;
        //其中会议执行费用
        BigDecimal inMeetingExecutionCost = BigDecimal.ZERO;
        PmProjectMeetingPlanning entity = BeanPlusUtil.toBean(updateVO, PmProjectMeetingPlanning.class);

		//循环保存和更新子表
        //保存会议规划执行标准
        BigDecimal inMeetingExecutionCostInsert = savePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdItem(updateVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList(), entity);
        //更新会议规划执行标准
        BigDecimal inMeetingExecutionCostUpdate = updatePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdItem(updateVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList(), entity, old);
        //删除会议规划执行标准
        BigDecimal inMeetingExecutionCostDelete = removePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdSubByIds(updateVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdDeleteList());
        inMeetingExecutionCost =inMeetingExecutionCost.add(inMeetingExecutionCostInsert).add(inMeetingExecutionCostUpdate).subtract(inMeetingExecutionCostDelete);
        entity.setInMeetingExecutionCost(inMeetingExecutionCost);
        //保存会议规划专家劳务标准
        BigDecimal inExpertServiceExpensesInsert = savePmExpertServiceStandardPmProjectMeetingPlanningIdItem(updateVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdInsertList(), entity);
        //更新会议规划专家劳务标准
        BigDecimal inExpertServiceExpensesUpdate = updatePmExpertServiceStandardPmProjectMeetingPlanningIdItem(updateVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList(), entity, old);
        //删除会议规划专家劳务标准
        BigDecimal inExpertServiceExpensesDelete = removePmExpertServiceStandardPmProjectMeetingPlanningIdSubByIds(updateVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdDeleteList());
        inExpertServiceExpenses = inExpertServiceExpenses.add(inExpertServiceExpensesInsert).add(inExpertServiceExpensesUpdate).subtract(inExpertServiceExpensesDelete);
        entity.setInMeetingExecutionCost(inExpertServiceExpenses);
        superManager.updateById(entity);
        //保存会议执行要求
        savePmMeetingExecutionReqPmProjectMeetingPlanningIdItem(updateVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList(), entity);
		//更新会议执行要求
		updatePmMeetingExecutionReqPmProjectMeetingPlanningIdItem(updateVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList(), entity,old);
		//删除会议执行要求
		removePmMeetingExecutionReqPmProjectMeetingPlanningIdSubByIds(updateVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdDeleteList());
        //保存项目合规材料
        savePmComplianceMaterialsPmProjectMeetingPlanningIdItem(updateVO.getPmComplianceMaterialsPmProjectMeetingPlanningIdInsertList(), entity);
        //更新项目合规材料
        updatePmComplianceMaterialsPmProjectMeetingPlanningIdItem(updateVO.getPmComplianceMaterialsPmProjectMeetingPlanningIdUpdateList(), entity,old);
        //删除项目合规材料
        removePmComplianceMaterialsPmProjectMeetingPlanningIdSubByIds(updateVO.getPmComplianceMaterialsPmProjectMeetingPlanningIdDeleteList());

        return entity;
    }
    //保存项目合规材料
    private void savePmComplianceMaterialsPmProjectMeetingPlanningIdItem(List<PmComplianceMaterialsSaveVO> insertList, PmProjectMeetingPlanning entity) {
        if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmComplianceMaterials> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmComplianceMaterials item = new PmComplianceMaterials();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        complianceMaterialsManager.saveBatch(itemList);
    }
    //更新项目合规材料
    private void updatePmComplianceMaterialsPmProjectMeetingPlanningIdItem(List<PmComplianceMaterialsUpdateVO> updateInsert, PmProjectMeetingPlanning entity, PmProjectMeetingPlanning old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmComplianceMaterials> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmComplianceMaterials item = new PmComplianceMaterials();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        complianceMaterialsManager.updateBatchById(itemList);
    }
    //删除项目合规材料
    private boolean removePmComplianceMaterialsPmProjectMeetingPlanningIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return complianceMaterialsManager.removeByIds(idList);
    }

    //保存会议规划执行标准
    private BigDecimal savePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdItem(List<PmMeetingPlanExeStandardsSaveVO> insertList, PmProjectMeetingPlanning entity) {
	  if (CollUtil.isEmpty(insertList)) {
            return BigDecimal.ZERO;
        }
        BigDecimal inMeetingExecutionCost = BigDecimal.ZERO;
        List<PmMeetingPlanExeStandards> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            inMeetingExecutionCost.add(insert.getAmountMoney());
            PmMeetingPlanExeStandards item = new PmMeetingPlanExeStandards();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        meetingPlanExeStandardsManager.saveBatch(itemList);
        return inMeetingExecutionCost;
	 }
    //更新会议规划执行标准
    private BigDecimal updatePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdItem(List<PmMeetingPlanExeStandardsUpdateVO> updateInsert, PmProjectMeetingPlanning entity, PmProjectMeetingPlanning old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return BigDecimal.ZERO;
        }
        BigDecimal inMeetingExecutionCost = BigDecimal.ZERO;
        List<PmMeetingPlanExeStandards> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmMeetingPlanExeStandards byId = meetingPlanExeStandardsManager.getById(insert.getId());
            inMeetingExecutionCost.add(insert.getAmountMoney()).subtract(byId.getAmountMoney());
            PmMeetingPlanExeStandards item = new PmMeetingPlanExeStandards();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        meetingPlanExeStandardsManager.updateBatchById(itemList);
        return inMeetingExecutionCost;
    }
    //删除会议规划执行标准
    private BigDecimal removePmMeetingPlanExeStandardsPmProjectMeetingPlanningIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return BigDecimal.ZERO;
        }
        BigDecimal inMeetingExecutionCost = BigDecimal.ZERO;
        for (Long aLong : idList) {
            PmMeetingPlanExeStandards byId = meetingPlanExeStandardsManager.getById(aLong);
            inMeetingExecutionCost = inMeetingExecutionCost.add(byId.getAmountMoney());
        }
        meetingExecutionReqManager.removeByIds(idList);
        return inMeetingExecutionCost;
    }
    //保存会议规划专家劳务标准
    private BigDecimal savePmExpertServiceStandardPmProjectMeetingPlanningIdItem(List<PmExpertServiceStandardSaveVO> insertList, PmProjectMeetingPlanning entity) {
        BigDecimal inExpertServiceExpenses = BigDecimal.ZERO;
     if (CollUtil.isEmpty(insertList)) {
            return inExpertServiceExpenses;
        }

        List<PmExpertServiceStandard> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            inExpertServiceExpenses.add(insert.getAmountMoney());
            PmExpertServiceStandard item = new PmExpertServiceStandard();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        expertServiceStandardManager.saveBatch(itemList);
        return inExpertServiceExpenses;
	 }
    //更新会议规划专家劳务标准
    private BigDecimal updatePmExpertServiceStandardPmProjectMeetingPlanningIdItem(List<PmExpertServiceStandardUpdateVO> updateInsert, PmProjectMeetingPlanning entity, PmProjectMeetingPlanning old) {
        BigDecimal inExpertServiceExpenses = BigDecimal.ZERO;
        if (CollUtil.isEmpty(updateInsert)) {
            return inExpertServiceExpenses;
        }
        List<PmExpertServiceStandard> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmExpertServiceStandard byId = expertServiceStandardManager.getById(insert.getId());
            inExpertServiceExpenses.add(insert.getAmountMoney()).subtract(byId.getAmountMoney());
            PmExpertServiceStandard item = new PmExpertServiceStandard();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        expertServiceStandardManager.updateBatchById(itemList);
        return inExpertServiceExpenses;
    }
    //删除会议规划专家劳务标准
    private BigDecimal removePmExpertServiceStandardPmProjectMeetingPlanningIdSubByIds(Collection<Long> idList) {
        BigDecimal inExpertServiceExpenses = BigDecimal.ZERO;
        if (CollUtil.isEmpty(idList)) {
            return inExpertServiceExpenses;
        }
        for (Long aLong : idList) {
            PmExpertServiceStandard byId = expertServiceStandardManager.getById(aLong);
            inExpertServiceExpenses = inExpertServiceExpenses.add(byId.getAmountMoney());
        }
         expertServiceStandardManager.removeByIds(idList);
        return inExpertServiceExpenses;
    }
    //保存会议执行要求
    private void savePmMeetingExecutionReqPmProjectMeetingPlanningIdItem(List<PmMeetingExecutionReqSaveVO> insertList, PmProjectMeetingPlanning entity) {
	  if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmMeetingExecutionReq> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmMeetingExecutionReq item = new PmMeetingExecutionReq();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        meetingExecutionReqManager.saveBatch(itemList);
	 }
    //更新会议执行要求
    private void updatePmMeetingExecutionReqPmProjectMeetingPlanningIdItem(List<PmMeetingExecutionReqUpdateVO> updateInsert, PmProjectMeetingPlanning entity, PmProjectMeetingPlanning old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmMeetingExecutionReq> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmMeetingExecutionReq item = new PmMeetingExecutionReq();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmProjectMeetingPlanningId(entity.getId());
            itemList.add(item);
        });
        meetingExecutionReqManager.updateBatchById(itemList);
    }
    //删除会议执行要求
    private boolean removePmMeetingExecutionReqPmProjectMeetingPlanningIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return meetingExecutionReqManager.removeByIds(idList);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmProjectMeetingPlanning copy(Long id) {
        PmProjectMeetingPlanning old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        PmProjectMeetingPlanning entity = BeanPlusUtil.toBean(old, PmProjectMeetingPlanning.class);
        entity.setId(null);
        superManager.save(entity);
		//循环复制子表
		LbQueryWrap<PmMeetingPlanExeStandards> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdwrap = Wraps.<PmMeetingPlanExeStandards>lbQ().eq(PmMeetingPlanExeStandards::getPmProjectMeetingPlanningId,old.getId());
        List<PmMeetingPlanExeStandards> itemList0 = meetingPlanExeStandardsManager.list(pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingPlanningId(entity.getId());
        });
        meetingPlanExeStandardsManager.saveBatch(itemList0);
		LbQueryWrap<PmExpertServiceStandard> pmExpertServiceStandardPmProjectMeetingPlanningIdwrap = Wraps.<PmExpertServiceStandard>lbQ().eq(PmExpertServiceStandard::getPmProjectMeetingPlanningId,old.getId());
        List<PmExpertServiceStandard> itemList1 = expertServiceStandardManager.list(pmExpertServiceStandardPmProjectMeetingPlanningIdwrap);
        itemList1.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingPlanningId(entity.getId());
        });
        expertServiceStandardManager.saveBatch(itemList1);
		LbQueryWrap<PmMeetingExecutionReq> pmMeetingExecutionReqPmProjectMeetingPlanningIdwrap = Wraps.<PmMeetingExecutionReq>lbQ().eq(PmMeetingExecutionReq::getPmProjectMeetingPlanningId,old.getId());
        List<PmMeetingExecutionReq> itemList2 = meetingExecutionReqManager.list(pmMeetingExecutionReqPmProjectMeetingPlanningIdwrap);
        itemList2.forEach(item -> {
            item.setId(null);
            item.setPmProjectMeetingPlanningId(entity.getId());
        });
        meetingExecutionReqManager.saveBatch(itemList2);


        return entity;
    }

    /**
     * 1.查询项目信息
     * 2。修改项目信息
     * 3.新增
     * @param saveVO
     * @throws Exception
     */
    @Override
    public void insert(PmProjectMeetingPlanningSaveVO saveVO) throws Exception {
        PmProject pmProjectvo = projectService.getById(saveVO.getPmProjectId());
        if(pmProjectvo==null){
            throw new Exception("信息有误，请重新提交");
        }
        //会议规划剩余场次
        String meetingSchedule = pmProjectvo.getMeetingSchedule();
        //本次规划执行场次数量
        Integer meetingPlanNum = saveVO.getMeetingPlanNum();
        if(Integer.parseInt(meetingSchedule)- meetingPlanNum < 0){
            throw new Exception("执行场次不得超过项目剩余场次");
        }
        //本规划分配金额
        BigDecimal totalBudgetAmount = saveVO.getTotalBudgetAmount();
        if( pmProjectvo.getRemainingBudgetAmount().compareTo(totalBudgetAmount)==-1){
            throw new Exception("本次规划金额不得超过项目剩余分配金额！");
        }
        //其中专家劳务费用
        BigDecimal inExpertServiceExpenses = BigDecimal.ZERO;
        if(saveVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdInsertList().size()>0){
            for (PmExpertServiceStandardSaveVO pmExpertServiceStandardSaveVO : saveVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdInsertList()) {
                inExpertServiceExpenses = inExpertServiceExpenses.add(pmExpertServiceStandardSaveVO.getAmountMoney());
            }
        }
        //其中会议执行费用
        BigDecimal inMeetingExecutionCost = BigDecimal.ZERO;
        if(saveVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList().size()>0){
            for (PmMeetingPlanExeStandardsSaveVO pmMeetingPlanExeStandardsSaveVO : saveVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList()) {
                inMeetingExecutionCost = inMeetingExecutionCost.add(pmMeetingPlanExeStandardsSaveVO.getAmountMoney());
            }
        }
        saveVO.setInExpertServiceExpenses(inExpertServiceExpenses);
        saveVO.setInMeetingExecutionCost(inMeetingExecutionCost);
        PmProjectUpdateVO pmProjectUpdateVO = new PmProjectUpdateVO();
        pmProjectUpdateVO.setMeetingSchedule(String.valueOf(Integer.parseInt(meetingSchedule)-meetingPlanNum));
        pmProjectUpdateVO.setId(pmProjectvo.getId());

        pmProjectUpdateVO.setRemainingBudgetAmount(pmProjectvo.getRemainingBudgetAmount().subtract(totalBudgetAmount));
        BigDecimal meetingBudgetOccupied = BigDecimal.ZERO;
        if(pmProjectvo.getMeetingBudgetOccupied()!=null){
            meetingBudgetOccupied = pmProjectvo.getMeetingBudgetOccupied();
        }

        pmProjectUpdateVO.setMeetingBudgetOccupied(meetingBudgetOccupied.add(totalBudgetAmount));
        pmProjectUpdateVO.setMeetingPlanningStatus(DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_01);
        Integer projectMeetingPlanNum = 0;
        if(pmProjectvo.getMeetingPlanNum()!=null){
            projectMeetingPlanNum = pmProjectvo.getMeetingPlanNum();
        }
        pmProjectUpdateVO.setMeetingPlanNum(projectMeetingPlanNum + meetingPlanNum);
        projectService.updateById(pmProjectUpdateVO);
        this.save(saveVO);
    }
    /**
     * 1.查询项目信息
     * 2。修改项目信息
     * 3.修改
     * @param
     * @throws Exception
     */
    @Override
    public void update(PmProjectMeetingPlanningUpdateVO udateVO) throws Exception {
        //查询旧数据，用来防止重复扣减场次
        PmProjectMeetingPlanning oldVO = this.getById(udateVO.getId());
        Integer oldnumber = 0;
        if( oldVO.getExecutionSessionsNumber()!=null){
            oldnumber =oldVO.getExecutionSessionsNumber();
        }
        BigDecimal oldTotalBudgetAmount = BigDecimal.ZERO;
        if(oldVO.getTotalBudgetAmount()!=null){
            oldTotalBudgetAmount = oldVO.getTotalBudgetAmount();
        }
        PmProject pmProjectvo = projectService.getById(udateVO.getPmProjectId());
        if(pmProjectvo==null){
            throw new Exception("信息有误，请重新提交");
        }
        //会议规划剩余场次
        String meetingSchedule = pmProjectvo.getMeetingSchedule();
        //本次规划执行场次数量
        Integer meetingPlanNum = udateVO.getMeetingPlanNum();
        if((Integer.parseInt(meetingSchedule) + oldnumber) - meetingPlanNum < 0){
            throw new Exception("执行场次不得超过项目剩余场次");
        }
        //本规划分配金额
        BigDecimal totalBudgetAmount = BigDecimal.ZERO;
        if(udateVO.getTotalBudgetAmount()!=null){
            totalBudgetAmount = udateVO.getTotalBudgetAmount();
        }
        if( (pmProjectvo.getRemainingBudgetAmount().add(oldTotalBudgetAmount)).compareTo(totalBudgetAmount)==-1){
            throw new Exception("本次规划金额不得超过项目剩余分配金额！");
        }
        PmProjectUpdateVO pmProjectUpdateVO = new PmProjectUpdateVO();
        pmProjectUpdateVO.setMeetingSchedule(String.valueOf(Integer.parseInt(meetingSchedule)+ oldnumber - meetingPlanNum));
        pmProjectUpdateVO.setId(pmProjectvo.getId());
        pmProjectUpdateVO.setRemainingBudgetAmount((pmProjectvo.getRemainingBudgetAmount().add(oldTotalBudgetAmount)).subtract(totalBudgetAmount));
        BigDecimal meetingBudgetOccupied = BigDecimal.ZERO;
        if(pmProjectUpdateVO.getMeetingBudgetOccupied()!=null){
            meetingBudgetOccupied = pmProjectUpdateVO.getMeetingBudgetOccupied();
        }
        pmProjectUpdateVO.setMeetingBudgetOccupied(meetingBudgetOccupied.subtract(oldTotalBudgetAmount).add(totalBudgetAmount));
        Integer projectMeetingPlanNum = 0;
        if(pmProjectvo.getMeetingPlanNum()!=null){
            projectMeetingPlanNum = pmProjectvo.getMeetingPlanNum();
        }
        pmProjectUpdateVO.setMeetingPlanNum(projectMeetingPlanNum + meetingPlanNum);
        projectService.updateById(pmProjectUpdateVO);
        updateById(udateVO);
    }

    /**
     * 规划提交审核
     * @param
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void commitAudit(Long projectId) throws Exception {
        //查询项目信息，检查场次是否规划完成
        PmProject pmProject = projectService.getById(projectId);
        if(Integer.valueOf(pmProject.getMeetingSchedule()) > 0){
            throw new Exception("项目还有剩余"+pmProject.getMeetingSchedule()+"场次未规划，请规划完成后再提交");
        }
        //检查分配金额是否还有剩余，有剩余不允许提交
        if(pmProject.getRemainingBudgetAmount().compareTo(BigDecimal.ZERO) != 0){
            throw new Exception("项目还有剩余"+pmProject.getRemainingBudgetAmount()+"金额未规划，请规划完成后再提交");
        }
        //查询该项目所有规划中的专家费用和会议费用
        QueryWrap<PmProjectMeetingPlanning> queryWrap = new QueryWrap<>();
        queryWrap.eq("PM_PROJECT_ID",projectId);
        List<PmProjectMeetingPlanning> listPlans = list(queryWrap);
        if(CollectionUtils.isEmpty(listPlans)){
            throw new Exception("查询规划信息有误！");
        }
        BigDecimal allInExpertServiceExpenses =BigDecimal.ZERO;
        BigDecimal allInMeetingExecutionCost = BigDecimal.ZERO;
        for (PmProjectMeetingPlanning listPlan : listPlans) {
            BigDecimal inExpertServiceExpenses = listPlan.getInExpertServiceExpenses();
            allInExpertServiceExpenses = allInExpertServiceExpenses.add(inExpertServiceExpenses);
            BigDecimal inMeetingExecutionCost = listPlan.getInMeetingExecutionCost();
            allInMeetingExecutionCost = allInMeetingExecutionCost.add(inMeetingExecutionCost);
        }
        BigDecimal totalAmount = allInExpertServiceExpenses.add(allInMeetingExecutionCost);
        PmProjectUpdateVO projectUpdateVO = new PmProjectUpdateVO();
        projectUpdateVO.setId(projectId);
        //项目会议预算已占用
        projectUpdateVO.setMeetingBudgetOccupied(pmProject.getTotalBudgetAmount());
        //项目剩余可支配金额
        projectUpdateVO.setRemainingBudgetAmount(BigDecimal.ZERO);
        //项目会议规划状态
        projectUpdateVO.setMeetingPlanningStatus(DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_02);
        //发起工作流
        SearchToDoVO searchToDoVO = new SearchToDoVO();
        searchToDoVO.setBusinessId(projectId);
        searchToDoVO.setBusinessType(DSConstant.DICTIONARY_BUSINESS_TYPE_02);
        searchToDoVO.setProcessName(DSConstant.DICTIONARY_PROCESS_NAME_PROJECT_PLAN);
        searchToDoVO.setProcessInstanceId(0);
        StartVO startVO = StartVO.builder().businessType(DSConstant.DICTIONARY_BUSINESS_TYPE_01)
                .businessId(projectId)
                .toDoId(workFlowService.getToDoList(searchToDoVO))
                .processName(DSConstant.DICTIONARY_PROCESS_NAME_PROJECT_PLAN)
                .businessInfo(JSONObject.toJSONString(pmProject))
                .applicantId(ContextUtil.getApplicationId())
                .applicantName(ContextUtil.getUserName())
                .build();
        workFlowService.startFlow(startVO);
        projectService.updateById(projectUpdateVO);

    }

    /**
     *
     * @param projectId
     * @throws Exception
     */
    @Override
    public void commitPlanAdjustAudit(Long projectId) throws Exception {
        //根据项目id查询调整记录信息
        QueryWrapper<PmProjectPlanAdjustRecord> queryWrapper = new QueryWrapper();
        queryWrapper.eq("PM_PROJECT_ID",projectId).eq("STATUS",DSConstant.DICTIONARY_ADJUST_STATUS_01);
        List<PmProjectPlanAdjustRecord> pmProjectPlanAdjustRecords = pmProjectPlanAdjustRecordMapper.selectList(queryWrapper);
        if (pmProjectPlanAdjustRecords.size() < 1) {
            throw new Exception("调整信息有误！");
        }
        PmProjectPlanAdjustRecord pmProjectPlanAdjustRecord = pmProjectPlanAdjustRecords.get(0);
        //发起工作流
        SearchToDoVO searchToDoVO = new SearchToDoVO();
        searchToDoVO.setBusinessId(pmProjectPlanAdjustRecord.getId());
        searchToDoVO.setBusinessType(DSConstant.DICTIONARY_BUSINESS_TYPE_07);
        searchToDoVO.setProcessName(DSConstant.DICTIONARY_PROCESS_NAME_PROJECT_ADJUST);
        searchToDoVO.setProcessInstanceId(0);
        StartVO startVO = StartVO.builder().businessType(DSConstant.DICTIONARY_BUSINESS_TYPE_07)
                .businessId(pmProjectPlanAdjustRecords.get(0).getId())
                .toDoId(workFlowService.getToDoList(searchToDoVO))
                .processName(DSConstant.DICTIONARY_PROCESS_NAME_PROJECT_ADJUST)
                .businessInfo(JSONObject.toJSONString(pmProjectPlanAdjustRecord))
                .applicantId(ContextUtil.getApplicationId())
                .applicantName(ContextUtil.getUserName())
                .build();
        workFlowService.startFlow(startVO);
        pmProjectPlanAdjustRecord.setStatus(DSConstant.DICTIONARY_ADJUST_STATUS_02);
        pmProjectPlanAdjustRecordMapper.updateAllById(pmProjectPlanAdjustRecord);
    }

    //工作流审批页面展示数据
    @Transactional(rollbackFor = Exception.class)
    public PmProjectAudit auditPage(Long projectId){
        //开启工作流
        PmProjectAudit audit = new PmProjectAudit();
        try {
            //查询项目信息
            PmProject pmProject = projectService.getById(projectId);
            PmProjectSaveVO pmProjectSaveVO = BeanPlusUtil.toBean(pmProject, PmProjectSaveVO.class);
            //查询项目干系人
            QueryWrap<PmProjectStakeholder> queryWrapStakeholde = new QueryWrap<>();
            queryWrapStakeholde.eq("PM_PROJECT_ID",projectId);
            List<PmProjectStakeholder> pmProjectStakeholders = pmProjectStakeholderService.list(queryWrapStakeholde);
            List<PmProjectStakeholderSaveVO> pmProjectStakeholderSaveVOS = BeanPlusUtil.toBeanList(pmProjectStakeholders, PmProjectStakeholderSaveVO.class);
            pmProjectSaveVO.setPmProjectStakeholderPmProjectIdInsertList(pmProjectStakeholderSaveVOS);
             audit = BeanPlusUtil.toBean(pmProjectSaveVO,PmProjectAudit.class);
            //查询项目规划信息
            QueryWrap<PmProjectMeetingPlanning> queryPlan = new QueryWrap<>();
            queryPlan.eq("PM_PROJECT_ID",projectId);
            List<PmProjectMeetingPlanning> listPlans = this.list(queryPlan);
            List<PmProjectMeetingPlanningUpdateVO> pmProjectMeetingPlanningSaveVOS = BeanPlusUtil.toBeanList(listPlans, PmProjectMeetingPlanningUpdateVO.class);
            for (PmProjectMeetingPlanningUpdateVO pmProjectMeetingPlanningSaveVO : pmProjectMeetingPlanningSaveVOS) {
                //会议费用标准
                QueryWrap<PmMeetingPlanExeStandards> queryWrapPmMeetingPlanExeStandards = new QueryWrap<>();
                queryWrapPmMeetingPlanExeStandards.eq("PM_PROJECT_MEETING_PLANNING_ID",pmProjectMeetingPlanningSaveVO.getId());
                List<PmMeetingPlanExeStandards> pmMeetingPlanExeStandards = meetingPlanExeStandardsManager.list(queryWrapPmMeetingPlanExeStandards);
                List<PmMeetingPlanExeStandardsUpdateVO> pmMeetingPlanExeStandardsUpdateVOS = BeanPlusUtil.toBeanList(pmMeetingPlanExeStandards, PmMeetingPlanExeStandardsUpdateVO.class);
                pmProjectMeetingPlanningSaveVO.setPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList(pmMeetingPlanExeStandardsUpdateVOS);
                //专家讲师标准
                QueryWrap<PmExpertServiceStandard> queryWrapPmExpertServiceStandard = new QueryWrap<>();
                queryWrapPmExpertServiceStandard.eq("PM_PROJECT_MEETING_PLANNING_ID",pmProjectMeetingPlanningSaveVO.getId());
                List<PmExpertServiceStandard> pmExpertServiceStandards = expertServiceStandardManager.list(queryWrapPmExpertServiceStandard);
                List<PmExpertServiceStandardUpdateVO> pmExpertServiceStandardUpdateVOS = BeanPlusUtil.toBeanList(pmExpertServiceStandards, PmExpertServiceStandardUpdateVO.class);
                pmProjectMeetingPlanningSaveVO.setPmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList(pmExpertServiceStandardUpdateVOS);
                //执行要求
                QueryWrap<PmMeetingExecutionReq> queryWrapPmMeetingExecutionReq = new QueryWrap<>();
                queryWrapPmMeetingExecutionReq.eq("PM_PROJECT_MEETING_PLANNING_ID",pmProjectMeetingPlanningSaveVO.getId());
                List<PmMeetingExecutionReq> pmMeetingExecutionReqs = meetingExecutionReqManager.list(queryWrapPmMeetingExecutionReq);
                List<PmMeetingExecutionReqUpdateVO> pmMeetingExecutionReqUpdateVOS = BeanPlusUtil.toBeanList(pmMeetingExecutionReqs, PmMeetingExecutionReqUpdateVO.class);
                pmProjectMeetingPlanningSaveVO.setPmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList(pmMeetingExecutionReqUpdateVOS);
            }
            audit.setPlanningVOS(pmProjectMeetingPlanningSaveVOS);
         return audit;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 审批接口
     * @param auditVO
     * @throws Exception
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void audit(AuditVO auditVO) throws Exception {
        //查询流程实例是否结束
        List<PmProcessPhaseInstance> auditList = workFlowService.getAuditList(auditVO.getPmApprovalProcessInstanceId());
        PmProcessPhaseInstance pmProcessPhaseInstance = auditList.get(0);
        String status = DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_04;
        if(auditVO.getAgreest().equals(DSConstant.DICTIONARY_RM_YES_NOT_1)){
            workFlowService.auditPass(auditVO);
        }else {
            status = DSConstant.DICTIONARY_MEETING_PLANNING_STATUS_03;
            workFlowService.auditNoPass(auditVO);
        }
        //如果流程实例结束，修改业务表状态
        if(pmProcessPhaseInstance.getIsEnd().equals(DSConstant.DICTIONARY_RM_YES_NOT_1)){
            PmProject pmProject = projectService.getById(auditVO.getBusinessId());
            if(pmProject==null){
                throw new Exception("项目信息有误，刷新后重新提交！");
            }
            //判断工作流是否通过
            PmProjectUpdateVO updateVO = new PmProjectUpdateVO();
            updateVO.setId(auditVO.getBusinessId());
            updateVO.setMeetingPlanningStatus(status);
            projectService.updateById(updateVO);
        }


    }

    /**
     *规划调整接口
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void adjustPlan(PmProjectMeetingPlanningUpdateVO updateVO) throws Exception {
        //修改项目信息调整状态为在调
        PmProjectUpdateVO pmProjectUpdateVO = new PmProjectUpdateVO();
        pmProjectUpdateVO.setId(updateVO.getPmProjectId());
        pmProjectUpdateVO.setAdjustStatus(DSConstant.DICTIONARY_ADJUST_STATUS_01);
        projectService.updateById(pmProjectUpdateVO);
        //查询是否有调整记录表
        QueryWrapper<PmProjectPlanAdjustRecord> queryWrapper = new QueryWrapper();
        queryWrapper.eq("PM_PROJECT_ID",updateVO.getId()).eq("STATUS",DSConstant.DICTIONARY_ADJUST_STATUS_01);
        List<PmProjectPlanAdjustRecord> pmProjectPlanAdjustRecords = pmProjectPlanAdjustRecordMapper.selectList(queryWrapper);

        //先创建或修改调整记录表
        PmProjectPlanAdjustRecordSaveVO saveVO = new PmProjectPlanAdjustRecordSaveVO();
        saveVO.setStatus(DSConstant.DICTIONARY_COMMIT_AUDIT_STATUS_01);
        saveVO.setPmProjectId(updateVO.getPmProjectId());
        saveVO.setProjectName(updateVO.getProjectName());
        Long recordId = null;
        if(pmProjectPlanAdjustRecords.size()>0){
            recordId  = pmProjectPlanAdjustRecords.get(0).getId();
        }else {
            PmProjectPlanAdjustRecord save = pmProjectPlanAdjustRecordService.save(saveVO);
            recordId  = save.getId();
        }
        //规划主表调整
        Long planId = adjustPmProjectMeetingPlanning(updateVO,recordId);
        //查询子表是否为空 会议规划专家劳务标准
        adjustPmExpertServiceStandard(updateVO,planId);
        //查询子表是否为空 会议执行要求
        adjustPmMeetingExecutionReq(updateVO,planId);
        //查询子表是否为空 会议规划执行标准
        adjustPmMeetingPlanExeStandards(updateVO,planId);
    }

    @Override
    public List<PmProjectMeetingPlanning> getByPhone(String phone) {
        return pmProjectMeetingPlanningMapper.getByPhone(phone);
    }

    /**
     * 项目规划主表调整
     */
    public Long  adjustPmProjectMeetingPlanning(PmProjectMeetingPlanningUpdateVO updateVO,Long adjustrecordId){
        //查询旧数据
        PmProjectMeetingPlanning oldPlan = getById(updateVO.getId());
        //新增规划调整记录
        PmProjectMeetingPlanAdjustSaveVO saveVO = new PmProjectMeetingPlanAdjustSaveVO();
        saveVO.setPmProjectPlanAdjustRecordId(adjustrecordId);
        saveVO =BeanPlusUtil.toBean(oldPlan,PmProjectMeetingPlanAdjustSaveVO.class);
        //旧数据
        saveVO.setOldExecutionSessionsNumber(oldPlan.getExecutionSessionsNumber());
        saveVO.setAdjustExecutionSessionsNumber(updateVO.getExecutionSessionsNumber());
        saveVO.setNowExecutionSessionsNumber(updateVO.getRemainingUnallocatedNum());
        saveVO.setMeetingFeeStandard(oldPlan.getMeetingFeeStandard());
        saveVO.setTotalBudgetAmount(oldPlan.getTotalBudgetAmount());
        saveVO.setOldTotalBudgetAmount(updateVO.getTotalBudgetAmount());
        saveVO.setAdjustTotalBudgetAmount(updateVO.getTotalBudgetAmount());
        saveVO.setMeetingFeeStandard2(updateVO.getMeetingFeeStandard());
        saveVO.setInLaborCostOfEachExpert(oldPlan.getInExpertServiceExpenses());
        saveVO.setInCurrentExpertServiceFee(updateVO.getInExpertServiceExpenses());
        saveVO.setInOriginalMeetingExecutionCost(oldPlan.getInMeetingExecutionCost());
        saveVO.setInCurrentMeetingExecCost(updateVO.getInMeetingExecutionCost());
        PmProjectMeetingPlanAdjust save = pmProjectMeetingPlanAdjustService.save(saveVO);
        return save.getId();
        //新数据
    }
    /**
     * 会议规划专家劳务标准
     */
    public void  adjustPmExpertServiceStandard(PmProjectMeetingPlanningUpdateVO updateVO,Long planId){
        List<Long> pmExpertServiceStandardPmProjectMeetingPlanningIdDeleteList = updateVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdDeleteList();
        if(CollectionUtils.isNotEmpty(pmExpertServiceStandardPmProjectMeetingPlanningIdDeleteList)){
            for (Long aLong : pmExpertServiceStandardPmProjectMeetingPlanningIdDeleteList) {
                PmExpertServiceStandard byId = expertServiceStandardManager.getById(aLong);
                PmExpertServiceStandardAdjSaveVO saveVO = BeanPlusUtil.toBean(byId, PmExpertServiceStandardAdjSaveVO.class);
                saveVO.setPmProjectMeetingPlanAdjustId(planId);
                saveVO.setServiceTax(BigDecimal.ZERO);
                saveVO.setAmountMoney(BigDecimal.ZERO);
                saveVO.setOriginalTaxDeductionExpense(byId.getActualPay());
                saveVO.setOriginalServiceTax(byId.getServiceTax());
                saveVO.setOriginalAmountMoney(byId.getAmountMoney());
                saveVO.setTaxDeductionExpense(BigDecimal.ZERO);
                pmExpertServiceStandardAdjService.save(saveVO);
            }
        }
        List<PmExpertServiceStandardSaveVO> pmExpertServiceStandardPmProjectMeetingPlanningIdInsertList = updateVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdInsertList();
        if(CollectionUtils.isNotEmpty(pmExpertServiceStandardPmProjectMeetingPlanningIdInsertList)){
            for (PmExpertServiceStandardSaveVO pmExpertServiceStandardSaveVO : pmExpertServiceStandardPmProjectMeetingPlanningIdInsertList) {
                PmExpertServiceStandardAdjSaveVO saveVO =  BeanPlusUtil.toBean(pmExpertServiceStandardSaveVO, PmExpertServiceStandardAdjSaveVO.class);
                saveVO.setPmProjectMeetingPlanAdjustId(planId);
                saveVO.setOriginalTaxDeductionExpense(BigDecimal.ZERO);
                saveVO.setOriginalServiceTax(BigDecimal.ZERO);
                saveVO.setOriginalAmountMoney(BigDecimal.ZERO);
                saveVO.setTaxDeductionExpense(pmExpertServiceStandardSaveVO.getActualPay());
                pmExpertServiceStandardAdjService.save(saveVO);
            }
        }
        List<PmExpertServiceStandardUpdateVO> pmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList = updateVO.getPmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList();
        if(CollectionUtils.isNotEmpty(pmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList)){
            for (PmExpertServiceStandardUpdateVO pmExpertServiceStandardUpdateVO : pmExpertServiceStandardPmProjectMeetingPlanningIdUpdateList) {
                PmExpertServiceStandard byId = expertServiceStandardManager.getById(pmExpertServiceStandardUpdateVO.getId());
                PmExpertServiceStandardAdjSaveVO saveVO =  BeanPlusUtil.toBean(pmExpertServiceStandardUpdateVO, PmExpertServiceStandardAdjSaveVO.class);
                saveVO.setPmProjectMeetingPlanAdjustId(planId);
                saveVO.setOriginalTaxDeductionExpense(byId.getActualPay());
                saveVO.setOriginalServiceTax(byId.getServiceTax());
                saveVO.setOriginalAmountMoney(byId.getAmountMoney());
                saveVO.setTaxDeductionExpense(pmExpertServiceStandardUpdateVO.getActualPay());
                pmExpertServiceStandardAdjService.save(saveVO);
            }
        }

    }
    /**
     * 会议执行要求
     */
    public void  adjustPmMeetingExecutionReq(PmProjectMeetingPlanningUpdateVO updateVO,Long planId){
        List<Long> pmMeetingExecutionReqPmProjectMeetingPlanningIdDeleteList = updateVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdDeleteList();
        if(CollectionUtils.isNotEmpty(pmMeetingExecutionReqPmProjectMeetingPlanningIdDeleteList)){
            for (Long aLong : pmMeetingExecutionReqPmProjectMeetingPlanningIdDeleteList) {
                PmMeetingExecutionReq byId = meetingExecutionReqManager.getById(aLong);
                PmMeetingExecutionReqAdjustSaveVO pmMeetingExecutionReqAdjustSaveVO = BeanPlusUtil.toBean(byId, PmMeetingExecutionReqAdjustSaveVO.class);
                pmMeetingExecutionReqAdjustSaveVO.setPmProjectMeetingPlanAdjustId(planId);
                pmMeetingExecutionReqAdjustService.save(pmMeetingExecutionReqAdjustSaveVO);
            }
        }
        List<PmMeetingExecutionReqUpdateVO> pmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList = updateVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList();
        if(CollectionUtils.isNotEmpty(pmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList)){
            for (PmMeetingExecutionReqUpdateVO pmMeetingExecutionReqUpdateVO : pmMeetingExecutionReqPmProjectMeetingPlanningIdUpdateList) {
                PmMeetingExecutionReqAdjustSaveVO pmMeetingExecutionReqAdjustSaveVO = BeanPlusUtil.toBean(pmMeetingExecutionReqUpdateVO, PmMeetingExecutionReqAdjustSaveVO.class);
                pmMeetingExecutionReqAdjustSaveVO.setPmProjectMeetingPlanAdjustId(planId);
                pmMeetingExecutionReqAdjustService.save(pmMeetingExecutionReqAdjustSaveVO);
            }
        }
        List<PmMeetingExecutionReqSaveVO> pmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList = updateVO.getPmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList();
        if(CollectionUtils.isNotEmpty(pmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList)){
            for (PmMeetingExecutionReqSaveVO pmMeetingExecutionReqSaveVO : pmMeetingExecutionReqPmProjectMeetingPlanningIdInsertList) {
                PmMeetingExecutionReqAdjustSaveVO pmMeetingExecutionReqAdjustSaveVO = BeanPlusUtil.toBean(pmMeetingExecutionReqSaveVO, PmMeetingExecutionReqAdjustSaveVO.class);
                pmMeetingExecutionReqAdjustSaveVO.setPmProjectMeetingPlanAdjustId(planId);
                pmMeetingExecutionReqAdjustService.save(pmMeetingExecutionReqAdjustSaveVO);
            }
        }
    }
    /**
     * 会议规划执行标准
     */
    public void  adjustPmMeetingPlanExeStandards(PmProjectMeetingPlanningUpdateVO updateVO,Long planId){
        List<Long> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdDeleteList = updateVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdDeleteList();
        if(CollectionUtils.isNotEmpty(pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdDeleteList)){
            for (Long aLong : pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdDeleteList) {
                PmMeetingPlanExeStandards byId = meetingPlanExeStandardsManager.getById(aLong);
                PmMeetingPlanExeStandardsAdjSaveVO standardsAdjSaveVO = BeanPlusUtil.toBean(byId,PmMeetingPlanExeStandardsAdjSaveVO.class);
                standardsAdjSaveVO.setOldAmount(byId.getAmountMoney());
                standardsAdjSaveVO.setAmountMoney(BigDecimal.ZERO);
                standardsAdjSaveVO.setPmProjectMeetingPlanAdjustId(planId);
                pmMeetingPlanExeStandardsAdjService.save(standardsAdjSaveVO);
            }
        }
        List<PmMeetingPlanExeStandardsSaveVO> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList = updateVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList();
        if(CollectionUtils.isNotEmpty(pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList)){
            for (PmMeetingPlanExeStandardsSaveVO pmMeetingPlanExeStandardsSaveVO : pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdInsertList) {
                PmMeetingPlanExeStandardsAdjSaveVO standardsAdjSaveVO = BeanPlusUtil.toBean(pmMeetingPlanExeStandardsSaveVO,PmMeetingPlanExeStandardsAdjSaveVO.class);
                standardsAdjSaveVO.setOldAmount(BigDecimal.ZERO);
                standardsAdjSaveVO.setAmountMoney(pmMeetingPlanExeStandardsSaveVO.getAmountMoney());
                standardsAdjSaveVO.setPmProjectMeetingPlanAdjustId(planId);
                pmMeetingPlanExeStandardsAdjService.save(standardsAdjSaveVO);

            }
        }
        List<PmMeetingPlanExeStandardsUpdateVO> pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList = updateVO.getPmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList();
        if(CollectionUtils.isNotEmpty(pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList)){
            for (PmMeetingPlanExeStandardsUpdateVO pmMeetingPlanExeStandardsUpdateVO : pmMeetingPlanExeStandardsPmProjectMeetingPlanningIdUpdateList) {
                PmMeetingPlanExeStandards byId = meetingPlanExeStandardsManager.getById(pmMeetingPlanExeStandardsUpdateVO.getId());
                PmMeetingPlanExeStandardsAdjSaveVO standardsAdjSaveVO = BeanPlusUtil.toBean(pmMeetingPlanExeStandardsUpdateVO,PmMeetingPlanExeStandardsAdjSaveVO.class);
                standardsAdjSaveVO.setOldAmount(byId.getAmountMoney());
                standardsAdjSaveVO.setAmountMoney(pmMeetingPlanExeStandardsUpdateVO.getAmountMoney());
                standardsAdjSaveVO.setPmProjectMeetingPlanAdjustId(planId);
                pmMeetingPlanExeStandardsAdjService.save(standardsAdjSaveVO);

            }
        }

    }


// 根据项目得项目会议规划
//    @Override
//    public Object getpmProjectMeetingPlanningList(WO wo) {
//
//     if(wo.getDataId()!=null){
//         List<PmProjectMeetingPlanning> pmProjectMeetingPlanningList=pmProjectMeetingPlanningMapper.getByPmProjectId(wo.getDataId());
//         return pmProjectMeetingPlanningList;
//     }
//
//        return null;
//    }
}
