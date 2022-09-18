package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsQualification;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsQualification;
import top.tangyh.lamp.learnpm.vo.query.MsQualificationPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsQualificationResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsQualificationSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsQualificationUpdateVO;
/**
 * <p>
 * 资格证书业务接口
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-22
 */
public interface MsQualificationService extends SuperService<Long, MsQualification, MsQualificationSaveVO, MsQualificationUpdateVO, MsQualificationPageQuery, MsQualificationResultVO> {

}
