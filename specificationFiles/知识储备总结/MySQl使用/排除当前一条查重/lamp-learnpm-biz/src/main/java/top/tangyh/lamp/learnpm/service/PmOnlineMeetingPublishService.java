package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOnlineMeetingPublish;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmOnlineMeetingPublish;
import top.tangyh.lamp.learnpm.vo.query.PmOnlineMeetingPublishPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmOnlineMeetingPublishResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmOnlineMeetingPublishSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmOnlineMeetingPublishUpdateVO;
/**
 * <p>
 * 线上会议发布业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
public interface PmOnlineMeetingPublishService extends SuperService<Long, PmOnlineMeetingPublish, PmOnlineMeetingPublishSaveVO, PmOnlineMeetingPublishUpdateVO, PmOnlineMeetingPublishPageQuery, PmOnlineMeetingPublishResultVO> {

}
