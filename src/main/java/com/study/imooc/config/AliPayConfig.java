package com.study.imooc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * created by Leo徐忠春
 * created Time 2020/2/16-20:54
 * email 1437665365@qq.com
 */
@Data
@Component
@ConfigurationProperties(prefix = "alipay")
public class AliPayConfig {

    private String appId;
    private String privateKey;
    private String payPublicKey;
    private String notifyUrl;
    private String returnUrl;

}
