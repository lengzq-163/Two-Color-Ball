package com.lzq.demo.sort;

import com.lzq.demo.entity.Student;
import com.lzq.demo.sort.util.SortUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: zq_leng
 * @Description:冒泡排序
 * @Time: 9:15 2021/1/22
 */
public class BubbleSort {

//    public static void main(String[] args) {
////        int[] arr = {3,1,5,7,4,9,6,8,2};
//        //有序列表,冒泡排序,时间复杂度O(n)
////        int[] arr = {1,2,3,4,5,6,7,8,9};
////        int[] arr = {9,8,7,6,5,4,3,2,1};
////        //单步冒泡
////        singleStepBubbleSort(arr);
////        //排序后数组
////        print(arr);
////        long startTime = System.currentTimeMillis();
////          //验证,耗时1112秒
////        check();
////        long endTime = System.currentTimeMillis();
////        System.out.println("验证冒泡排序耗时:"+((endTime-startTime)/1000));
//        //验证冒泡排序稳定性
//        validBubbleSortInstability();
//    }

    /**
     * 验证冒泡排序稳定性
     */
    static void validBubbleSortInstability(){
        boolean flag = true;
        int count = 0;
        while (count<100&&flag) {
            //创建学生集合
            Student[] students = SortUtils.createStudentArray(100);
            //获取排序前相同年龄学生集合
            Map<Integer, List<Student>> sortBeforeMap = SortUtils.getSameStudents(students);
            //排序
            sort(students);
            //获取排序后相同年龄学生集合
            Map<Integer, List<Student>> sortOfterMap = SortUtils.getSameStudents(students);
            flag = SortUtils.validSelectionInstability(sortBeforeMap, sortOfterMap);
            count++;
        }
        System.out.println("选择排序的稳定性:" + (flag ? "稳定" : "不稳定"));
    }

    /**
     * 单步冒泡
     */
    public static void sort(int[] arr){
        //边界问题,由于索引会出现i+1,所以i+1最大值arr.length-1,所以i最大能取到arr.length-2
//        for(int i=0;i<arr.length;i++) {
//            for (int j = 0; j < arr.length-1-i; j++) {
//                if(arr[j]>arr[j+1]){
//                    swap(arr,j,j+1);
//                }
//            }
//        }
        //索引倒序
//        for(int i=arr.length-1;i>0;i--){
//            findMax(arr,i);
//        }
        //优化排序,可能到达时间复杂度为O(n),即原数组有序,因排序方法和数组原有顺序冲突,造成最坏时间复杂度O(n^2)
        //交换标识,交换一次即变为true
        boolean swapped = false;
        //执行次数
        int count = 0;
        for(int i=arr.length-1;i>0;i--){
            for(int j=0;j<i;j++){
                if(arr[j]>arr[j+1]){
                    if(!swapped){
                        swapped=true;
                    }
                    SortUtils.swap(arr,j,j+1);
                }
                count++;
            }
            //若没有交换,则原数组有序,推出循环,即时间复杂度为O(n)
            if(!swapped){
                break;
            }
        }
//        System.out.println("冒泡排序对有序数组排序:比较"+count+"次");
    }

    static void findMax(int[] arr,int n){
        for(int j=0;j<n;j++){
            if(arr[j]>arr[j+1]){
                SortUtils.swap(arr,j,j+1);
            }
        }
    }

    static void sort(Student[] arr){
        //边界问题,由于索引会出现i+1,所以i+1最大值arr.length-1,所以i最大能取到arr.length-2
//        for(int i=0;i<arr.length;i++) {
//            for (int j = 0; j < arr.length-1-i; j++) {
//                if(arr[j].getAge()>arr[j+1].getAge()){
//                    swap(arr,j,j+1);
//                }
//            }
//        }
        for(int i=arr.length-1;i>0;i--) {
//            for (int j = 0; j < i; j++) {
//                if(arr[j].getAge()>arr[j+1].getAge()){
//                    swap(arr,j,j+1);
//                }
//            }
            findMax(arr,i);
        }
    }

    static void findMax(Student[] arr,int n){
        for(int j=0;j<n;j++){
            if(arr[j].getAge()>arr[j+1].getAge()){
                SortUtils.swap(arr,j,j+1);
            }
        }
    }
}
