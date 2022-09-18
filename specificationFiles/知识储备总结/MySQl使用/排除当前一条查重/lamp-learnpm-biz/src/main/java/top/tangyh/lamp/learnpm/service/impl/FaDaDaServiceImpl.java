package top.tangyh.lamp.learnpm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.fadada.sdk.base.client.FddBaseClient;
import com.fadada.sdk.base.model.req.*;
import com.fadada.sdk.extra.client.FddExtraClient;
import com.fadada.sdk.extra.model.req.GetPdfTemplateKeysParams;
import com.fadada.sdk.verify.client.FddVerifyClient;
import com.fadada.sdk.verify.model.req.ApplyCertParams;
import com.fadada.sdk.verify.model.req.CompanyVerifyUrlParams;
import com.fadada.sdk.verify.model.req.FindPersonCertParams;
import com.fadada.sdk.verify.model.req.PersonVerifyUrlParams;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import top.tangyh.lamp.base.service.user.BaseOrgService;
import top.tangyh.lamp.learnpm.constant.MultipartFileToFileUtil;
import top.tangyh.lamp.learnpm.service.FaDaDaService;
import top.tangyh.lamp.system.entity.tenant.DefUser;
import top.tangyh.lamp.system.service.tenant.DefUserService;

import java.io.File;
import java.util.UUID;

@Data
@Service
@Slf4j
@RequiredArgsConstructor
public class FaDaDaServiceImpl implements FaDaDaService {

    @Value("${lamp.fdd.appid}")
    private String APPID;

    @Value("${lamp.fdd.appkey}")
    private String APPKEY;

    @Value("${lamp.fdd.version}")
    private String V;

    @Value("${lamp.fdd.host}")
    private String HOST;

    //@Value("${lamp.fdd.appid}")
    //public void setAPPID(String APPID) {
    //    this.APPID = APPID;
    //}
    //
    //@Value("${lamp.fdd.appkey}")
    //public void setAPPKEY(String APPKEY) {
    //    this.APPKEY = APPKEY;
    //}
    //
    //@Value("${lamp.fdd.version}")
    //public void setV(String v) {
    //    V = v;
    //}
    //
    //@Value("${lamp.fdd.host}")
    //public void setHOST(String HOST) {
    //    this.HOST = HOST;
    //}

    private final DefUserService userService;
    private final BaseOrgService baseOrgService;

    /**
     * 注册接口
     * @param params
     * @return
     */
    @Override
    public String accountRegister(RegisterAccountParams params) {
        FddBaseClient baseClient = new FddBaseClient(APPID, APPKEY, V, HOST);
        //params.setAccountType("1"); //账号类型1个人 2企业
        //params.setOpenId("1234564789"); //平台方自定义唯一标识
        String registerAccount = baseClient.invokeRegisterAccount(params);
        //try {
        //    BaseRes javaBean = JacksonUtil.toJavaBean(registerAccount, BaseRes.class);
        //    //注册返回的客户编号
        //    String customerId = (String) javaBean.getData();
        //    System.out.println("注册返回的客户编号: " + customerId);
        //} catch (ApiException e) {
        //    e.printStackTrace();
        //}
        return registerAccount;
    }

