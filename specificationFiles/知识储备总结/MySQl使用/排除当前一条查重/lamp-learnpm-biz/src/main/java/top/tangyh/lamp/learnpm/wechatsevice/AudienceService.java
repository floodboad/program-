package top.tangyh.lamp.learnpm.wechatsevice;/**
 * @author xuchunlong
 * @create 2022-06-30-12:46
 */

/**
 * @author: gfk
 * @create: 2022/6/30
 * @Description:
 * @FileName: AudienceService
 * @History:
 * @自定义内容：
 */
public interface AudienceService {

    // 同时把入参数据增加至用户库和听众信息库，若手机号重复则不增加。true为成功，false为失败。
    Boolean AudienceInformationEntry(String json);
}
