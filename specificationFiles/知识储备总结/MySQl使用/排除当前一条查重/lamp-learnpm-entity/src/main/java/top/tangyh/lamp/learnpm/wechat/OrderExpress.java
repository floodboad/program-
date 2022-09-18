package top.tangyh.lamp.learnpm.wechat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 分配
 */
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
public class OrderExpress implements Serializable {


    // 会议id
    @ApiModelProperty(value = "会议id")
    private Long meetingId;
    //会议名称
    @ApiModelProperty(value = "会议名称")
    private String meetingName;
    //发件名称
    @ApiModelProperty(value = "发件名称")
    private String expressageName;
    // 发件重量
    @ApiModelProperty(value = "发件重量")
    private BigDecimal weight;
    // 发件数量
    @ApiModelProperty(value = "发件数量")
    private Integer number;
    // 会议费用id
    @ApiModelProperty(value = "会议费用id")
    private Long meetingFeeId;
    // 发件人id
    @ApiModelProperty(value = "发件人id")
    private Long senderId;
    // 收件人id
    @ApiModelProperty(value = "收件人id")
    private Long recipientId;
}
