package com.study.imooc.config;

import com.study.imooc.service.ISplitService;
import com.study.imooc.service.Impl.SplitServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * created by Leo徐忠春
 * created Time 2020/2/17-1:22
 * email 1437665365@qq.com
 */
@Configuration
//条件注解
@ConditionalOnClass(value = {ISplitService.class, SplitServiceImpl.class})
public class SplitAutoConfig {
    @Bean
    @ConditionalOnMissingBean
    ISplitService startService(){
        return new SplitServiceImpl();
    }
}