    /**
     * 个人实名认证
     * @param params
     * @return
     */
    @Override
    public String getPersonVerifyUrl(PersonVerifyUrlParams params) {
        FddVerifyClient client = new FddVerifyClient(APPID, APPKEY, V, HOST);

        //通过手机号获取用户信息(为了获取客户编号)
        //DefUser user = userService.getUserByMobile(params.getMobile());
        //System.out.println("=========================");
        //System.out.println(user);

        //TODO 判断已注册
        //if (user.getIsRealNameAuth()) {
        //    return "该账号已实名！";
        //}

        //params.setCustomerId(user.getCustomerNumber()); //客户编号
        //params.setVerifiedWay("0"); //实名认证套餐类型
        //params.setPageModify("1"); //是否允许用户页面修改 1允许 2不允许
        //以下是非必填参数
        //params.setNotifyUrl(""); //异步回调地址
        //params.setReturnUrl(""); //同步通知url
        //params.setCustomerName("李雨雨"); //姓名
        //params.setCustomerIdentType("0"); //证件类型
        //params.setCustomerIdentNo("152628199810255190"); //证件号码
        //params.setMobile("15735273591"); //手机号码
        //params.setIdentFrontPath(""); //证件正面照下载地址
        //params.setIdentBackPath(""); //证件反面照下载地址
        //params.setResultType(""); //刷脸是否显示结果页面
        //params.setCertFlag("1"); //是否认证成功后自动申请实名证书
        //params.setCertType("0"); //证件类型
        //params.setBankCardNo("6222030200012232587"); //个人银行卡
        //params.setOption("add"); //不传默认add
        //params.setIdPhotoOptional("2"); //是否需要上传身份照片
        //params.setIsMinProgram(""); //是否跳转法大大公证处小程序认证
        //params.setLang("zh"); //zh：中文；en：英文
        //params.setIsAllowOverseasBankCardAuth("0"); //海外用户是否支持银行卡认证
        //params.setIdentFrontImg(new File("")); //证件正面照图片文件
        //params.setIdentBackImg(new File("")); //证件反面照图片文件

        //{"code":1,"data":{
        // "transactionNo":"01f8a2a130cf43e4bb40ad1630199c60",
        // "url":"aHR0cHM6Ly9yZWFsbmFtZXZlcmlmeS10ZXN0LmZhZGFkYS5jb20vZmRkQXV0aGVudGljYXRpb25TZXJ2aWNlL3YxL2FwaS9zeW5zQXV0aGVudGljYXRpb24uYWN0aW9uP3RyYW5zYWN0aW9uX25vPTY3NUU0MjI3MEI0ODk2MUUxMTE2NEYwODhBOUE4MEJCMkM2NTQzNEZFMDMxQkE5RTM3NDkyQUE2MzAwRjJDODk2NDhGMDYzOUE0RTI4NjdFJnNpZ249T1VWRlJrWXpSRGt6TnpKRVJFRTBNRVUxUWpnNE1qRXlSVFpHUlRaQ056QXlNa0ZHT1RFeE5BPT0mYXBwX2lkPTQwNjIzNyZ0aW1lc3RhbXA9MTY1NDczOTU4NDI2Mg=="},
        // "msg":"success"}
        //transactionNo:交易号（需要保存，用于证书申请和实名认证查询）
        //url:地址（需要保存，遇到中途退出认证或页面过期等情况可重新访问）   需要Base64解码
        return client.invokePersonVerifyUrl(params);
    }

    /**
     * 企业实名认证
     * @param params
     * @return
     */
    @Override
    public String getCompanyVerifyUrl(CompanyVerifyUrlParams params) {
        FddVerifyClient client = new FddVerifyClient(APPID, APPKEY, V, HOST);
        //通过手机号获取用户信息(为了获取客户编号)
        DefUser user = userService.getUserByMobile(params.getMobile());
        params.setCustomerId(user.getCustomerNumber()); //客户编号
        params.setPageModify("1");//是否允许用户页面修改 1允许 2不允许 默认为1
        // 以下是非必填参数
        params.setIdPhotoOptional("2");//0-只需要头像面 1-头像面与国徽面都需要 2-都不需要 默认为0
        return client.invokeCompanyVerifyUrl(params);
    }

    /**
     * 证书申请
     * @param params
     * @return
     */
    @Override
    public String applyCert(ApplyCertParams params) {
        FddVerifyClient client = new FddVerifyClient(APPID, APPKEY, V, HOST);
        //DefUser user = userService.getById(userId);

        //params.setCustomerId(user.getCustomerNumber()); //客户编号
        params.setVerifiedSerialNo("40f117c1f22b4b26a23e5f5bedc0d248"); //填写获取实名认证地址返回的交易号transactionNo
        //{"code":3205,"msg":"实名认证未通过"}
        return client.invokeApplyCert(params);
    }

    /**
     * 上传模板
     * @param params
     * @return
     */
    //@Override
    //public String uploadTemplate(UploadTemplateParams params){
    //    FddBaseClient baseClient = new FddBaseClient(APPID, APPKEY, V, HOST);
    //    String uuid = UUID.randomUUID().toString().replace("-","");
    //
    //    //向指定组织写入模板编号
    //    //BaseOrg baseOrg = baseOrgService.getById(orgId);
    //    //BaseOrgUpdateVO updateVO = new BaseOrgUpdateVO();
    //    //updateVO.setId(orgId);
    //    //BeanUtils.copyProperties(baseOrg,updateVO);
    //    //updateVO.setContractTemplateNo(uuid);
    //    //baseOrgService.updateById(updateVO);
    //    //
    //    //params.setTemplateId(uuid); // 平台自定义唯一模板编号
    //    // 下列PDF模板和文档地址二选一
    //    params.setFile(new File("D:\\授权委托书模板.pdf")); // PDF模板
    //    //params.setDocUrl(""); // 文档地址
    //    return baseClient.invokeUploadTemplate(params);
    //}


