package com.lzq.demo.day01;


/**
 * @Author: zq_leng
 * @Description: Lambda示例
 * @Time: 15:35 2021/1/11
 */
public class LambdaDemo01 {

    public static void main(String[] args) {
//        done01(()->{
//            System.out.println("测试Lambda");
//        });
        done01("上海", System.out::println);

    }

    public static void done01(String str,LambdaInterface lambdaInterface){
//        lambdaInterface.ceshi01();
        lambdaInterface.ceshi02(str);
    }

//    public static void done02(LambdaInterface lambdaInterface){
//        lambdaInterface.ceshi02("测试");
//    }
}
