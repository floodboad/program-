package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsPjComplianceFileDef;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsPjComplianceFileDef;
import top.tangyh.lamp.learnpm.vo.query.MsPjComplianceFileDefPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsPjComplianceFileDefResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsPjComplianceFileDefSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsPjComplianceFileDefUpdateVO;
/**
 * <p>
 * 项目合规文件定义业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-07-06
 */
public interface MsPjComplianceFileDefService extends SuperService<Long, MsPjComplianceFileDef, MsPjComplianceFileDefSaveVO, MsPjComplianceFileDefUpdateVO, MsPjComplianceFileDefPageQuery, MsPjComplianceFileDefResultVO> {

}
