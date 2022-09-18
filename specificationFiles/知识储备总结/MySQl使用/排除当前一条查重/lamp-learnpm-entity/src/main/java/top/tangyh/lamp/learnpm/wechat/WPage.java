package top.tangyh.lamp.learnpm.wechat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import top.tangyh.basic.base.request.PageParams;

import java.io.Serializable;

/**
 * @Author MrSnow *** dz
 * @CreateTime: 2022-07-08  10:40
 **/
@ToString(callSuper = true)
@Data
@RequiredArgsConstructor
public class WPage extends WO implements Serializable {
    /**
     * page查询参数
     */
    private PageParams pageParams;
}
