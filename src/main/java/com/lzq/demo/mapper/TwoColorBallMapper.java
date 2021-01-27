package com.lzq.demo.mapper;

import com.lzq.demo.entity.TwoColorBall;

import java.util.List;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 16:02 2021/1/27
 */

public interface TwoColorBallMapper {
    /**
     * 批量插入数据
     * @param list 双色球开奖记录列表
     * @return
     */
    int batchInsert(List<TwoColorBall> list);

    /**
     * 获取数据最新日期
     * @return
     */
    String getLastDate();
}
