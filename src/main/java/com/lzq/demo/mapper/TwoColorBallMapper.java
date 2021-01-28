package com.lzq.demo.mapper;

import com.lzq.demo.entity.TwoColorBall;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

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
    String getNewestPeriods();

    /**
     * 获取双色球列表
     * @param start 起始索引
     * @param length 数据长度
     * @return
     */
    List<TwoColorBall> selectData(@Param("start") int start, @Param("length") int length);
}
