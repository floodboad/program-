package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmMeetingMaterialsReg;

/**
 * <p>
 * 会议合规材料登记Mapper 接口
 * </p>
 *
 * @author dz
 * @date 2022-06-20
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmMeetingMaterialsRegMapper extends SuperMapper<PmMeetingMaterialsReg> {

}
