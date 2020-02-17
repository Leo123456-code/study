package com.study.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * created by Leo徐忠春
 * created Time 2020/2/16-20:39
 * email 1437665365@qq.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "imooc.springboot")
public class SpringBootConfig {
    private String version;
    private String name;
}
