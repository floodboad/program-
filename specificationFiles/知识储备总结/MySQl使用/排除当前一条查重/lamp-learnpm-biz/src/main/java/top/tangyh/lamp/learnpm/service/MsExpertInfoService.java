package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExpertInfo;
import top.tangyh.lamp.learnpm.vo.query.MsExpertInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExpertInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExpertInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExpertInfoUpdateVO;
import top.tangyh.lamp.learnpm.wechat.WO;

import java.util.ArrayList;
import java.util.Map;

/**
 * <p>
 * 专家信息业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
public interface MsExpertInfoService extends SuperService<Long, MsExpertInfo, MsExpertInfoSaveVO, MsExpertInfoUpdateVO, MsExpertInfoPageQuery, MsExpertInfoResultVO> {

    // 获取医院信息和科室信息
    Map<String, ArrayList<String>>  queryHospitalDeptInfo();
    // judgeExpertExit   true:空,false:存在
    boolean judgeExpertExit(String name,String tel);

    // msExpertInfo加入专家信息的同时，专家劳务表更新一条记录,这条记录关联专家信息，项目信息
    //void  insertExpertRelationInfo(MsExpertInfo expertInfo,long expertServicesId);

}
