package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsWorkExperience;
import top.tangyh.lamp.learnpm.vo.query.MsWorkExperiencePageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsWorkExperienceResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsWorkExperienceSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsWorkExperienceUpdateVO;
/**
 * <p>
 * 工作经历业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
public interface MsWorkExperienceService extends SuperService<Long, MsWorkExperience, MsWorkExperienceSaveVO, MsWorkExperienceUpdateVO, MsWorkExperiencePageQuery, MsWorkExperienceResultVO> {

}
