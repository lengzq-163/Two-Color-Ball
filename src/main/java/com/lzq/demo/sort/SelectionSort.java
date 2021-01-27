package com.lzq.demo.sort;

import com.lzq.demo.sort.util.SortUtils;

/**
 * @Author: zq_leng
 * @Description: 选择排序
 * @Time: 11:48 2021/1/21
 */
public class SelectionSort {
    public static void main(String[] args) {
        //创建数组
        int[] arr = {3,1,5,7,4,9,6,8,2};

        //第一次查找最小值位置
        int minPos = 0;
        for(int i=0;i<arr.length-1;i++) {
            minPos = i;
            for (int j= i+1; j < arr.length; j++) {
//                if (arr[j] < arr[minPos]) {
//                    minPos = j;
//                }
                minPos = arr[j]<arr[minPos]?j:minPos;
            }
            System.out.println("第"+(i+1)+"次循环,最小值位置:"+minPos);
            //数据交换
            swap(arr,i,minPos);
        }
        //打印数组
        SortUtils.print(arr);
    }
    static void swap(int[] arr,int i,int j){
        //交换最小值与第i个位置数据位置
        int temp = arr[i];
        arr[i]=arr[j];
        arr[j] = temp;
    }
}
