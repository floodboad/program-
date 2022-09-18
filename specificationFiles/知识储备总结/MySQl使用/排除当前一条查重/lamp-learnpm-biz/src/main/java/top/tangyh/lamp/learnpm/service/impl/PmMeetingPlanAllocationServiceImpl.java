package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.poi.hpsf.Decimal;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.*;
import top.tangyh.lamp.learnpm.entity.PmProjectMeetingPlanning;
import top.tangyh.lamp.learnpm.manager.PmMeetingPlanAllocationManager;
import top.tangyh.lamp.learnpm.manager.PmProjectMeetingPlanningManager;
import top.tangyh.lamp.learnpm.manager.PmProjectStakeholderManager;
import top.tangyh.lamp.learnpm.mapper.PmMeetingPlanAllocationMapper;
import top.tangyh.lamp.learnpm.mapper.PmProjectMeetingPlanningMapper;
import top.tangyh.lamp.learnpm.service.*;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingPlanAllocationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingPlanAllocationResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceApplyFeeSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmConferenceExpertServicesSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingPlanAllocationSaveVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectMeetingApplySaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingPlanAllocationUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.vo.update.PmProjectMeetingPlanningUpdateVO;

import top.tangyh.lamp.learnpm.vo.update.PmProjectUpdateVO;
import top.tangyh.lamp.learnpm.wechat.Allocation;

import top.tangyh.lamp.learnpm.wechat.WO;

import top.tangyh.lamp.system.service.tenant.DefUserService;