    /**
     * 上传模板
     * @param
     * @return
     */
    @Override
    public String uploadTemplate(MultipartFile file, String templateId){
        FddBaseClient baseClient = new FddBaseClient(APPID, APPKEY, V, HOST);
        //String uuid = UUID.randomUUID().toString().replace("-","");
        UploadTemplateParams params = new UploadTemplateParams();
        //向指定组织写入模板编号
        //BaseOrg baseOrg = baseOrgService.getById(orgId);
        //BaseOrgUpdateVO updateVO = new BaseOrgUpdateVO();
        //updateVO.setId(orgId);
        //BeanUtils.copyProperties(baseOrg,updateVO);
        //updateVO.setContractTemplateNo(uuid);
        //baseOrgService.updateById(updateVO);
        //
        params.setTemplateId(templateId); // 平台自定义唯一模板编号
        // 下列PDF模板和文档地址二选一
        //params.setFile(new File("D:\\授权委托书模板.pdf")); // PDF模板
        File multipartFileToFile = MultipartFileToFileUtil.multipartFileToFile(file);
        params.setFile(multipartFileToFile); // PDF模板
        //params.setDocUrl(""); // 文档地址
        return baseClient.invokeUploadTemplate(params);
    }

    /**
     * 模板填充
     * @param params
     * @return
     */
    @Override
    public String generateContract(GenerateContractParams params) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        FddBaseClient baseClient = new FddBaseClient(APPID, APPKEY, V, HOST);

