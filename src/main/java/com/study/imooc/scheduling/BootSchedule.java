package com.study.imooc.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *  定时任务类
 * created by Leo徐忠春
 * created Time 2020/2/16-21:06
 * email 1437665365@qq.com
 */
@Slf4j
//@Component
public class BootSchedule {
    private final DateTimeFormatter fmt=
            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /**
     * 上一次开始执行之后3000毫秒再次执行（3s)
     * 固定3秒执行一次
     */
    @Scheduled(fixedRate = 3000)
    //定时任务开启
    public void schedule01(){
        log.info("schedule->{}", LocalDateTime.now().format(fmt));
    }

    /**
     * 上一次执行完毕时间点之后3秒再执行
     */
    @Scheduled(fixedDelay = 3000)
    public void schedule02(){
        log.info("schedule02->{}", LocalDateTime.now().format(fmt));
    }
    /**
     * 第一次延迟2s之后执行,之后按照每3s执行一次
     */
    @Scheduled(initialDelay = 2000,fixedRate = 3000)
    public void schedule03(){
        log.info("schedule03->{}", LocalDateTime.now().format(fmt));
    }
    /**
     * 每3秒执行一次
     */
    @Scheduled(cron = "*/3 * * * * ?")
    public void schedule04(){
        log.info("schedule04->{}", LocalDateTime.now().format(fmt));
    }

}
