package top.tangyh.lamp.learnpm.wechatsevice.impl;/**
 * @author xuchunlong
 * @create 2022-06-21-13:09
 */

import com.baomidou.dynamic.datasource.annotation.DS;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import top.tangyh.basic.database.mybatis.conditions.query.QueryWrap;
import top.tangyh.lamp.base.entity.user.BaseEmployee;
import top.tangyh.lamp.base.manager.user.BaseEmployeeManager;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wechatsevice.MessageAmountService;
import top.tangyh.lamp.msg.entity.MsgReceive;
import top.tangyh.lamp.msg.manager.MsgReceiveManager;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.manager.tenant.DefUserManager;

import java.util.List;

/**
 * @author: gfk
 * @create: 2022/6/21
 * @Description:
 * @FileName: MessageAmountServiceImpl
 * @History:
 * @自定义内容：
 */
@Slf4j
@Service
@DS(DsConstant.LEARN_BASE)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MessageAmountServiceImpl implements MessageAmountService {

    //@Autowired
    //private final MsgReceiveManager msgReceiveManager;
    //
    //@Override
    //@Transactional(rollbackFor = Exception.class)
    //public int getAmountByUserId(Long userId) {
    //    QueryWrap<MsgReceive> queryWrap = new QueryWrap<>();
    //    queryWrap.eq("user_id",userId);
    //    List<MsgReceive> list = msgReceiveManager.list(queryWrap);
    //    if (CollectionUtils.isEmpty(list)) {
    //        // 可以增加手机号辅助筛选
    //        return 0;
    //    }
    //    return list.size();
    //}
}