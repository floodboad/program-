package top.tangyh.lamp.learnpm.wechat;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import top.tangyh.lamp.file.enumeration.FileStorageType;



import java.io.Serializable;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotBlank;


/**
 * 修改头像
 */
@RequiredArgsConstructor
@Data
@ToString(callSuper = true)
public class UpdateFile  implements Serializable {

    // 电话
    private String phone;
     // 文件
     private  MultipartFile file;



    @ApiModelProperty(value = "业务类型")
    @NotBlank(message = "请填写业务类型")
    private String bizType;

    @ApiModelProperty(value = "桶")
    private String bucket;

    @ApiModelProperty(value = "存储类型")
    private FileStorageType storageType;









}
