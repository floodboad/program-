package top.tangyh.lamp.learnpm.service;


import com.fadada.sdk.base.model.req.*;
import com.fadada.sdk.extra.model.req.GetPdfTemplateKeysParams;
import com.fadada.sdk.verify.model.req.ApplyCertParams;
import com.fadada.sdk.verify.model.req.CompanyVerifyUrlParams;
import com.fadada.sdk.verify.model.req.FindPersonCertParams;
import com.fadada.sdk.verify.model.req.PersonVerifyUrlParams;
import org.springframework.web.multipart.MultipartFile;

public interface FaDaDaService {

    //注册接口
    String accountRegister(RegisterAccountParams params);

    //个人实名认证
    String getPersonVerifyUrl(PersonVerifyUrlParams params);

    //企业实名认证
    String getCompanyVerifyUrl(CompanyVerifyUrlParams params);

    //证书申请
    String applyCert(ApplyCertParams params);

    //上传模板
    //String uploadTemplate(UploadTemplateParams params);

    //上传模板
    String uploadTemplate(MultipartFile file, String templateId);

    //模板填充
    String generateContract(GenerateContractParams params);

    //获取pdf模版表单域 key 值
    String getPdftemplateKeys(GetPdfTemplateKeysParams params);

    //合同上传
    String uploaddocs(UploadDocsParams params);

    //合同查看
    String viewContract(ViewPdfURLParams params);

    //手动签署
    String extsign(ExtSignParams params);

    //获取自动签权限
    String beforeAuthsign(BeforeAuthSignParams params);

    //自动签署
    String extsignAuto(ExtSignAutoParams params);

    //合同归档
    String contractFiling(ContractFillingParams params);

    //查询个人实名认证信息
    String findPersonCertInfo(FindPersonCertParams params);


}
