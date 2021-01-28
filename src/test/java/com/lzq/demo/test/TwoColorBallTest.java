package com.lzq.demo.test;

import com.lzq.demo.LearnDemoApplication;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;


/**
 * @Author: zq_leng
 * @Description: 控制类-测试类
 * @Time: 11:04 2021/1/28
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = LearnDemoApplication.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TwoColorBallTest {
    @LocalServerPort
    private int port;

    private URL url;

    @Autowired
    private TestRestTemplate testRestTemplate;

    @Before
    public void setUp() throws MalformedURLException {
        String url = String.format("http://localhost:%d",port);
        System.out.println(String.format("port is %d",port));
        this.url = new URL(url);
    }

    @Test
    public void insert(){
        ResponseEntity<String> response = this.testRestTemplate.getForEntity(url.toString()+"/twoColorBall/save",String.class,"");
        System.out.println(String.format("测试结果为:%s",response.getBody()));
    }

    @Test
    public void select(){
        ResponseEntity<List> response = testRestTemplate.getForEntity(url.toString()+"/twoColorBall/load", List.class,"");
        System.out.println(String.format("测试结果为:%s",response.getBody()));
    }

    @Test
    public void get(){
        ResponseEntity<String> response = testRestTemplate.getForEntity(url.toString()+"/twoColorBall/get", String.class,"");
        System.out.println(String.format("测试结果为:%s",response.getBody()));
    }
}
