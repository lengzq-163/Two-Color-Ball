package com.lzq.demo.controller;

import com.lzq.demo.entity.TwoColorBall;
import com.lzq.demo.service.TwoColorBallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 10:36 2021/1/28
 */
@RestController
@RequestMapping("/twoColorBall")
public class TwoColorBallController {
    @Autowired
    private TwoColorBallService twoColorBallService;

    @RequestMapping("/save")
    public String save(){
        return twoColorBallService.save();
    }

    @RequestMapping("/load")
    public List<TwoColorBall> load(){
        return twoColorBallService.load();
    }

    @RequestMapping("/get")
    public String get(){
        return twoColorBallService.get();
    }
}
