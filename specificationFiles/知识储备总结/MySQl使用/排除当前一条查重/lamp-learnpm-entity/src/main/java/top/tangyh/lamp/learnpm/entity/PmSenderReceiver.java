package top.tangyh.lamp.learnpm.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;
import top.tangyh.basic.base.entity.Entity;

import java.time.LocalDateTime;

import static com.baomidou.mybatisplus.annotation.SqlCondition.LIKE;

/**
 * <p>
 * 收发件人实体类
 * </p>
 *
 * @author zhaoxl
 * @date 2022-07-09
 */
@Data
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("PM_SENDER_RECEIVER")
@AllArgsConstructor
@Builder
public class PmSenderReceiver extends Entity<Long> {

    private static final long serialVersionUID = 1L;

    /**
     * 所属用户ID 
     */
     @TableField(value = "USER_ID ", condition = LIKE)
    private Long userId;
    /**
     * 姓名 
     */
     @TableField(value = "NAME ", condition = LIKE)
    private String name;
    /**
     * 手机号 
     */
     @TableField(value = "PHONE ", condition = LIKE)
    private String phone;
    /**
     * 省份 
     */
     @TableField(value = "PROVINCE ", condition = LIKE)
    private String province;
    /**
     * 城市 
     */
     @TableField(value = "CITY ", condition = LIKE)
    private String city;
    /**
     * 详细地址 
     */
     @TableField(value = "ADDRESS ", condition = LIKE)
    private String address;
    /**
     * 是否发件人 
     */
     @TableField(value = "IS_SENDER ", condition = LIKE)
    private String isSender;
    /**
     * 是否默认 
     */
     @TableField(value = "IS_DEFAULT ", condition = LIKE)
    private String isDefault;

}
