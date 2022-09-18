package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsDepartmentInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsDepartmentInfo;
import top.tangyh.lamp.learnpm.vo.query.MsDepartmentInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsDepartmentInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsDepartmentInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsDepartmentInfoUpdateVO;
/**
 * <p>
 * 科室信息业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-13
 */
public interface MsDepartmentInfoService extends SuperService<Long, MsDepartmentInfo, MsDepartmentInfoSaveVO, MsDepartmentInfoUpdateVO, MsDepartmentInfoPageQuery, MsDepartmentInfoResultVO> {

}
