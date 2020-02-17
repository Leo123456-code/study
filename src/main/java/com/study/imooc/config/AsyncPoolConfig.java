package com.study.imooc.config;

import com.fasterxml.jackson.annotation.JsonTypeId;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义异步线程池的配置
 * created by Leo徐忠春
 * created Time 2020/2/16-21:36
 * email 1437665365@qq.com
 */
@Slf4j
@Configuration
public class AsyncPoolConfig implements AsyncConfigurer {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();

    /**
     *   返回自定義的線程池
     * @return
     */
    @Bean
    @Override
    public Executor getAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(10);//核心線程數量
        executor.setMaxPoolSize(20);//線程池維護最多線程數量
        executor.setQueueCapacity(20);//緩衝隊列任務個數
        executor.setKeepAliveSeconds(60);//最大存活時間60s
        executor.setThreadNamePrefix("ImoocAsync_");//線程名前綴

        executor.setWaitForTasksToCompleteOnShutdown(true);//是否等待所有線程執行完成之後關閉
        executor.setAwaitTerminationSeconds(60);//等待時長
        //拒絕策略
        executor.setRejectedExecutionHandler
                (new ThreadPoolExecutor.AbortPolicy());//等待並執行
        executor.initialize();//線程池初始化
        log.info("這是自定義的線程池....");
        return executor;
    }

    /**
     *  定義異步任務異常處理類
     * @return
     */
    @Override
    public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {

        return new AsyncExceptionHandler();
    }

    class AsyncExceptionHandler implements AsyncUncaughtExceptionHandler{
        @Override
        public void handleUncaughtException(Throwable ex, Method method,
                                            Object... params) {
            log.info("AsyncError={},Method={},Param={}",ex.getMessage(),
                    method.getName(),gson.toJson(params) );
            ex.printStackTrace();//打印异常
            //TODO 发送邮件或短信
        }
    }
}
