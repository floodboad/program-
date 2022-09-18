package top.tangyh.lamp.learnpm.wechatcontroller;/**
 * @author xuchunlong
 * @create 2022-06-30-12:15
 */

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.wechat.WO;
import top.tangyh.lamp.learnpm.wechatsevice.AudienceService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xucl
 * @create: 2022/6/30
 * @Description: 听众信息查看
 * @FileName: AudienceController
 * @History:
 */

@Slf4j
@RequiredArgsConstructor
@Validated
@RestController
@RequestMapping("/api/wechat/Audience")
@Api(value = "Audience", tags = "听众信息查看")
@CrossOrigin(allowCredentials = "true", allowedHeaders = "*", originPatterns = "*")
public class AudienceController {

    @Autowired
    private AudienceService audienceService;
    /**
     * 听众信息查看
     * @param wo
     * @return
     */
    @ApiOperation(value = "听众信息查看", notes = "听众信息查看")
    @PostMapping(value = "/Audience")
    @RequestMapping(value = "Audience",method = RequestMethod.POST, produces = "application/json")
    public R backlogdataVolume(@RequestBody WO wo){

        // 用户表与听众信息表同时增加，Audience的json对象传进来
        String msAudience = wo.getData();
        //在逻辑层用户表与听众信息表同时增加添加数据    MsAudienceInfo msAudienceInfo = JSON.parseObject(msAudience , MsAudienceInfo.class);
        boolean isSucessOrNot = audienceService.AudienceInformationEntry(msAudience);
        if (isSucessOrNot){
            R.success("听众信息增加成功！");
        }
        return R.fail("听众信息增加失败！");
    }
}