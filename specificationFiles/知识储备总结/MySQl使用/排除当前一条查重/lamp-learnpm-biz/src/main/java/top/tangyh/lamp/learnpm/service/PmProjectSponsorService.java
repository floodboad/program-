package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectSponsor;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmProjectSponsor;
import top.tangyh.lamp.learnpm.vo.query.PmProjectSponsorPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProjectSponsorResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProjectSponsorSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProjectSponsorUpdateVO;
/**
 * <p>
 * 项目赞助企业业务接口
 * 
 * </p>
 *
 * @author zhaoxl
 * @date 2022-06-28
 */
public interface PmProjectSponsorService extends SuperService<Long, PmProjectSponsor, PmProjectSponsorSaveVO, PmProjectSponsorUpdateVO, PmProjectSponsorPageQuery, PmProjectSponsorResultVO> {

}
