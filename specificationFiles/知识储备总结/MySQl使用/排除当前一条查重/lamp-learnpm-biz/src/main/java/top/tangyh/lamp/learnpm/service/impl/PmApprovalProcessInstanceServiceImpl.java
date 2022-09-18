package top.tangyh.lamp.learnpm.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;

import java.util.*;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseInstance;
import top.tangyh.lamp.learnpm.manager.PmApprovalProcessInstanceManager;
import top.tangyh.lamp.learnpm.service.PmApprovalProcessInstanceService;
import top.tangyh.lamp.learnpm.vo.query.PmApprovalProcessInstancePageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmApprovalProcessInstanceResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessInstanceUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseInstanceManager;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseInstanceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseInstanceUpdateVO;
/**
 * <p>
 * 审批流实例业务实现类
 * 
 * </p>
 *
 * @author 龙色波
 * @date 2022-06-21
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmApprovalProcessInstanceServiceImpl extends SuperServiceImpl<PmApprovalProcessInstanceManager, Long, PmApprovalProcessInstance, PmApprovalProcessInstanceSaveVO, PmApprovalProcessInstanceUpdateVO, PmApprovalProcessInstancePageQuery, PmApprovalProcessInstanceResultVO>
        implements PmApprovalProcessInstanceService {
private final PmProcessPhaseInstanceManager processPhaseInstanceManager;

    @Autowired
    private PmApprovalProcessInstanceManager pmApprovalProcessInstanceManager;

    @Autowired
    private PmProcessPhaseInstanceManager pmProcessPhaseInstanceManager;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除流程环节实例
        processPhaseInstanceManager.remove(Wraps.<PmProcessPhaseInstance>lbQ().in(PmProcessPhaseInstance::getPmApprovalProcessInstanceId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmApprovalProcessInstance save(PmApprovalProcessInstanceSaveVO saveVO) {
        PmApprovalProcessInstance entity = BeanPlusUtil.toBean(saveVO,  PmApprovalProcessInstance.class);
        superManager.save(entity);
		//循环保存子表
        //保存流程环节实例
        savePmProcessPhaseInstancePmApprovalProcessInstanceIdItem(saveVO.getPmProcessPhaseInstancePmApprovalProcessInstanceIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmApprovalProcessInstance updateById(PmApprovalProcessInstanceUpdateVO updateVO) {
        PmApprovalProcessInstance old = getById(updateVO.getId());

        PmApprovalProcessInstance entity = BeanPlusUtil.toBean(updateVO, PmApprovalProcessInstance.class);
        superManager.updateById(entity);
		//循环保存和更新子表
        //保存流程环节实例
        savePmProcessPhaseInstancePmApprovalProcessInstanceIdItem(updateVO.getPmProcessPhaseInstancePmApprovalProcessInstanceIdInsertList(), entity);
		//更新流程环节实例
		updatePmProcessPhaseInstancePmApprovalProcessInstanceIdItem(updateVO.getPmProcessPhaseInstancePmApprovalProcessInstanceIdUpdateList(), entity,old);
		//删除流程环节实例
		removePmProcessPhaseInstancePmApprovalProcessInstanceIdSubByIds(updateVO.getPmProcessPhaseInstancePmApprovalProcessInstanceIdDeleteList()); 
	      

        return entity;
    }
    //保存流程环节实例
    private void savePmProcessPhaseInstancePmApprovalProcessInstanceIdItem(List<PmProcessPhaseInstanceSaveVO> insertList, PmApprovalProcessInstance entity) {
	  if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<PmProcessPhaseInstance> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmProcessPhaseInstance item = new PmProcessPhaseInstance();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmApprovalProcessInstanceId(entity.getId());
            itemList.add(item);
        });
        processPhaseInstanceManager.saveBatch(itemList);
	 }
    //更新流程环节实例
    private void updatePmProcessPhaseInstancePmApprovalProcessInstanceIdItem(List<PmProcessPhaseInstanceUpdateVO> updateInsert, PmApprovalProcessInstance entity, PmApprovalProcessInstance old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmProcessPhaseInstance> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmProcessPhaseInstance item = new PmProcessPhaseInstance();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmApprovalProcessInstanceId(entity.getId());
            itemList.add(item);
        });
        processPhaseInstanceManager.updateBatchById(itemList);
    }		
    //删除流程环节实例
    private boolean removePmProcessPhaseInstancePmApprovalProcessInstanceIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return processPhaseInstanceManager.removeByIds(idList);
    }		
   

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmApprovalProcessInstance copy(Long id) {
        PmApprovalProcessInstance old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        PmApprovalProcessInstance entity = BeanPlusUtil.toBean(old, PmApprovalProcessInstance.class);
        entity.setId(null);
        superManager.save(entity);
		//循环复制子��
		LbQueryWrap<PmProcessPhaseInstance> pmProcessPhaseInstancePmApprovalProcessInstanceIdwrap = Wraps.<PmProcessPhaseInstance>lbQ().eq(PmProcessPhaseInstance::getPmApprovalProcessInstanceId,old.getId());
        List<PmProcessPhaseInstance> itemList0 = processPhaseInstanceManager.list(pmProcessPhaseInstancePmApprovalProcessInstanceIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setPmApprovalProcessInstanceId(entity.getId());
        });
        processPhaseInstanceManager.saveBatch(itemList0);
	
      
        return entity;
    }

    @Override
    public List<PmApprovalProcessInstance> backlogDataVolumeList(String userId) {
        List<PmApprovalProcessInstance> list = pmApprovalProcessInstanceManager.listBacklogDataVolumeByXML(userId);
        return list;
    }

    @Override
    public List<String> jsonToDoList(String userId,Integer flagApplyNum) {

        // 调用backlogDataVolumeList获取所有的审批流实例待办记录
        List<PmApprovalProcessInstance> sourList = backlogDataVolumeList(userId);
        List<String> jsonList = new ArrayList<>(sourList.size());
        // 遍历sourList添加属性并将记录添加到jsonList
        for (int i=0;i<sourList.size()-1;++i){
            // 获取一个审批流程实例的id，有多个pmProcessPhaseInstance，用次序筛选
            String Title = sourList.get(i).getAttribute1();
            Long ProcessConfigId = sourList.get(i).getPmApprovalProcessConfigId();
            // 通过查这个ProcessConfigId这一条记录，获取申请人的名字和申请时间
            String name = pmProcessPhaseInstanceManager.getProcessConfigInstanceById(ProcessConfigId,flagApplyNum).getApproverName();
            if (name == null) {
                name = "";
            }
            String time = pmProcessPhaseInstanceManager.getProcessConfigInstanceById(ProcessConfigId,flagApplyNum).getCreatedTime().toString();
            if (time == null) {
                time = "";
            }
            // 这个位置可以debug具体在哪个位置使null属性提前处理
            // 获取到返回json格式的单个对象
            HashMap<String,Object> data = new HashMap<>();
            data.put("PROCESS_NAME",sourList.get(i).getProcessName());
            data.put("BUSINESS_TYPE",sourList.get(i).getBusinessType());
            data.put("APPROVER_NAME",name);
            data.put("CreatedTime",time);
            data.put("Title",Title);
            System.out.println("========================="+sourList.get(i).getAttribute1());
            String jsonObject = JSONObject.toJSONString(data);
            jsonList.add(jsonObject);
        }
        return jsonList;
    }
}
