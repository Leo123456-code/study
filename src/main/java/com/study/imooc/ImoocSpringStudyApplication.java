package com.study.imooc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//开启定时任务
@EnableScheduling
//开启异步支持
@EnableAsync
public class ImoocSpringStudyApplication {

    public static void main(String[] args) {
         //1.通过run静态方法
        SpringApplication.run(ImoocSpringStudyApplication.class, args);
        //2.通过API 调整应用行为
//        SpringApplication application =
//                new SpringApplication(ImoocSpringStudyApplication.class);
//        application.setBannerMode(Banner.Mode.OFF);
//        application.setWebApplicationType(WebApplicationType.NONE);
//        application.run(args);
        //3.SpringApplicationBuilder Fluent API 链式调用
//        new SpringApplicationBuilder(ImoocSpringStudyApplication.class)
//                .bannerMode(Banner.Mode.OFF).web(WebApplicationType.NONE).
//                run(args);
    }
}
