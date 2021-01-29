package com.lzq.demo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: zq_leng
 * @Description: 启动器
 * @Time: 13:58 2021/1/27
 */
@SpringBootApplication
@MapperScan(basePackages = "com.lzq.demo.mapper")
@EnableApolloConfig
@Slf4j
public class LearnDemoApplication {

    public static void main(String[] args) throws IOException {
        //读取application.properties获取编译后的active.env值
        Properties properties = new Properties();
        InputStream in = LearnDemoApplication.class.getClassLoader().getResourceAsStream("application.properties");
        properties.load(in);
        String env = properties.getProperty("profiles.active");
        //设置apollo启动环境
        System.setProperty("env", env);
        //设置apollo meta server
        switch (env.toUpperCase()){
            case "FAT":
                System.setProperty("apollo.meta","http://192.168.50.200:8081");
                break;
            case "UAT":
                System.setProperty("apollo.meta","http://192.168.50.200:8082");
                break;
            case "PRO":
                System.setProperty("apollo.meta","http://192.168.50.200:8083");
                break;
            default:
                System.setProperty("apollo.meta","http://192.168.50.200:8080");
                break;
        }
        log.info("SpringBoot Start Success, running environment is {}", env);
        SpringApplication.run(LearnDemoApplication.class,args);
    }
}
