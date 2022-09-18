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
import top.tangyh.basic.base.R;
import top.tangyh.lamp.common.constant.DsConstant;
import top.tangyh.lamp.learnpm.constant.DSConstant;
import top.tangyh.lamp.learnpm.wechatsevice.NoticeService;
import top.tangyh.lamp.msg.entity.Msg;
import top.tangyh.lamp.msg.manager.MsgManager;
import top.tangyh.lamp.msg.manager.MsgReceiveManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


/**
 * @author: xucl
 * @create: 2022/6/21
 * @Description:
 * @FileName: NoticeServiceImpl
 * @History:
 * @自定义内容：
 */
@Slf4j
@Service
@DS(DsConstant.LEARN_BASE)
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NoticeServiceImpl implements NoticeService {

    //@Autowired
    //private MsgManager msgManager;
    //
    //@Autowired
    //private MsgReceiveManager msgReceiveManager;
    //
    //@Override
    //@Transactional(rollbackFor = Exception.class)
    //public ArrayList<Msg> listNotifyAndPublictyMessage(Long id) {
    //    // 先通过MsgReceive表查出所有userId的记录,然后再通过MsgType过滤公告与通知返回List
    //    ArrayList<Msg> list = msgManager.listNoticeById(id);
    //    return list;
    //}
    //
    //@Override
    //@Transactional(rollbackFor = Exception.class)
    //public ArrayList<String> noticeDetailes(ArrayList<Msg> list, String title, Date date,Long userId) {
    //    // 通过通知公告列表的记录去筛选指定的title，date的记录返回
    //    ArrayList<String> destList = new ArrayList<>();
    //    ArrayList<Msg> sourceList = msgManager.listNoticeById(userId);
    //    if (!(title.length()== 0)) {
    //        for (Msg msg : sourceList) {
    //            if (title.equals(msg.getTitle())) {
    //                destList.add(title);
    //                destList.add(date.toString());
    //            }
    //        }
    //    }
    //    return destList;
    //}
    //
    //@Override
    //@Transactional(rollbackFor = Exception.class)
    //public Integer unreadAmount( boolean isRead,Long id) {
    //    // 数据库中查出所有MsType的类型当前用户记录
    //    ArrayList<Msg> list = msgManager.listAllTypeNoticeById(isRead,id);
    //    if (CollectionUtils.isEmpty(list)){
    //        R.fail("符合要求数据为零");
    //    }
    //    return list.size();
    //}
    //
    //@Override
    //@Transactional(rollbackFor = Exception.class)
    //public Integer readAmount( boolean isRead,Long id) {
    //    // 数据库中查出所有MsType的类型当前用户记录
    //    ArrayList<Msg> list = msgManager.listAllTypeNoticeById(isRead,id);
    //    if (CollectionUtils.isEmpty(list)){
    //        R.fail("符合要求数据为零");
    //    }
    //    return list.size();
    //}
}