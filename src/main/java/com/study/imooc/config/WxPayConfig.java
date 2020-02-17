package com.study.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * created by Leo徐忠春
 * created Time 2020/2/16-20:51
 * email 1437665365@qq.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "wx")
public class WxPayConfig {

    private String appId;
    private String mchId;
    private String mchKey;
    private String notifyUrl;
    private String returnUrl;

}
