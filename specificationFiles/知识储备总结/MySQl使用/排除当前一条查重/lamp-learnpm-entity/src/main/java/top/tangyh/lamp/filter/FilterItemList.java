package top.tangyh.lamp.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Class: ItemList
 * @Author: MrSnow
 * @Date: 2022/5/13 10:25
 */
@Data
@Component
@ConfigurationProperties(prefix = "lamp.filter")
public class FilterItemList {
    private List<FilterItem> itemList;
}
