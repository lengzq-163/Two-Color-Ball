package com.lzq.demo.service.impl;

import com.lzq.demo.entity.TwoColorBall;
import com.lzq.demo.mapper.TwoColorBallMapper;
import com.lzq.demo.service.TwoColorBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 10:40 2021/1/28
 */
@Service("twoColorBallServiceImpl")
public class TwoColorBallServiceImpl implements TwoColorBallService {
    @Autowired
    private TwoColorBallMapper twoColorBallMapper;

    @Override
    public String save() {
        List<TwoColorBall> list = new ArrayList<TwoColorBall>();
        list.add(new TwoColorBall("21012","12","1,3,5,7,8,4","四","2021-01-28"));
        try {
            twoColorBallMapper.batchInsert(list);
        }catch (Exception e){
            e.printStackTrace();
            return "插入失败";
        }
        return "插入成功";
    }

    @Override
    public List<TwoColorBall> load() {
        return twoColorBallMapper.selectData(0,10);
    }

    @Override
    public String get() {
        return twoColorBallMapper.getNewestPeriods();
    }
}
