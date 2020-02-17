package com.study.imooc.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 *  設置開機啟動
 * created by Leo徐忠春
 * created Time 2020/2/16-22:53
 * email 1437665365@qq.com
 * 默認 BootApplicationRunner 優先級高於 CommandLineRunner
 */
//優先執行 order(2)
@Order(2)
@Component
@Slf4j
public class BootApplicationRunner implements ApplicationRunner {
    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("This is BootApplicationRunner...");
    }
}
