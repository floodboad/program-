package top.tangyh.lamp.learnpm.wechat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import net.bytebuddy.implementation.bind.annotation.Default;
import org.apache.poi.ss.formula.functions.T;
import top.tangyh.basic.base.entity.SuperEntity;
import top.tangyh.basic.base.request.PageParams;
import top.tangyh.lamp.system.entity.tenant.DefUser;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @Class: WO
 * @Author: MrSnow
 * @Date: 2022/6/29 9:21
 * @Describe 用于微信小程序接口入参
 *
 */
@RequiredArgsConstructor
@Data
@ToString
public class WO implements Serializable {

    /**
     * 一次只能传入一条，各种Id，用于查询单体详情 例: projectId = XXX;
     */
    private Long dataId;

    /**
     * 数据(JSON字符串,用于转java对象,或者其他数据）
     */
    private String data;

    /**
     * 获取userId
     * @param request
     * @return userId Long类型
     */
    public static Long getUserId(HttpServletRequest request){
        String userId = request.getHeader("userId");
        return Long.parseLong(userId);
    }

    /**
     * 获取手机号
     * @param request
     * @return
     */
    public static String getPhone(HttpServletRequest request){
        String phone = request.getHeader("userPhone");
        return phone;
    }

}
