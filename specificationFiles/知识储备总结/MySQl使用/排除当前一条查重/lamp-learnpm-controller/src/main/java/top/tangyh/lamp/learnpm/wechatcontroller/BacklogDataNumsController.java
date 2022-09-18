package top.tangyh.lamp.learnpm.wechatcontroller;/**
 * @author xuchunlong
 * @create 2022-06-21-12:12
 */

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.lamp.learnpm.entity.PmApprovalProcessInstance;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechat.WPage;
import top.tangyh.lamp.learnpm.wechatsevice.BacklogDataVolumeService;
import top.tangyh.lamp.msg.entity.Msg;
import top.tangyh.lamp.msg.entity.MsgReceive;
import top.tangyh.lamp.system.entity.tenant.DefUser;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: xucl
 * @create: 2022/6/21
 * @Description: 待办数据量
 * @FileName: BacklogDataNumsController
 * @History:
 */

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/backlogdataVolume")
@Api(value = "backlogdataVolume", tags = "待办数据量")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class BacklogDataNumsController {

    @Autowired
    private final BacklogDataVolumeService backlogDataVolumeService;
    /**
     * 待办数据量
     * @param wPage
     * @param request
     * @return
     */
    @ApiOperation(value = "待办数据量", notes = "待办数据量")
    @PostMapping(value = "/backlogdataVolume")
    @RequestMapping(value = "backlogdataVolume",method = RequestMethod.POST, produces = "application/json")
    public R backlogdataVolume(@RequestBody WPage wPage,HttpServletRequest request){

        // 获取所需要的参数
        String userId = String.valueOf(wPage.getUserId(request));
        int amount = backlogDataVolumeService.listBacklogDataVolumeByXML(userId).size();
        return R.success(amount);
    }

    /**
     * 待办列表
     * @param wPage
     * @param request
     * @return
     */
    @ApiOperation(value = "待办列表", notes = "待办列表")
    @PostMapping(value = "/backlogdataVolumeList")
    @RequestMapping(value = "backlogdataVolumeList",method = RequestMethod.POST, produces = "application/json")
    public R backlogdataVolumeList(@RequestBody WPage wPage,HttpServletRequest request){

        // 获取所需要的参数
        String userId = String.valueOf(wPage.getUserId(request));
        List<PmApprovalProcessInstance>  list = backlogDataVolumeService.listBacklogDataVolumeByXML(userId);
        return R.success(list);
    }

    /**
     * 待办分页列表
     * @param wPage
     * @param request
     * @return
     */
    @ApiOperation(value = "待办分页列表", notes = "待办分页列表")
    @PostMapping(value = "/backlogdataVolumePageList")
    @RequestMapping(value = "backlogdataVolumePageList",method = RequestMethod.POST, produces = "application/json")
    public R backlogdataVolumePageList(@RequestBody WPage wPage,HttpServletRequest request){

        // 获取所需要的参数
        String userId = String.valueOf(WO.getUserId(request));
        PageParams<PmApprovalProcessInstance> params = wPage.getPageParams();
        List<PmApprovalProcessInstance>  list = backlogDataVolumeService.listBacklogDataVolumePageByXML(userId,params.getCurrent(),params.getSize());
        return R.success(list);
    }
}