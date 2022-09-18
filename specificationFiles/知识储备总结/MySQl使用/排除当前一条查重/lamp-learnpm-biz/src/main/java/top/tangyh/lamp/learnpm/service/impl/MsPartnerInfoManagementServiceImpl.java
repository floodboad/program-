package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import cn.hutool.core.collection.CollUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.basic.database.mybatis.conditions.query.LbQueryWrap;
import top.tangyh.basic.utils.ArgumentAssert;
import top.tangyh.basic.utils.BeanPlusUtil;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.MsPartnerInfoManagement;
import top.tangyh.lamp.learnpm.manager.MsPartnerInfoManagementManager;
import top.tangyh.lamp.learnpm.service.MsPartnerInfoManagementService;
import top.tangyh.lamp.learnpm.vo.query.MsPartnerInfoManagementPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsPartnerInfoManagementResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsPartnerInfoManagementSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsPartnerInfoManagementUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.MsContactInfo;
import top.tangyh.lamp.learnpm.manager.MsContactInfoManager;
import top.tangyh.lamp.learnpm.vo.save.MsContactInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsContactInfoUpdateVO;
/**
 * <p>
 * 合作方信息管理业务实现类
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
public class MsPartnerInfoManagementServiceImpl extends SuperServiceImpl<MsPartnerInfoManagementManager, Long, MsPartnerInfoManagement, MsPartnerInfoManagementSaveVO, MsPartnerInfoManagementUpdateVO, MsPartnerInfoManagementPageQuery, MsPartnerInfoManagementResultVO>
        implements MsPartnerInfoManagementService {
private final MsContactInfoManager contactInfoManager;

 @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除联系人信息
        contactInfoManager.remove(Wraps.<MsContactInfo>lbQ().in(MsContactInfo::getMsPartnerInfoManagementId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsPartnerInfoManagement save(MsPartnerInfoManagementSaveVO saveVO) {
        MsPartnerInfoManagement entity = BeanPlusUtil.toBean(saveVO,  MsPartnerInfoManagement.class);
        superManager.save(entity);
		//循环保存子表
        //保存联系人信息
        saveMsPartnerInfoManagementIdItem(saveVO.getMsPartnerInfoManagementIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsPartnerInfoManagement updateById(MsPartnerInfoManagementUpdateVO updateVO) {
        MsPartnerInfoManagement old = getById(updateVO.getId());

        MsPartnerInfoManagement entity = BeanPlusUtil.toBean(updateVO, MsPartnerInfoManagement.class);
        superManager.updateById(entity);
		//循环保存和更新子表
        //保存联系人信息
        saveMsPartnerInfoManagementIdItem(updateVO.getMsPartnerInfoManagementIdInsertList(), entity);
		//更新联系人信息
		updateMsPartnerInfoManagementIdItem(updateVO.getMsPartnerInfoManagementIdUpdateList(), entity,old);
		//删除联系人信息
		removeMsPartnerInfoManagementIdSubByIds(updateVO.getMsPartnerInfoManagementIdDeleteList()); 
	      

        return entity;
    }
    //保存联系人信息
    private void saveMsPartnerInfoManagementIdItem(List<MsContactInfoSaveVO> insertList, MsPartnerInfoManagement entity) {
	  if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<MsContactInfo> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            MsContactInfo item = new MsContactInfo();
            BeanPlusUtil.copyProperties(insert, item);
            item.setMsPartnerInfoManagementId(entity.getId());
            itemList.add(item);
        });
        contactInfoManager.saveBatch(itemList);
	 }
    //更新联系人信息
    private void updateMsPartnerInfoManagementIdItem(List<MsContactInfoUpdateVO> updateInsert, MsPartnerInfoManagement entity, MsPartnerInfoManagement old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<MsContactInfo> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            MsContactInfo item = new MsContactInfo();
            BeanPlusUtil.copyProperties(insert, item);
            item.setMsPartnerInfoManagementId(entity.getId());
            itemList.add(item);
        });
        contactInfoManager.updateBatchById(itemList);
    }		
    //删除联系人信息
    private boolean removeMsPartnerInfoManagementIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return contactInfoManager.removeByIds(idList);
    }		
   

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsPartnerInfoManagement copy(Long id) {
        MsPartnerInfoManagement old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在或已被删除，请刷新重试");

        MsPartnerInfoManagement entity = BeanPlusUtil.toBean(old, MsPartnerInfoManagement.class);
        entity.setId(null);
        superManager.save(entity);
		//循环复制子表
		LbQueryWrap<MsContactInfo> msPartnerInfoManagementIdwrap = Wraps.<MsContactInfo>lbQ().eq(MsContactInfo::getMsPartnerInfoManagementId,old.getId());
        List<MsContactInfo> itemList0 = contactInfoManager.list(msPartnerInfoManagementIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setMsPartnerInfoManagementId(entity.getId());
        });
        contactInfoManager.saveBatch(itemList0);
	
      
        return entity;
    }    
}
