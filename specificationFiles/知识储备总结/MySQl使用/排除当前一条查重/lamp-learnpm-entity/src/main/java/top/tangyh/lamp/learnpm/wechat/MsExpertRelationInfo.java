package top.tangyh.lamp.learnpm.wechat;
/**
 * @author xuchunlong
 * @create 2022-07-10-8:54
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.math.BigDecimal;


/**
 * @author: xucl
 * @create: 2022/7/10
 * @Description:
 * @FileName: MsExpertRelationInfo
 * @History:
 * @自定义内容：
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class MsExpertRelationInfo {





    /**
     * 姓名
     */
    private String name;

    /**
     * 电话
     */
    private String tel;

    /**
     * 证件号码
     */
    private String certificateCode;

    /**
     * 任职医院
     */
    private String workingHospital;

    /**
     * 任职科室
     */
    private String department;

    /**
     * 开户行名称
     */
    private String bankBranchName;

    /**
     * 开户行账号
     */
    private String account;

    /**
     * 专家简介
     */
    private String expertProfile;
}