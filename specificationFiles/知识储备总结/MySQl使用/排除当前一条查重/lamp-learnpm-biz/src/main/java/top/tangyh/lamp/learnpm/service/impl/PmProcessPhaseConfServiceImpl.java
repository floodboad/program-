package top.tangyh.lamp.learnpm.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.entity.Entity;
import top.tangyh.basic.base.service.impl.SuperServiceImpl;
import top.tangyh.basic.context.ContextUtil;
import top.tangyh.basic.database.mybatis.conditions.Wraps;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessConfig;
import top.tangyh.lamp.learnpm.entity.PmProcessPhaseConf;
import top.tangyh.lamp.learnpm.manager.PmProcessPhaseConfManager;
import top.tangyh.lamp.learnpm.service.PmApprovalProcessConfigService;
import top.tangyh.lamp.learnpm.service.PmProcessPhaseConfService;
import top.tangyh.lamp.learnpm.vo.query.PmProcessPhaseConfPageQuery;
import top.tangyh.lamp.learnpm.vo.result.PmProcessPhaseConfResultVO;
import top.tangyh.lamp.learnpm.vo.save.PmProcessPhaseConfSaveVO;
import top.tangyh.lamp.learnpm.vo.update.PmProcessPhaseConfUpdateVO;
import top.tangyh.lamp.learnpm.constant.DSConstant;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 流程环节配置业务实现类
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-20
 */
@Slf4j
@Service
@DS(DSConstant.DS_LEARN_PW)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class PmProcessPhaseConfServiceImpl extends SuperServiceImpl<PmProcessPhaseConfManager, Long, PmProcessPhaseConf, PmProcessPhaseConfSaveVO, PmProcessPhaseConfUpdateVO, PmProcessPhaseConfPageQuery, PmProcessPhaseConfResultVO>
        implements PmProcessPhaseConfService {

    @Autowired
    private PmProcessPhaseConfManager pmProcessPhaseConfManager;

    @Override
    public Boolean controlLinkIdCheck(PmProcessPhaseConfSaveVO pmProcessPhaseConfSaveVO) {
        // 获取当前流程id和所要存入的环节次序
        Long ProcessId = pmProcessPhaseConfSaveVO.getApproverId();
        int linkSequence = pmProcessPhaseConfSaveVO.getLinkSequence();
        // 查询此当前流程下的id的环节次序
        ArrayList<Integer> list = pmProcessPhaseConfManager.selectLinkSequence(ProcessId);
        if (CollectionUtils.isEmpty(list)){
            // 存入数据库
            return true;
        }else if (list.contains(linkSequence)){
            // 显示重复不能存入
            return false;
        }
      return true;
    }



    @Override
    public Boolean isEndrequirements(PmProcessPhaseConfSaveVO pmProcessPhaseConfSaveVO) {
        // 目标：不为空，只有一个结束节点，内容是（0或1）
        Long processId = pmProcessPhaseConfSaveVO.getApproverId();
        String isEndContext;
        // 查询是否只有一个结束节点
        String endNode = pmProcessPhaseConfManager.selectEndNode(processId);
        isEndContext = pmProcessPhaseConfSaveVO.getIsEnd();
        if (endNode == null){
            // 可以添加,进行下一步验证，不为空,内容是（0或1）这两个是一起解决的
            if (isEndContext.isEmpty()){
                return false;
            }else {
                if (isEndContext.equals("0") || isEndContext.equals("1")){
                    return true;
                }
            }
        }else {
            return false;
        }
        return false;
    }
}
