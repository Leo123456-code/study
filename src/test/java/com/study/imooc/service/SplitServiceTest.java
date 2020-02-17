package com.study.imooc.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.study.imooc.ImoocSpringStudyApplicationTests;
import com.study.imooc.config.SpringBootConfig;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

/**
 * created by Leo徐忠春
 * created Time 2020/2/17-1:42
 * email 1437665365@qq.com
 */
@Slf4j
public class SplitServiceTest extends ImoocSpringStudyApplicationTests {
    private Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Autowired
    private SpringBootConfig springBootConfig;


    @Autowired
    private ISplitService splitService;

    @Test
    public void testSplitService(){
        log.info("split version={}",gson.toJson
                (splitService.split(springBootConfig.getVersion())));
    }
}
