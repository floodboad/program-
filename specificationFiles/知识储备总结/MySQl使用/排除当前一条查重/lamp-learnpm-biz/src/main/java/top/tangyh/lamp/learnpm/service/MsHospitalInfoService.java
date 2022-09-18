package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsHospitalInfo;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.MsHospitalInfo;
import top.tangyh.lamp.learnpm.vo.query.MsHospitalInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsHospitalInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsHospitalInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsHospitalInfoUpdateVO;
/**
 * <p>
 * 医院信息业务接口
 * 
 * </p>
 *
 * @author zyq
 * @date 2022-06-14
 */
public interface MsHospitalInfoService extends SuperService<Long, MsHospitalInfo, MsHospitalInfoSaveVO, MsHospitalInfoUpdateVO, MsHospitalInfoPageQuery, MsHospitalInfoResultVO> {

}
