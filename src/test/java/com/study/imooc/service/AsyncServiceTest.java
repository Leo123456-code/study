package com.study.imooc.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.imooc.ImoocSpringStudyApplicationTests;
import com.study.imooc.async.AsyncService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步服务功能测试
 * created by Leo徐忠春
 * created Time 2020/2/16-22:20
 * email 1437665365@qq.com
 */
@Slf4j
public class AsyncServiceTest extends ImoocSpringStudyApplicationTests {
    @Autowired
    private AsyncService asyncService;

    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Test
    public void async() throws InterruptedException {
        long start = System.currentTimeMillis();
        log.info("coming for process........");
        asyncService.asyncProcess();
        log.info("運行時間={}",System.currentTimeMillis()-start+"ms");

    }
    @Test
    public void asyncHasReturn() throws Exception {
        long start = System.currentTimeMillis();
        log.info("coming for process........");
        Future<Integer> result = asyncService.asyncProcessHasReturn();//會阻塞
        log.info("result={}",result.get(99, TimeUnit.SECONDS));
        log.info("时间={}",System.currentTimeMillis()-start+"ms");

    }

}
