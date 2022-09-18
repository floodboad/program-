package top.tangyh.lamp.learnpm.service;

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;
import top.tangyh.lamp.learnpm.vo.query.PmMeetingMaterialsRegPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmMeetingMaterialsRegResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmMeetingMaterialsRegSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmMeetingMaterialsRegUpdateVO;
/**
 * <p>
 * 会议合规材料登记业务接口
 * 
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
public interface PmMeetingMaterialsRegService extends SuperService<Long, PmMeetingMaterialsReg, PmMeetingMaterialsRegSaveVO, PmMeetingMaterialsRegUpdateVO, PmMeetingMaterialsRegPageQuery, PmMeetingMaterialsRegResultVO> {

}
