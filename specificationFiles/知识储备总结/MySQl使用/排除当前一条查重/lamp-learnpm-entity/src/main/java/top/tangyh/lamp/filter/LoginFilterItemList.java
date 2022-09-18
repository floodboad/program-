package top.tangyh.lamp.filter;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@Component
@ConfigurationProperties(prefix = "lamp.loginfilter")
public class LoginFilterItemList {
    private List<FilterItem> itemList;
}
