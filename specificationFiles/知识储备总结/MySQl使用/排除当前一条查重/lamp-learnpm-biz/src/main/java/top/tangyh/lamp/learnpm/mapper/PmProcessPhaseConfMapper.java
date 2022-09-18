package top.tangyh.lamp.learnpm.mapper;

import com.baomidou.mybatisplus.annotation.InterceptorIgnore;
import org.springframework.stereotype.Repository;
import top.tangyh.basic.base.mapper.SuperMapper;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;

import java.util.ArrayList;

/**
 * <p>
 * 流程环节配置Mapper 接口
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Repository
@InterceptorIgnore(tenantLine = "true", dynamicTableName = "true")
public interface PmProcessPhaseConfMapper extends SuperMapper<PmProcessPhaseConf> {

    // 获取指定的id的所有环节次序
    ArrayList<Integer> selectLinkSequence(long ProcessId);

    // 查询是否只有一个结束节点
    String  selectEndNode(long ProcessId);
}
