package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExecutionSessionType;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsExecutionSessionType;
import top.tangyh.lamp.learnpm.vo.query.MsExecutionSessionTypePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsExecutionSessionTypeResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsExecutionSessionTypeSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsExecutionSessionTypeUpdateVO;
/**
 * <p>
 * 执行场次类型业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-08
 */
public interface MsExecutionSessionTypeService extends SuperService<Long, MsExecutionSessionType, MsExecutionSessionTypeSaveVO, MsExecutionSessionTypeUpdateVO, MsExecutionSessionTypePageQuery, MsExecutionSessionTypeResultVO> {

}
