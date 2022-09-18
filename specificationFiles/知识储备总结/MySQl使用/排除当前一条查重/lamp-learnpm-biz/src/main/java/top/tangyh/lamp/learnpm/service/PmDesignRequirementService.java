package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmDesignRequirement;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmDesignRequirement;
import top.tangyh.lamp.learnpm.vo.query.PmDesignRequirementPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmDesignRequirementResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmDesignRequirementSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmDesignRequirementUpdateVO;
/**
 * <p>
 * 设计要求业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-14
 */
public interface PmDesignRequirementService extends SuperService<Long, PmDesignRequirement, PmDesignRequirementSaveVO, PmDesignRequirementUpdateVO, PmDesignRequirementPageQuery, PmDesignRequirementResultVO> {

}
