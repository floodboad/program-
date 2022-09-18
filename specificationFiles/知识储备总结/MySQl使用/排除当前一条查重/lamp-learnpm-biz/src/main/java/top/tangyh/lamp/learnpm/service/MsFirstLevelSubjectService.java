package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsFirstLevelSubject;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsFirstLevelSubject;
import top.tangyh.lamp.learnpm.vo.query.MsFirstLevelSubjectPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsFirstLevelSubjectResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsFirstLevelSubjectSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsFirstLevelSubjectUpdateVO;
/**
 * <p>
 * 一级科目维护业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-16
 */
public interface MsFirstLevelSubjectService extends SuperService<Long, MsFirstLevelSubject, MsFirstLevelSubjectSaveVO, MsFirstLevelSubjectUpdateVO, MsFirstLevelSubjectPageQuery, MsFirstLevelSubjectResultVO> {

}
