package com.lzq.demo.sort;

import com.lzq.demo.entity.Student;
import com.lzq.demo.sort.util.SortUtils;

import java.util.*;

import static com.lzq.demo.sort.SelectionSort.swap;

/**
 * @Author: zq_leng
 * @Description: 选择排序优化
 * 思路:查找最大值和最小值
 * @Time: 13:25 2021/1/21
 */
public class SelectionSortOptimization {
//    public static void main(String[] args) {
//        //创建数组
////        int[] arr = new int[10000];
////        for(int i=0;i<10000;i++){
////            arr[i] = (int) ((Math.random() * 10000) + 1);
////        }
////        validArr(arr);
//        //选择排序稳定性测试
//
//        validInstability();
//    }

    /**
     * 排序稳定性验证
     */
    static void validInstability() {
        //标识
        boolean flag = true;
        //验证次数
        int validCount = 0;
        //循环验证
        while (validCount<100&&flag){
            //创建学生对象数组
            Student[] students = SortUtils.createStudentArray(100);
            //获取排序前相同年龄学生集合
            Map<Integer, List<Student>> sortBeforeMap = SortUtils.getSameStudents(students);
            //排序
            sort3(students);
            //获取排序后相同年龄学生集合
            Map<Integer, List<Student>> sortOfterMap = SortUtils.getSameStudents(students);
            //验证稳定性
            flag=SortUtils.validSelectionInstability(sortBeforeMap,sortOfterMap);
            validCount++;
        }
        System.out.println("插入排序的稳定性:"+(flag?"稳定":"不稳定"));
    }

    /**
     * 优化算法1
     * 每次循环查找一个最大值和一个最小值
     * @param arr
     */
    public static void sort(int[] arr){
        //声明变量
        int minPos=0,maxPos=0;
        for(int i=0;i<arr.length-i-1;i++){
            minPos = i;
            maxPos = arr.length-1-i;
            //判断是否中断循环
            if(minPos>=maxPos){
                break;
            }
            //当默认最大值小于默认最小值时,先做一次交换
            if(arr[minPos]>arr[maxPos]){
                swap(arr,minPos,maxPos);
            }
            for(int j=i+1;j<arr.length-i-1;j++){
                minPos=arr[j]<arr[minPos]?j:minPos;
                maxPos=arr[j]>arr[maxPos]?j:maxPos;
            }
            //交换最小值位置
            swap(arr,i,minPos);
            //交换最大值位置
            swap(arr,arr.length-1-i,maxPos);
        }
    }

    /**
     * 优化算法2
     * 每次循环比较索引后连续的两数
     * @param arr
     */
    static void sort2(int[] arr){
        //声明变量
        int minPos=0;
        for(int i=0;i<arr.length-1;i++){
            minPos = i;
            for(int j=i+1;j<arr.length;j+=2){
                if(j+1<arr.length) {
                    minPos = arr[j] < arr[minPos] ? j : minPos;
                    minPos = arr[j+1] < arr[minPos] ? j+1 : minPos;
                }
            }
            //交换最小值位置
            swap(arr,i,minPos);
        }
    }

    static void validArr(int[] arr) {
        boolean flag = true;
        //一次验证
//        for(int i=0;i<arr.length-1;i++){
//            if(arr[i+1]-arr[i]<0){
//                flag = true;
//                break;
//            }
//        }
//        System.out.println("排序算法编写"+(flag?"成功":"失败"));
        //使用系统方法验证
        //通过累计验证代码正确性,即测试万亿次,结果仍正确方为通过
        int count = 0;
        while (count<10000&&flag){
            //1.拷贝一份
            int[] arrCopy = new int[arr.length];
            //拷贝数据
            System.arraycopy(arr, 0, arrCopy, 0, arr.length);
            //排序
            sort(arr);
            //系统方法排序
            Arrays.sort(arrCopy);
            //验证排序后结果是否相同
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != arrCopy[i])
                    flag = false;
            }
            count++;
            System.out.println("第"+(count)+"次");
        }
        System.out.println("排序算法编写"+(flag&&count==10000?"成功":"失败"));
    }

    static void sort3(Student[] students){
        int minPos = 0;
        for(int i=0;i<students.length-1;i++) {
            minPos = i;
            for (int j= i+1; j < students.length; j++) {
                minPos = students[j].compareTo(students[minPos])==-1?j:minPos;
            }
            //数据交换
            swapStudents(students,i,minPos);
        }
    }

    static void swapStudents(Student[] students,int i,int j){
        Student temp = students[i];
        students[i]=students[j];
        students[j]=temp;
    }
}
