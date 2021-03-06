package com.lzq.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Author: zq_leng
 * @Description: 启动器
 * @Time: 13:58 2021/1/27
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lzq.demo.mapper")
public class LearnDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(LearnDemoApplication.class,args);
    }
}