        //BaseOrg baseOrg = baseOrgService.getById(orgId);
        //params.setTemplateId(baseOrg.getContractTemplateNo()); //模板编号
        //params.setContractId(uuid); //合同编号
        // 以下是非必填参数
        //params.setDocTitle("授权委托书模板"); // 文档标题
        //params.setFontSize("12"); //字体大小
        //params.setFontType("4"); //字体类型
        //params.setParameterMap(getparamter()); //填充内容,json字符串
        //params.setDynamicTables(getdynamic_tables()); //动态表格
        return baseClient.invokeGenerateContract(params);
    }

    /**
     * 获取pdf模版表单域 key 值
     * @param params
     * @return
     */
    @Override
    public String getPdftemplateKeys(GetPdfTemplateKeysParams params) {
        FddExtraClient client = new FddExtraClient(APPID, APPKEY, V, HOST);
        //params.setTemplateId("");//模板id
        //params.setFillType(0);//模板类型 0-pdf模板，1-在线模板
        return client.invokeGetPdfTemplateKeys(params);
    }

    // 构造填充内容ParameterMap示例
    private String getparamter() {
        JSONObject paramter = new JSONObject();

        //TODO 参数待修改 动态表格待修改
        paramter.put("borrower", "DFHC");
        paramter.put("name", "张三");
        paramter.put("platformName", "DFHC北京");
        return paramter.toString();
    }

    // 构造动态表格DynamicTables示例
    private String getdynamic_tables() {
        JSONArray dynamic_tables = new JSONArray();
        JSONObject dynamic2 = new JSONObject();
        dynamic2.put("insertWay", 1);//0新页面插入 1在某个关键字后面插入
        dynamic2.put("pageBegin", "2");//页码从1开始计算
        dynamic2.put("keyword", "借款方");//insertWay=1时，传关键字
        dynamic2.put("cellHeight", "16.0");
        dynamic2.put("colWidthPercent", new int[]{3, 4, 4, 4});
        dynamic2.put("theFirstHeader", "附二");
        dynamic2.put("cellHorizontalAlignment", "1");
        dynamic2.put("cellVerticalAlignment", "5");
        dynamic2.put("headers", new String[]{"序号", "借款人", "贷款人", "金额"});
        String row1[] = new String[]{"1", "小网", "小易", "1000"};
        String row2[] = new String[]{"2", "小云", "小音", "2000"};
        String row3[] = new String[]{"3", "小乐", "天马", "3000"};
        dynamic2.put("datas", new String[][]{row1, row2, row3});
        dynamic2.put("headersAlignment", "1");
        dynamic2.put("tableWidthPercentage", 80);
        dynamic_tables.add(dynamic2);
        System.out.println(dynamic_tables.toString());
        return dynamic_tables.toString();

        //[{"headers":["序号","借款人","贷款人","金额"],"insertWay":0,"tableWidthPercentage":80,"pageBegin":"1","headersAlignment":"1","datas":[["1","小网","小易","1000"],["2","小云","小音","2000"],["3","小乐","天马","3000"]],"theFirstHeader":"附二","cellHeight":"16.0","colWidthPercent":[3,4,4,4],"cellHorizontalAlignment":"1","cellVerticalAlignment":"5"}]
        //{"code":"1000","download_url":"https:\/\/testapi.fadada.com:8443\/api\/downLoadContract.action?app_id=406237&v=2.0&timestamp=20220615184820&contract_id=UUID1233217&msg_digest=REVENDNBMTc0QTk4OEMxQkM4Q0YzMzJCNzlGMjEzOUVGMUQwODQ3Qw==","msg":"操作成功","result":"success","viewpdf_url":"https:\/\/testapi.fadada.com:8443\/api\/viewContract.action?app_id=406237&v=2.0&timestamp=20220615184820&contract_id=UUID1233217&msg_digest=REVENDNBMTc0QTk4OEMxQkM4Q0YzMzJCNzlGMjEzOUVGMUQwODQ3Qw=="}
        //
        //Process finished with exit code 0


        //[{"headers":["序号","借款人","贷款人","金额"],"insertWay":1,"tableWidthPercentage":80,"pageBegin":"2","headersAlignment":"1","datas":[["1","小网","小易","1000"],["2","小云","小音","2000"],["3","小乐","天马","3000"]],"theFirstHeader":"附二","cellHeight":"16.0","colWidthPercent":[3,4,4,4],"keyword":"借款方","cellHorizontalAlignment":"1","cellVerticalAlignment":"5"}]
        //{"code":"1000",
        // "download_url":"https:\/\/testapi.fadada.com:8443\/api\/downLoadContract.action?app_id=406237&v=2.0&timestamp=20220627151010&contract_id=56789&msg_digest=MzYwRkFCNUM0NzBGMTM4OTZCNjc4RDc5NDA1NDg0QzFDNDIwNzRCNg==",
        // "msg":"操作成功","result":"success",
        // "viewpdf_url":"https:\/\/testapi.fadada.com:8443\/api\/viewContract.action?app_id=406237&v=2.0&timestamp=20220627151010&contract_id=56789&msg_digest=MzYwRkFCNUM0NzBGMTM4OTZCNjc4RDc5NDA1NDg0QzFDNDIwNzRCNg=="}
    }


    /**
     * 合同上传
     * @param params
     * @return
     */
    @Override
    public String uploaddocs(UploadDocsParams params) {
        FddBaseClient baseClient = new FddBaseClient(APPID, APPKEY, V, HOST);

        params.setContractId("UUID123321"); //自定义合同id
        params.setDocTitle("法大大合同"); //合同标题
        // PDF文档和下载地址二选一
        params.setFile(new File("D:\\法大大.pdf")); //PDF文档
        //params.setDocUrl(""); //合同公网下载地址
        params.setDocType(".pdf"); //合同类型 目前仅支持pdf格式
        String result = baseClient.invokeUploadDocs(params);

        //{"code":"1000","msg":"操作成功","result":"success"}
        System.out.println(result);
        return baseClient.invokeUploadDocs(params);
    }

    /**
     * 合同查看
     * @param params
     * @return
     */
    @Override
    public String viewContract(ViewPdfURLParams params) {
        FddBaseClient client = new FddBaseClient(APPID, APPKEY, V, HOST);

        //params.setContractId("UUID123321"); //此处传入调用上传或填充合同接口成功 时定义的合同编号
        //http://test.api.fabigbig.com:8888/api/viewContract.api?app_id=406237&v=2.0&timestamp=20220609001057&contract_id=UUID1231254135136&msg_digest=MDc5NjFDNkU4RDE4RDUxMEE2QzQ5QjQwMEVBNjA4QkZEQjMwRUM3Nw==
        return client.invokeViewPdfURL(params);
    }

    /**
     * 手动签署
     * @param params
     * @return
     */
    @Override
    public String extsign(ExtSignParams params) {
        String uuid = UUID.randomUUID().toString().replace("-","");
        FddBaseClient client = new FddBaseClient(APPID, APPKEY, V, HOST);
        //DefUser user = userService.getById(userId);

        params.setTransactionId(uuid);//平台自定义唯一交易号
        //params.setContractId("UUID123321");//此处传入调用上传或填充合同接口成功时定义 的合同编号
        //params.setCustomerId(user.getCustomerNumber());//此处传入认证成功后成功申请证书的客户编号
        //params.setDocTitle("租赁合同协议");

        //手动签名
        params.setMobileSignType("2");//签章类型
        params.setPcHandSignature("1");//支持pc手写印章
        params.setWritingTrack("1");//是否开启手写轨迹
        params.setOpenEnvironment("2");

        //关键字签署
        //params.setPositionType("1");//0-关键字（默认）1-坐标
        //params.setSignKeyword("法大大");
        //params.setKeywordStrategy("1");//0-所有关键字签章 （默认） 1-第一个关键字签章 2-最后一个 关键字签章
        //http://test.api.fabigbig.com:8888/api/extsign.api?app_id=406237&v=2.0&timestamp=20220609000532&transaction_id=f84524f1ca53480c93ec9bc012e7b23b&customer_id=D88AC2E0825E27D4F5436E740496CFFE&contract_id=UUID1231254135136&doc_title=%E7%A7%9F%E8%B5%81%E5%90%88%E5%90%8C%E5%8D%8F%E8%AE%AE&keyword_strategy=0&sign_keyword=%E5%8F%97%E6%89%98%E6%96%B9%E7%AD%BE%E5%AD%97&position_type=0&msg_digest=MTc4MEY4NjM0Q0E4QUYxM0Y1NDE2OEREMDIxNUU3RjYxODg0Q0U3Qg==
        return client.invokeExtSign(params);
    }

    /**
     * 获取自动签权限
     * @param params
     * @return
     */
    @Override
    public String beforeAuthsign(BeforeAuthSignParams params) {
        FddBaseClient client = new FddBaseClient(APPID, APPKEY, V, HOST);
        //params.setTransactionId("3f97e53f00fb41b9aeac10fa5796727");//平台自定义唯一交易号
        params.setAuthType("1");//1:授权自动签（目前只能填1）
        //params.setContractId("99999999");//指该份线上授权委托书的合同编号，自定义即可
        //params.setCustomerId("8F31113DF24AD9798753F4F1F757BE7F");//传入注册返回的个人或企业客户编号
        //params.setReturnUrl("");//同步通知签署结果地址
        //params.setNotifyUrl("");//异步通知签署结果地址

        return client.invokeBeforeAuthSign(params);
    }

    /**
     * 自动签署
     * @param params
     * @return
     */
    @Override
    public String extsignAuto(ExtSignAutoParams params) {
        String uuid = UUID.randomUUID().toString().replace("-", "");
        FddBaseClient client = new FddBaseClient(APPID, APPKEY, V, HOST);

        params.setTransactionId(uuid);//平台自定义唯一交易号
        System.out.println("==========================" + uuid);
        params.setContractId("3456789");//此处传入调用上传或填充合同接口成功时定义 的合同编号
        params.setCustomerId("8F31113DF24AD9798753F4F1F757BE7F");//此处传入认证成功后成功申请证书的客户编号
        params.setDocTitle("租赁合同协议");
        params.setPositionType("0");//0-关键字（默认）1-坐标
        params.setSignKeyword("平台");
        params.setKeywordStrategy("0");//0：所有关键字签章 1：第一个关键字签章 ； 2：最后一个 关键字签章

        //{"code":"2002","download_url":null,"msg":"未开通自动签权限","result":"error","viewpdf_url":null}
        return client.invokeExtSignAuto(params);
    }

    /**
     * 合同归档
     * @param params
     * @return
     */
    @Override
    public String contractFiling(ContractFillingParams params) {
        FddBaseClient client = new FddBaseClient(APPID, APPKEY, V, HOST);
        //params.setContractId("UUID123321"); //此处传入调用上传或填充合同接口成功时定义的合同编号
        return client.invokeContractFilling(params);
    }

    /**
     * 查询个人实名认证信息
     * @param params
     * @return
     */
    @Override
    public String findPersonCertInfo(FindPersonCertParams params) {
        FddVerifyClient client = new FddVerifyClient(APPID, APPKEY, V, HOST);
        params.setVerifiedSerialNo("01f8a2a130cf43e4bb40ad1630199c60"); //此处填获取个人实名认证地址返回的交易号

        return client.invokeFindPersonCert(params);
    }


}
