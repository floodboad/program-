package top.tangyh.lamp.learnpm.wechatsevice;/**
 * @author xuchunlong
 * @create 2022-06-21-13:08
 */

import top.tangyh.basic.base.service.SuperService;
import top.tangyh.lamp.msg.entity.Msg;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


/**
 * @author: gfk
 * @create: 2022/6/21
 * @Description:
 * @FileName: NoticeService
 * @History:
 * @自定义内容：
 */

public interface NoticeService {

    //// 通过用户的当前id去查询所有MsType为"NOTIFY:通知;PUBLICITY:公告" 的msg记录
    //ArrayList<Msg> listNotifyAndPublictyMessage(Long id);
    //
    //// 在通知公告的列表中选出一个具体的公告详情
    //ArrayList<String> noticeDetailes(ArrayList<Msg> list, String title, Date date, Long userId);
    //
    //// 查询未读消息数量，数据库中查出所有MsType的类型当前用户记录
    //Integer unreadAmount(boolean isRead,Long id);
    //
    //// 查询已读消息数量，数据库中查出所有MsType的类型当前用户记录
    //Integer readAmount(boolean isRead, Long id);
}
