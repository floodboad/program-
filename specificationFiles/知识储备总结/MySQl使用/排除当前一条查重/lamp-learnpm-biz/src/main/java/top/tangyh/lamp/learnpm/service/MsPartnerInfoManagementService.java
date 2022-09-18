package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsPartnerInfoManagement;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsPartnerInfoManagement;
import top.tangyh.lamp.learnpm.vo.query.MsPartnerInfoManagementPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsPartnerInfoManagementResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsPartnerInfoManagementSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsPartnerInfoManagementUpdateVO;
/**
 * <p>
 * 合作方信息管理业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
public interface MsPartnerInfoManagementService extends SuperService<Long, MsPartnerInfoManagement, MsPartnerInfoManagementSaveVO, MsPartnerInfoManagementUpdateVO, MsPartnerInfoManagementPageQuery, MsPartnerInfoManagementResultVO> {

}
