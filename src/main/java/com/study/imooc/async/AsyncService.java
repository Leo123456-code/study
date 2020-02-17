package com.study.imooc.async;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 *  异步处理服务
 * created by Leo徐忠春
 * created Time 2020/2/16-21:26
 * email 1437665365@qq.com
 */

@Slf4j
@Service
public class AsyncService {
    //指定線程池名稱
    @Async("getAsyncExecutor")
    //开启异步任务
    public void asyncProcess() throws InterruptedException {
       log.info("async process task,current thread name 线程名称->{}",
               Thread.currentThread().getName());
//       Thread.sleep(3000);
        TimeUnit.SECONDS.sleep(2);//睡眠2s
    }

    //指定線程池名稱
    @Async("getAsyncExecutor")
    //开启异步任务
    public Future<Integer> asyncProcessHasReturn() throws InterruptedException {
        log.info("async processHasReturn task,current thread name 线程名称->{}",
                Thread.currentThread().getName());
        TimeUnit.SECONDS.sleep(2);
        return new AsyncResult<>(100);
    }
}
