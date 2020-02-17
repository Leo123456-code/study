package com.study.imooc.runner;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 設置開機啟動
 * created by Leo徐忠春
 * created Time 2020/2/16-22:56
 * email 1437665365@qq.com
 */
//優先執行 order(1)
@Order(1)
@Component
@Slf4j
public class BootCommandLineRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        log.info("This is BootCommandLineRunner...");
    }
}
