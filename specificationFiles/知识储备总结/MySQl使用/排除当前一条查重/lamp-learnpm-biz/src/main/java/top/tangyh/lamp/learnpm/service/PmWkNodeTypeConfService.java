package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmWkNodeTypeConf;
import top.tangyh.lamp.learnpm.vo.query.PmWkNodeTypeConfPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmWkNodeTypeConfResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmWkNodeTypeConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmWkNodeTypeConfUpdateVO;
/**
 * <p>
 * 工作流节点类型配置业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
public interface PmWkNodeTypeConfService extends SuperService<Long, PmWkNodeTypeConf, PmWkNodeTypeConfSaveVO, PmWkNodeTypeConfUpdateVO, PmWkNodeTypeConfPageQuery, PmWkNodeTypeConfResultVO> {

}
