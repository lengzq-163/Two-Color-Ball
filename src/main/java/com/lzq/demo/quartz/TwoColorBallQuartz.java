package com.lzq.demo.quartz;

import com.lzq.demo.mapper.TwoColorBallMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author: zq_leng
 * @Description: 双色球定时任务
 * @Time: 16:23 2021/1/27
 */
@Component
@Lazy(value = false)
public class TwoColorBallQuartz {
    @Autowired
    TwoColorBallMapper twoColorBallMapper;

    /**
     * 每周日,周二,周四晚上9点30执行
     */
    @Scheduled(cron = "0 30 21 ? *  SUN,TUE,THU")
    public void history(){

    }
}
