package com.lzq.demo.sort;

import com.lzq.demo.entity.Student;
import com.lzq.demo.sort.util.SortUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @Author: zq_leng
 * @Description: 插入排序
 * @Time: 11:50 2021/1/22
 */
public class InsertionSort {
    public static void main(String[] args) {
//        int[] arr = {3,1,5,7,4,9,6,8,2};
//        int[] arr = {1,2,3,4,5,6,7,8,9};
//        //单步冒泡
//        sort(arr);
//        //排序后数组
//        print(arr);

//        long startTime = System.currentTimeMillis();
//        //验证方法准确性,耗时383秒
//        check();
//        long endTime = System.currentTimeMillis();
//        System.out.println("插入排序验证耗时:"+((endTime-startTime)/1000));
        //插入排序稳定性验证
        validInstability();
    }

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
            sort(students);
            //获取排序后相同年龄学生集合
            Map<Integer, List<Student>> sortOfterMap = SortUtils.getSameStudents(students);
            //验证稳定性
            flag=SortUtils.validSelectionInstability(sortBeforeMap,sortOfterMap);
            validCount++;
        }
        System.out.println("插入排序的稳定性:"+(flag?"稳定":"不稳定"));
    }

    static void check() {
        boolean flag = true;
        int count = 0;
        //执行10000次排序和比较
        while (count < 10000 && flag){
            int[] arr = new int[10000];
            Random random = new Random();
            for (int i=0;i<10000;i++){
                arr[i] = random.nextInt(10);
            }
            //复制数组
            int[] arrCopy = new int[10000];
            //复制
            System.arraycopy(arr,0,arrCopy,0,arr.length);
            //排序
            sort(arr);
            //系统排序
            Arrays.sort(arrCopy);
            for (int i = 0; i < arr.length;i++) {
                if(arr[i]!=arrCopy[i]) {
                    flag = false;
                    break;
                }
            }
            count++;
            System.out.println("第"+count+"次比较");
        }
        System.out.println("该插入排序方法编写:"+(flag?"成功":"失败"));
    }

    /**
     * 插入排序
     */
    public static void sort(int[] arr){
//        int circleCount = 0;
        for(int i=1;i<arr.length;i++){
            //交换
//            for(int j=i;j>0;j--){
//                if(arr[j]<arr[j-1]){
//                    swap(arr,j,j-1);
//                }
//            }
            //移位
//            int temp = arr[i];
//            int pos = i;
//            for(int j=i-1;j>=0;j--){
//                if(arr[j]>temp) {
//                    arr[j + 1] = arr[j];
//                    pos = j;
//                }else {
//                    break;
//                }
//            }
//            arr[pos]=temp;
            //优化当与数组有序,时间复杂度可以达到O(n)
            //逻辑说明,当前位置的数据比它上一个位置数据大时,当前数据不移动(交换),所以有序数组就只需要执行外部循环即可
            if(arr[i]<arr[i-1]) {
                for (int j = i; j > 0; j--) {
                    if (arr[j] < arr[j - 1]) {
                        swap(arr, j, j - 1);
                    }
//                    circleCount++;
                }
            }else {
//                circleCount++;
            }
        }
//        System.out.println("排序循环次数: "+circleCount+"次");
    }

    /**
     * 插入排序
     */
    static void sort(Student[] arr){
//        int circleCount = 0;
        for(int i=1;i<arr.length;i++){
            //优化当与数组有序,时间复杂度可以达到O(n)
            //逻辑说明,当前位置的数据比它上一个位置数据大时,当前数据不移动(交换),所以有序数组就只需要执行外部循环即可
            if(arr[i].getAge()<arr[i-1].getAge()) {
                for (int j = i; j > 0; j--) {
                    if (arr[j].getAge() < arr[j - 1].getAge()) {
                        SortUtils.swap(arr, j, j - 1);
                    }
//                    circleCount++;
                }
            }else {
//                circleCount++;
            }
        }
//        System.out.println("排序循环次数: "+circleCount+"次");
    }

    /**
     * 数据交换
     * @param arr 数组
     * @param i 源索引
     * @param j 目标索引
     */
    static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    static void print(int[] arr){
        for(int i :arr){
            System.out.print(i+"\t");
        }
    }
}
