package com.lzq.demo.quartz;

import com.lzq.demo.entity.TwoColorBall;
import com.lzq.demo.mapper.TwoColorBallMapper;
import com.lzq.demo.util.TwoColorBallUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import java.util.List;

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
    @Scheduled(cron = "0 30 21 ? * SUN,TUE,THU")
    public void history() throws RuntimeException {
        //获取网页最新期数
        String newestPeriodsHtml = TwoColorBallUtil.getNewestPeriods();
        //获取数据库中最新期数
        String newestPeriodsDatabase = twoColorBallMapper.getNewestPeriods();
        if(StringUtils.isEmpty(newestPeriodsHtml)){
            return;
        }
        if(newestPeriodsHtml.equals(newestPeriodsDatabase)){
            return;
        }
        //获取数据,存入数据库
        List<TwoColorBall> list = TwoColorBallUtil.getDataFrom500(newestPeriodsDatabase==null?"03001":newestPeriodsDatabase,newestPeriodsHtml);
        if(list.size()>0){
            twoColorBallMapper.batchInsert(list);
        }
    }
}
