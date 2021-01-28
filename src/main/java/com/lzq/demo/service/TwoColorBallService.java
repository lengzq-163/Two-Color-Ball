package com.lzq.demo.service;

import com.lzq.demo.entity.TwoColorBall;

import java.util.List;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 10:40 2021/1/28
 */
public interface TwoColorBallService {
    /**
     * 插入数据
     * @return
     */
    String save();

    /**
     * 查询数据
     * @return
     */
    List<TwoColorBall> load();

    /**
     * 获取最新期数
     * @return
     */
    String get();
}
