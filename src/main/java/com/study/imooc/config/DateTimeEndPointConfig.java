package com.study.imooc.config;

import com.study.imooc.endpint.DateTimeEndPoint;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * created by Leo徐忠春
 * created Time 2020/2/17-0:26
 * email 1437665365@qq.com
 */
@Configuration
public class DateTimeEndPointConfig {

    @Bean
    //条件注解  当Bean缺少的时候才会注入这个Bean
    @ConditionalOnMissingBean
    //条件注解  当这个监控端点开启的时候才会自动注入这个Bean
    @ConditionalOnEnabledEndpoint
    public DateTimeEndPoint dateTimeEndPoint(){
        return new DateTimeEndPoint();
    }
}
