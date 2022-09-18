package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsBudgetSubject;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.manager.PmApprovalProcessConfigManager;
import top.tangyh.lamp.learnpm.service.PmApprovalProcessConfigService;
import top.tangyh.lamp.learnpm.service.PmProcessPhaseConfService;
import top.tangyh.lamp.learnpm.service.PmWkNodeTypeConfService;
import top.tangyh.lamp.learnpm.vo.query.PmApprovalProcessConfigPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmApprovalProcessConfigResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmApprovalProcessConfigSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmApprovalProcessConfigUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseConfManager;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseConfUpdateVO;
/**
 * <p>
 * 审批流配置业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmApprovalProcessConfigServiceImpl extends SuperServiceImpl<PmApprovalProcessConfigManager, Long, PmApprovalProcessConfig, PmApprovalProcessConfigSaveVO, PmApprovalProcessConfigUpdateVO, PmApprovalProcessConfigPageQuery, PmApprovalProcessConfigResultVO>
        implements PmApprovalProcessConfigService {
private final PmProcessPhaseConfManager processPhaseConfManager;

    @Autowired
    private PmApprovalProcessConfigManager processConfigManager;

    @Autowired
    private PmProcessPhaseConfService pmProcessPhaseConfService;


    @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除流程环节配置
        processPhaseConfManager.remove(Wraps.<PmProcessPhaseConf>lbQ().in(PmProcessPhaseConf::getPmApprovalProcessConfigId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmApprovalProcessConfig save(PmApprovalProcessConfigSaveVO saveVO){
        PmApprovalProcessConfig entity = BeanPlusUtil.toBean(saveVO,  PmApprovalProcessConfig.class);
        superManager.save(entity);
		//循环保存子表
        //保存流程环节配置
        savePmProcessPhaseConfPmApprovalProcessConfigIdItem(saveVO.getPmProcessPhaseConfPmApprovalProcessConfigIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmApprovalProcessConfig updateById(PmApprovalProcessConfigUpdateVO updateVO){
        PmApprovalProcessConfig old = getById(updateVO.getId());

        PmApprovalProcessConfig entity = BeanPlusUtil.toBean(updateVO, PmApprovalProcessConfig.class);
        superManager.updateById(entity);
		//循环保存和更新子表
        //保存流程环节配置
        savePmProcessPhaseConfPmApprovalProcessConfigIdItem(updateVO.getPmProcessPhaseConfPmApprovalProcessConfigIdInsertList(), entity);
		//更新流程环节配置
		updatePmProcessPhaseConfPmApprovalProcessConfigIdItem(updateVO.getPmProcessPhaseConfPmApprovalProcessConfigIdUpdateList(), entity,old);
		//删除流程环节配置
		removePmProcessPhaseConfPmApprovalProcessConfigIdSubByIds(updateVO.getPmProcessPhaseConfPmApprovalProcessConfigIdDeleteList()); 
	      

        return entity;
    }
    //保存流程环节配置
    private void savePmProcessPhaseConfPmApprovalProcessConfigIdItem(List<PmProcessPhaseConfSaveVO> insertList, PmApprovalProcessConfig entity) {
	    if (CollUtil.isEmpty(insertList)) {
            return;
        }
        List<PmProcessPhaseConf> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            PmProcessPhaseConf item = new PmProcessPhaseConf();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmApprovalProcessConfigId(entity.getId());
            itemList.add(item);
        });
        processPhaseConfManager.saveBatch(itemList);
	 }
    //更新流程环节配置
    private void updatePmProcessPhaseConfPmApprovalProcessConfigIdItem(List<PmProcessPhaseConfUpdateVO> updateInsert, PmApprovalProcessConfig entity, PmApprovalProcessConfig old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<PmProcessPhaseConf> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            PmProcessPhaseConf item = new PmProcessPhaseConf();
            BeanPlusUtil.copyProperties(insert, item);
            item.setPmApprovalProcessConfigId(entity.getId());
            itemList.add(item);
        });
        processPhaseConfManager.updateBatchById(itemList);
    }		
    //删除流程环节配置
    private boolean removePmProcessPhaseConfPmApprovalProcessConfigIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return processPhaseConfManager.removeByIds(idList);
    }		
   

    @Override
    @Transactional(rollbackFor = Exception.class)
    public PmApprovalProcessConfig copy(Long id) {
        PmApprovalProcessConfig old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        PmApprovalProcessConfig entity = BeanPlusUtil.toBean(old, PmApprovalProcessConfig.class);
        entity.setId(null);
        superManager.save(entity);
		//循环复制子��
		LbQueryWrap<PmProcessPhaseConf> pmProcessPhaseConfPmApprovalProcessConfigIdwrap = Wraps.<PmProcessPhaseConf>lbQ().eq(PmProcessPhaseConf::getPmApprovalProcessConfigId,old.getId());
        List<PmProcessPhaseConf> itemList0 = processPhaseConfManager.list(pmProcessPhaseConfPmApprovalProcessConfigIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setPmApprovalProcessConfigId(entity.getId());
        });
        processPhaseConfManager.saveBatch(itemList0);
	
      
        return entity;
    }
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean processNameRepeatOrNot(PmApprovalProcessConfigSaveVO pmApprovalProcessConfigSaveVO) {

        String processName = pmApprovalProcessConfigSaveVO.getProcessName();
        ArrayList<String> list = processConfigManager.getAllProcessConfigName();
        if (list.isEmpty()){
            return false;
        }else if (list.contains(processName)){
            return true;
        }
        return false;
    }


    /**
     * 此方法需要研究
     *
    */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public Boolean processNameRepeatOrNot2(PmApprovalProcessConfigUpdateVO pmApprovalProcessConfigUpdateVO) {

        String processName = pmApprovalProcessConfigUpdateVO.getProcessName();
        Long processId = pmApprovalProcessConfigUpdateVO.getId();
        ArrayList<String> list = processConfigManager.getExcludeCurrentEntry(processName,processId);
        if (CollectionUtils.isEmpty(list)){
            return true;
        }
        return false;
    }

    @Override
    public String getFirstProcessPhaseConf(Integer linkSequence,String processName) {
        PmProcessPhaseConf processPhaseConf = processConfigManager.getFirstProcessPhaseConf(linkSequence,processName);
        String nodeTypeCode = processPhaseConf.getNodeTypeCode();
        String viewName = processConfigManager.getViewNameByNodeCode(nodeTypeCode);
        return viewName;
    }

}
