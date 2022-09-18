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
import top.tangyh.lamp.learnpm.entity.MsHospitalInfo;
import top.tangyh.lamp.learnpm.manager.MsHospitalInfoManager;
import top.tangyh.lamp.learnpm.service.MsHospitalInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsHospitalInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsHospitalInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalInfoUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.entity.MsHospitalDepartment;
import top.tangyh.lamp.learnpm.manager.MsHospitalDepartmentManager;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalDepartmentSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalDepartmentUpdateVO;
/**
 * <p>
 * 医院信息业务实现类
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MsHospitalInfoServiceImpl extends SuperServiceImpl<MsHospitalInfoManager, Long, MsHospitalInfo, MsHospitalInfoSaveVO, MsHospitalInfoUpdateVO, MsHospitalInfoPageQuery, MsHospitalInfoResultVO>
        implements MsHospitalInfoService {
private final MsHospitalDepartmentManager hospitalDepartmentManager;

 @Override
    @Transactional(rollbackFor = Exception.class)
    public boolean removeByIds(Collection<Long> ids) {
        if (CollUtil.isEmpty(ids)) {
            return false;
        }

        // 循环删除 从表
        //删除医院科室
        hospitalDepartmentManager.remove(Wraps.<MsHospitalDepartment>lbQ().in(MsHospitalDepartment::getMsHospitalInfoId, ids));

        return super.removeByIds(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsHospitalInfo save(MsHospitalInfoSaveVO saveVO) {
        MsHospitalInfo entity = BeanPlusUtil.toBean(saveVO,  MsHospitalInfo.class);
        superManager.save(entity);
		//循环保存子表
        //保存医院科室
        saveMsHospitalDepartmentMsHospitalInfoIdItem(saveVO.getMsHospitalDepartmentMsHospitalInfoIdInsertList(), entity);
        return entity;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsHospitalInfo updateById(MsHospitalInfoUpdateVO updateVO) {
        MsHospitalInfo old = getById(updateVO.getId());

        MsHospitalInfo entity = BeanPlusUtil.toBean(updateVO, MsHospitalInfo.class);
        superManager.updateById(entity);
		//循环保存和更新子表
        //保存医院科室
        saveMsHospitalDepartmentMsHospitalInfoIdItem(updateVO.getMsHospitalDepartmentMsHospitalInfoIdInsertList(), entity);
		//更新医院科室
		updateMsHospitalDepartmentMsHospitalInfoIdItem(updateVO.getMsHospitalDepartmentMsHospitalInfoIdUpdateList(), entity,old);
		//删除医院科室
		removeMsHospitalDepartmentMsHospitalInfoIdSubByIds(updateVO.getMsHospitalDepartmentMsHospitalInfoIdDeleteList()); 
	      

        return entity;
    }
    //保存医院科室
    private void saveMsHospitalDepartmentMsHospitalInfoIdItem(List<MsHospitalDepartmentSaveVO> insertList, MsHospitalInfo entity) {
	  if (CollUtil.isEmpty(insertList)) {
            return;
        }

        List<MsHospitalDepartment> itemList = new ArrayList<>();
        insertList.forEach(insert -> {
            MsHospitalDepartment item = new MsHospitalDepartment();
            BeanPlusUtil.copyProperties(insert, item);
            item.setMsHospitalInfoId(entity.getId());
            itemList.add(item);
        });
        hospitalDepartmentManager.saveBatch(itemList);
	 }
    //更新医院科室
    private void updateMsHospitalDepartmentMsHospitalInfoIdItem(List<MsHospitalDepartmentUpdateVO> updateInsert, MsHospitalInfo entity, MsHospitalInfo old) {
        if (CollUtil.isEmpty(updateInsert)) {
            return;
        }
        List<MsHospitalDepartment> itemList = new ArrayList<>();
        updateInsert.forEach(insert -> {
            MsHospitalDepartment item = new MsHospitalDepartment();
            BeanPlusUtil.copyProperties(insert, item);
            item.setMsHospitalInfoId(entity.getId());
            itemList.add(item);
        });
        hospitalDepartmentManager.updateBatchById(itemList);
    }		
    //删除医院科室
    private boolean removeMsHospitalDepartmentMsHospitalInfoIdSubByIds(Collection<Long> idList) {
        if (CollUtil.isEmpty(idList)) {
            return false;
        }
        return hospitalDepartmentManager.removeByIds(idList);
    }		
   

    @Override
    @Transactional(rollbackFor = Exception.class)
    public MsHospitalInfo copy(Long id) {
        MsHospitalInfo old = getById(id);
        ArgumentAssert.notNull(old, "数据不存在��已被删除，请刷新重试");

        MsHospitalInfo entity = BeanPlusUtil.toBean(old, MsHospitalInfo.class);
        entity.setId(null);
        superManager.save(entity);
		//循环复制子��
		LbQueryWrap<MsHospitalDepartment> msHospitalDepartmentMsHospitalInfoIdwrap = Wraps.<MsHospitalDepartment>lbQ().eq(MsHospitalDepartment::getMsHospitalInfoId,old.getId());
        List<MsHospitalDepartment> itemList0 = hospitalDepartmentManager.list(msHospitalDepartmentMsHospitalInfoIdwrap);
        itemList0.forEach(item -> {
            item.setId(null);
            item.setMsHospitalInfoId(entity.getId());
        });
        hospitalDepartmentManager.saveBatch(itemList0);
	
      
        return entity;
    }    
}
