package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmWebcast;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmWebcast;
import top.tangyh.lamp.learnpm.vo.query.PmWebcastPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmWebcastResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmWebcastSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmWebcastUpdateVO;
/**
 * <p>
 * 网上直播业务接口
 * 
 * </p>
 *
 * @author liyy
 * @date 2022-06-14
 */
public interface PmWebcastService extends SuperService<Long, PmWebcast, PmWebcastSaveVO, PmWebcastUpdateVO, PmWebcastPageQuery, PmWebcastResultVO> {

}
