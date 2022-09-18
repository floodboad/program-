package top.tangyh.lamp.learnpm.pmProjectInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString(callSuper = true)
@AllArgsConstructor
public class PmProjectByvalue {


    private PmProjectInfo pmProjectInfo; // 传页面上相关的项目信息
    private Long pmProjectId;// 项目id
    private String phone; // 手机号
}