import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 会议规划分配业务实现类
 *
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-13
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = false)
public class PmMeetingPlanAllocationServiceImpl extends SuperServiceImpl<PmMeetingPlanAllocationManager, Long, PmMeetingPlanAllocation, PmMeetingPlanAllocationSaveVO, PmMeetingPlanAllocationUpdateVO, PmMeetingPlanAllocationPageQuery, PmMeetingPlanAllocationResultVO>
        implements PmMeetingPlanAllocationService {
    private final PmProjectMeetingPlanningService pmProjectMeetingPlanningService;
    private final PmMeetingPlanExeStandardsService pmMeetingPlanExeStandardsService;
    private final PmExpertServiceStandardService pmExpertServiceStandardService;
    private final PmProjectService pmProjectService;
    private final PmProjectMeetingApplyService pmProjectMeetingApplyService;
    /**
     * 1.查询规划信息
     * 2。修改规划信息
     * 3.新增
     * @param saveVO
     * @throws Exception
     */

    @Override
    public void insert(PmMeetingPlanAllocationSaveVO saveVO) throws Exception {
        PmProjectMeetingPlanning plan = pmProjectMeetingPlanningService.getById(saveVO.getPmProjectMeetingPlanningId());
        if(plan==null){
            throw new Exception("规划信息有误，重新填写！");
        }
        Integer remainingUnallocatedNum = plan.getRemainingUnallocatedNum();
        Integer executionSessionsNumber = saveVO.getExecutionSessionsNumber();
        if(remainingUnallocatedNum < executionSessionsNumber){
            throw new Exception("分配数量不能超过规划剩余数量！");
        }
        PmProjectMeetingPlanningUpdateVO planningUpdateVO = new PmProjectMeetingPlanningUpdateVO();
        planningUpdateVO.setId(plan.getId());
        planningUpdateVO.setRemainingUnallocatedNum(remainingUnallocatedNum-executionSessionsNumber);
        planningUpdateVO.setAssignedQuantity(plan.getMeetingPlanNum()-planningUpdateVO.getRemainingUnallocatedNum());
        pmProjectMeetingPlanningService.updateById(planningUpdateVO);
        this.save(saveVO);
    }


    /**
     * 1.查询规划信息
     * 2。修改规划信息
     * 3.修改
     * @param
     * @throws Exception
     */
    @Override
    public void update(PmMeetingPlanAllocationUpdateVO updateVO) throws Exception {
        //查询旧数据，用来计算执行场次
        PmMeetingPlanAllocation oldVO = this.getById(updateVO.getId());
        PmProjectMeetingPlanning plan = pmProjectMeetingPlanningService.getById(updateVO.getPmProjectMeetingPlanningId());
        if(plan==null){
            throw new Exception("规划信息有误，重新填写！");
        }
        Integer remainingUnallocatedNum = plan.getRemainingUnallocatedNum();
        Integer executionSessionsNumber = updateVO.getExecutionSessionsNumber();
        //避免重复减,剩余未分配数量=上次执行数量+剩余未分配数量
        Integer lastNumber =remainingUnallocatedNum + oldVO.getExecutionSessionsNumber();
        if(lastNumber < executionSessionsNumber){
            throw new Exception("分配数量不能超过规划剩余数量！");
        }
        PmProjectMeetingPlanningUpdateVO planningUpdateVO = new PmProjectMeetingPlanningUpdateVO();
        planningUpdateVO.setId(plan.getId());
        planningUpdateVO.setRemainingUnallocatedNum(lastNumber - executionSessionsNumber);
        planningUpdateVO.setAssignedQuantity(plan.getMeetingPlanNum() - planningUpdateVO.getRemainingUnallocatedNum());
        pmProjectMeetingPlanningService.update(planningUpdateVO);
        this.updateById(updateVO);
    }

    /**
     * @author dz
     * 申请会议
     * @param id
     * @return
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public R meetingApply(Long id) {
        PmMeetingPlanAllocation r = superManager.getById(id);
//        PmMeetingPlanAllocationResultVO r = resultVOR.getData();
        //计算剩余可申请场次
        List<PmProjectMeetingApply> list = pmProjectMeetingApplyService.list(Wraps.<PmProjectMeetingApply>lbQ()
                .eq(PmProjectMeetingApply::getMeetingAllocationId, r.getId()));
        int size = list.size();
        if(r.getExecutionSessionsNumber()-size>0){
            //取出resultVO中的数据，set入会议申请的saveVO
            PmProjectMeetingApplySaveVO projectMeetingApplySaveVO=PmProjectMeetingApplySaveVO.builder()
                    .meetingAllocationId(r.getId())
                    .pmProjectMeetingPlanningId(r.getPmProjectMeetingPlanningId())
                    .pmProjectId(r.getPmProjectId())
                    .meetingSupportProjectName(r.getProjectName())
                    .meetingNoName(r.getProjectName())
                    .meetingTypeName(r.getMeetingTypeName())
                    .provinceCode(r.getProvinceCode())
                    .province(r.getProvince())
                    .meetingCityCode(r.getCityCode())
                    .meetingCityName(r.getMeetingCity())
                    .totalMeetingBudget(r.getTotalMeetingBudget())
                    .meetingStatus(DSConstant.DICTIONARY_MEETING_STATUS_01)
                    .meetingMode(r.getMeetingMode())
                    .chargePersonId(ContextUtil.getUserId())
                    .chargePersonName(ContextUtil.getUserName())
                    .meetingNoName(getMeetingNo(size))
                    .build();
            PmProjectMeetingApply entity = pmProjectMeetingApplyService.save(projectMeetingApplySaveVO);
            //更新已申请场次
            addMeetingOpenedTimes(r);
            //根据规划执行标准更新费用申请表（多条记录）
            pmProjectMeetingApplyService.savePmConferenceApplyFeePmProjectMeetingApplyIdItem(makeFeeList(r.getPmProjectMeetingPlanningId()),entity);
            //根据规划执行标准更新会议专家劳务表（多条记录）
            pmProjectMeetingApplyService.savePmConferenceExpertServicesPmProjectMeetingApplyIdItem(makeExpertServiceList(r.getPmProjectMeetingPlanningId()),entity);
            return R.success(entity,"OK");
        }else {
            return R.fail(0,"可用场次不足！");
        }
    }

    /**
     * @author dz
     * @param id
     * @return 费用List
     */
    public List<PmConferenceApplyFeeSaveVO> makeFeeList(Long id){
        ArrayList<PmConferenceApplyFeeSaveVO> list = new ArrayList<>();
        //根据规划id查询规划执行标准
        List<PmMeetingPlanExeStandards> meetingPlanExeStandards = pmMeetingPlanExeStandardsService.getMeetingPlanExeStandards(id);
        //未来可能需要判断是否为空
        if(meetingPlanExeStandards.isEmpty()){
            return list;
        }
        //把每条规划执行标准记录转为会议费用申请记录
        meetingPlanExeStandards.forEach(record -> {
            PmConferenceApplyFeeSaveVO saveVO = new PmConferenceApplyFeeSaveVO();
            saveVO.setPmProjectId(record.getPmProjectId());
            saveVO.setProjectName(record.getProjectName());
            saveVO.setPmProjectMeetingPlanningId(record.getPmProjectMeetingPlanningId());
            saveVO.setProjectMeetingPlanningName(record.getProjectMeetingPlanningName());
            saveVO.setMsBudgetSubjectId(record.getMsBudgetSubjectId());
            saveVO.setAmountMoney(record.getAmountMoney());
            saveVO.setFeeName(record.getFeeName());
            saveVO.setControlStandards(record.getControlStandards());
            list.add(saveVO);
        });
        return list;
    }

    /**
     * @author dz
     * @param id
     * @return 专家劳务List
     */
    public List<PmConferenceExpertServicesSaveVO> makeExpertServiceList(Long id){
        ArrayList<PmConferenceExpertServicesSaveVO> list = new ArrayList<>();
        List<PmExpertServiceStandard> expertServiceStandards = pmExpertServiceStandardService.getExpertServiceStandards(id);
        //未来可能需要判断是否为空
        if(expertServiceStandards.isEmpty()){
            return list;
        }
        expertServiceStandards.forEach( record -> {
            Integer num = Math.toIntExact(record.getPersonNumber());
            for (int i=1;i<=num;i++){
                PmConferenceExpertServicesSaveVO saveVO = new PmConferenceExpertServicesSaveVO();
                saveVO.setPmProjectId(record.getPmProjectId());
                saveVO.setProjectName(record.getProjectName());
                saveVO.setPmProjectMeetingPlanningId(record.getPmProjectMeetingPlanningId());
                saveVO.setProjectMeetingPlanningName(record.getProjectMeetingPlanningName());
                saveVO.setMsBudgetSubjectId(record.getMsBudgetSubjectId());
                saveVO.setFeeName(record.getFeeName());
                saveVO.setControlStandards(record.getExecutiveStandard());
                saveVO.setServiceTax(record.getServiceTax());
                saveVO.setAmountMoney(record.getAmountMoney());
                list.add(saveVO);
            }
        });
        return list;
    }

    private final PmMeetingPlanAllocationManager pmMeetingPlanAllocationManager;

    private final PmProjectStakeholderManager pmProjectStakeholderManager;

    private final PmProjectMeetingPlanningManager pmProjectMeetingPlanningManager;


    private final PmMeetingPlanAllocationMapper pmMeetingPlanAllocationMapper;






    // 分配
    @Override
    public Object savemeeting(Allocation allocation) {

        //    得到项目会议规划的内容
        PmProjectMeetingPlanning p = pmProjectMeetingPlanningManager.getById(allocation.getPmProjectMeetingPlanningId());


        if (allocation.getNumber() < p.getRemainingUnallocatedNum()) {


            // 求预算总金额

         BigDecimal s= p.getTotalBudgetAmount().multiply(new BigDecimal(Integer.parseInt(p.getExecutionSessionsNumber().toString())));


            PmMeetingPlanAllocation pmMeetingPlanAllocation = PmMeetingPlanAllocation.builder().pmProjectMeetingPlanningId(p.getId())
                    .allocationName(p.getProjectName()).pmProjectId(p.getPmProjectId()).projectName(p.getProjectName())
                    .projectMeetingPlanningName(p.getProjectMeetingPlanningName()).meetingMode(p.getMeetingMode()).msLongzhuMeetingTypeId(p.getMsLongzhuMeetingTypeId())
                    .meetingTypeName(p.getMeetingType()).executionSessionsNumber(p.getExecutionSessionsNumber())
                    .totalMeetingBudget(p.getTotalBudgetAmount()).province(p.getProvince()).cityCode(p.getCityCode()).provinceCode(p.getProvinceCode())
                    .meetingCity(p.getMeetingCity()).totalBudgetAmount(s).chargePersonId(allocation.getDefUserId()).chargePersonName(allocation.getPrincipalName())
                    .phone(allocation.getPrincipalPhone()).minimumParticipantsNumber(p.getMinimumParticipantsNumber()).maximumParticipantsNumber(p.getMaximumParticipantsNumber())
                    .illustrate(allocation.getRequire()).attachment(p.getAttachment()).meetingDetailAddress(allocation.getAddress())
                    .build();

           superManager.save(pmMeetingPlanAllocation);

            System.out.println(p.getAssignedQuantity());
            // 修改项目会议规划的分配数量
            int q = p.getAssignedQuantity() + allocation.getNumber();

            System.out.println(q);
            int o = p.getRemainingUnallocatedNum() - allocation.getNumber();
            p.setAssignedQuantity(q);
            p.setRemainingUnallocatedNum(o);

            pmProjectMeetingPlanningManager.updateById(p);
        } else {
            return "执行数量过多，导致不可继续分配";
        }
        return null;


    }
    /**
     * @author dz
     * 更新已申请场次，回填给会议规划和项目信息
     * @param r
     */
    public void addMeetingOpenedTimes(PmMeetingPlanAllocation r){
        Long pmProjectMeetingPlanningId = r.getPmProjectMeetingPlanningId();
        Long pmProjectId = r.getPmProjectId();
        PmProject project = pmProjectService.getById(pmProjectId);
        //防止空指针异常
        if (project.getAppliedNum()==null){
            project.setAppliedNum(0);
        }
        PmProjectUpdateVO pmProjectUpdateVO = BeanPlusUtil.toBean(project, PmProjectUpdateVO.class);

        project.setAppliedNum(project.getAppliedNum()+1);
        PmProjectMeetingPlanning planning = pmProjectMeetingPlanningService.getById(pmProjectMeetingPlanningId);
        planning.setOpenedTimes(planning.getOpenedTimes()+1);
        PmProjectMeetingPlanningUpdateVO updateVO = BeanPlusUtil.toBean(planning, PmProjectMeetingPlanningUpdateVO.class);
        try {
            pmProjectMeetingPlanningService.update(updateVO);
            pmProjectService.update(pmProjectUpdateVO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @author dz
     * 生成会议编号，由年月日和从001开始的编号组成
     * @return string类型的会议编号 例：20220101-001
     */
    public String getMeetingNo(int size){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String baseCode = format.format(new Date());
        DecimalFormat decimalFormat = new DecimalFormat("-000");
        String noCode = decimalFormat.format(size+1);
        return baseCode+noCode;
    }

}
