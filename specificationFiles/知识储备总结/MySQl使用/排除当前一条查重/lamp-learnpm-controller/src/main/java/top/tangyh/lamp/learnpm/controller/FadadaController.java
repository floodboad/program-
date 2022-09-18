package top.tangyh.lamp.learnpm.controller;

import com.fadada.sdk.base.model.req.*;
import com.fadada.sdk.extra.model.req.GetPdfTemplateKeysParams;
import com.fadada.sdk.verify.model.req.ApplyCertParams;
import com.fadada.sdk.verify.model.req.PersonVerifyUrlParams;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import top.tangyh.lamp.learnpm.service.FaDaDaService;

/**
 * @author Cleverguyyy
 * @date 2022年06月16日 10:13
 */

@Slf4j
@RestController
@RequestMapping("/fadada")
@Api(value = "Fadada", tags = "测试法大大")
public class FadadaController {

    @Autowired
    private FaDaDaService faDaDaService;

    /**
     * 注册
     * @param
     * @return
     */
    @PostMapping("/accountRegister")
    @ApiOperation(value = "注册")
    public String accountRegister(RegisterAccountParams params) {
        return faDaDaService.accountRegister(params);
    }

    /**
     * 个人实名认证
     * @param
     * @return
     */
    @PostMapping("/getPersonVerifyUrl")
    @ApiOperation(value = "个人实名认证")
    public String getPersonVerifyUrl(PersonVerifyUrlParams params) {
        return faDaDaService.getPersonVerifyUrl(params);
    }

    /**
     * 证书申请
     * @param
     * @return
     */
    @PostMapping("/applyCert")
    @ApiOperation(value = "证书申请")
    public String applyCert(ApplyCertParams params) {
        return faDaDaService.applyCert(params);
    }

    ///**
    // * 上传模板
    // * @param
    // * @return
    // */
    //@PostMapping(value = "/uploadTemplate",produces = "multipart/form-data")
    //@ApiOperation(value = "上传模板")
    //public String uploadTemplate(UploadTemplateParams params) {
    //    return faDaDaService.uploadTemplate(params);
    //}

    /**
     * 上传模板
     * @param
     * @return
     */
    @PostMapping(value = "/uploadTemplate")
    @ApiOperation(value = "上传模板")
    public String uploadTemplate1(@RequestParam("file") MultipartFile file,String templateId) {
        return faDaDaService.uploadTemplate(file,templateId);
    }


    /**
     * 模板填充
     * @param
     * @return
     */
    @PostMapping("/generateContract")
    @ApiOperation(value = "模板填充")
    public String generateContract(GenerateContractParams params) {
        return faDaDaService.generateContract(params);
    }

    /**
     * 获取pdf模版表单域 key 值
     * @param
     * @return
     */
    @PostMapping("/getPdftemplateKeys")
    @ApiOperation(value = "获取pdf模版表单域key值")
    public String getPdftemplateKeys(GetPdfTemplateKeysParams params) {
        return faDaDaService.getPdftemplateKeys(params);
    }

    /**
     * 手动签署
     * @param
     * @return
     */
    @PostMapping("/extsign")
    @ApiOperation(value = "手动签署")
    public String extsign(ExtSignParams params) {
        return faDaDaService.extsign(params);
    }

    /**
     * 获取自动签权限
     * @param
     * @return
     */
    @PostMapping("/beforeAuthsign")
    @ApiOperation(value = "获取自动签权限")
    public String beforeAuthsign(BeforeAuthSignParams params) {
        return faDaDaService.beforeAuthsign(params);
    }

    /**
     * 自动签署
     * @param
     * @return
     */
    @PostMapping("/extsignAuto")
    @ApiOperation(value = "自动签署")
    public String extsignAuto(ExtSignAutoParams params) {
        return faDaDaService.extsignAuto(params);
    }

    /**
     * 合同查看
     * @param
     * @return
     */
    @PostMapping("/viewContract")
    @ApiOperation(value = "合同查看")
    public String viewContract(ViewPdfURLParams params) {
        return faDaDaService.viewContract(params);
    }

    /**
     * 合同归档
     * @param
     * @return
     */
    @PostMapping("/contractFiling")
    @ApiOperation(value = "合同归档")
    public String contractFiling(ContractFillingParams params) {
        return faDaDaService.contractFiling(params);
    }
}
