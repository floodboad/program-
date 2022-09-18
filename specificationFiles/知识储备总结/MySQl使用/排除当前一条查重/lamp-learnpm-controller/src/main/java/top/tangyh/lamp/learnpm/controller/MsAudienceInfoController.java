package top.tangyh.lamp.learnpm.controller;


import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DataSourceProperty;
import com.sun.corba.se.spi.ior.IdentifiableFactory;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import top.tangyh.basic.base.R;
import top.tangyh.basic.base.controller.SuperController;
import top.tangyh.basic.interfaces.echo.EchoService;
import top.tangyh.lamp.learnpm.entity.MsAudienceInfo;
import top.tangyh.lamp.learnpm.service.MsAudienceInfoService;
import top.tangyh.lamp.learnpm.vo.query.MsAudienceInfoPageQuery;
import top.tangyh.lamp.learnpm.vo.result.MsAudienceInfoResultVO;
import top.tangyh.lamp.learnpm.vo.save.MsAudienceInfoSaveVO;
import top.tangyh.lamp.learnpm.vo.update.MsAudienceInfoUpdateVO;

/**
 * <p>
 * 听众信息表前端控制器
 * 
 * </p>
 *
 * @author xucl
 * @date 2022-06-08
 */
@Slf4j
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/msAudienceInfo")
@Api(value = "MsAudienceInfo", tags = " 听众信息表")
public class MsAudienceInfoController extends SuperController<MsAudienceInfoService, Long, MsAudienceInfo, MsAudienceInfoSaveVO, MsAudienceInfoUpdateVO, MsAudienceInfoPageQuery, MsAudienceInfoResultVO> {

    private final MsAudienceInfoService msAudienceInfoService;

    private final EchoService echoService;

    @Override
    public EchoService getEchoService() {
        return echoService;
    }

    /**
     * @description:此方法用于弹窗，弹窗后若电话号码重复提示重写号码，在弹窗重写电话号码，再进行保存。
     * @author:xucl
     * @time:2022.6.30
     */
    @RequestMapping("/uniquePhoneNumsSave")
    public R saveUniquePhoneNums(@RequestParam String phoneNums) {
        // 听众信息栏电话输入框采取“弹窗输入查库不存在无误后保存插入数据库”保存
        boolean flag = msAudienceInfoService.uniquePhoneNumsSave(phoneNums);
        if (!flag) {
            return R.fail("数据库已经有数据了，不可以添加");
        }
        return R.success("可以添加");
    }
}
