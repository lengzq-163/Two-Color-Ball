package com.lzq.demo.sort;

import com.lzq.demo.sort.util.SortUtils;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 15:06 2021/1/22
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = {3,1,5,7,4,9,6,8,2};
        //模拟排序
        //3,4,2
        //2,1,5,7,3,9,6,8,4
        //1,9
        //2,1,5,7,3,9,6,8,4
        //排序
//        sort(arr);
//        //打印排序结果
//        SortUtils.print(arr);
        //验证
        SortUtils.check();

    }
    public static void sort(int[] arr){
        //knuth求取希尔排序间隔h的值
        //默认值(最小值)
        int h=1;
        while (h<arr.length/3){
            h=h*3+1;
        }
//        System.out.println(h);
        //设置区间
        for(int grap=h;grap>0;grap=(grap-1)/3) {
            for (int i = grap; i < arr.length; i++) {
                //插入排序
                for (int j = i; j > grap - 1; j -= grap) {
                    if (arr[j] < arr[j - grap]) {
                        SortUtils.swap(arr, j, j - grap);
                    }
                }
            }
        }
    }
}
