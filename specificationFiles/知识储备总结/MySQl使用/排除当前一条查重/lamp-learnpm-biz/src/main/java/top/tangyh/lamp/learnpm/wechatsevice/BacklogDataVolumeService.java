package top.tangyh.lamp.learnpm.wechatsevice;/**
 * @author xuchunlong
 * @create 2022-06-21-13:08
 */

import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xucl
 * @create: 2022/6/21
 * @Description:
 * @FileName: BacklogDataVolumeService
 * @History:
 * @自定义内容：
 */
public interface BacklogDataVolumeService {

    // 获取待办列表
    List<PmApprovalProcessInstance> listBacklogDataVolume(String userId);

    // 获取待办列表(使用xml）
    List<PmApprovalProcessInstance> listBacklogDataVolumeByXML(String userId);

    // 获取待办分页列表(使用xml）
    List<PmApprovalProcessInstance> listBacklogDataVolumePageByXML(String userId,Long current,Long size);
}
