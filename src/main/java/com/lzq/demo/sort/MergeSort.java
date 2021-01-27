package com.lzq.demo.sort;

import com.lzq.demo.sort.util.SortUtils;

import java.util.Random;

/**
 * @Author: zq_leng
 * @Description: 归并排序
 * @Time: 10:20 2021/1/26
 */
public class MergeSort {
    public static void main(String[] args) {
        //初始:给定一个指定数组,前后两段已经排好序
//        int[] arr = {1,3,5,7,2,4,6,8,10};
        int[] arr = new int[100];
        Random random = new Random();
        for (int i=0;i<arr.length;i++){
            arr[i] = random.nextInt(10);
        }
//        //全数组排序
//        //排序
//        arr = sort(arr);
//        //打印结果
//        SortUtils.print(arr);
        //部分数组排序
//        merge(arr,3,3,3);
        //调用排序
//        sort(arr,0,arr.length-1);
//        //打印排序后数组
//        SortUtils.print(arr);
        //排序验证
        SortUtils.check();
    }

    /**
     * 归并排序(递归)
     * @param arr 数组
     * @param left 左边界索引
     * @param right 右边界索引
     */
    public static void sort(int[] arr,int left,int right){
        //设置递归返回条件,必须,否则StackOverflowError,栈溢出错误
        if(left==right)return;
        //获取中间值
        //注:left+(right-left)/2这样编写可以防止超出整型边界,
        // 因为(left+right)/2,当left和right足够大时,两数之和会超出整型最大值
        int mid = left+(right-left)/2;
        //左边排序
        sort(arr,left,mid);
        //右边排序
        sort(arr,mid+1,right);
        //合并左右
        merge(arr,left,mid+1,right);
    }

    /**
     * 合并
     * @param arr
     */
    static int[] merge(int[] arr){
        //新开辟一个等长数组空间
        int[] temp = new int[arr.length];
        //归并索引
        //左边界索引
        int i = 0;
        //数组中间索引
        int mid = arr.length/2;
        //左排序数组右边界索引
        int j = mid;
        //新数组起始索引
        int k = 0;
        //循环比较左右两个小数组中值大小
//        while (i<mid&&j<arr.length){
//            //这里需要等于,以保证排序稳定性,即:相等的数按照原数组顺序放入排序后新数组中
//            if(arr[i]<=arr[j]){
//                temp[k] = arr[i];
//                i++;
//                k++;
//            }else {
//                temp[k] = arr[j];
//                j++;
//                k++;
//            }
//        }
//        //处理两个小数组中剩余元素
//        while (i<mid){
//            temp[k] = arr[i];
//            i++;
//            k++;
//        }
//        while (j<arr.length){
//            temp[k] = arr[j];
//            j++;
//            k++;
//        }
        //优化代码
        while (i<mid&&j<arr.length){
//            if(arr[i]<=arr[j]){
//                temp[k++]=arr[i++];
//            }else {
//                temp[k++]=arr[j++];
//            }
            //优化
            temp[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
        }
        while (i<mid)temp[k++]=arr[i++];
        while (j<arr.length)temp[k++]=arr[j++];
        //将原数组地址指向新数组
        return temp;
    }

    /**
     * 合并数组
     * @param arr 原数组
     * @param leftPrt 左边数组起始索引
     * @param rightPrt 右边数组起始索引
     * @param rightBound 排序元素右边界
     */
    static void merge(int[] arr,int leftPrt,int rightPrt,int rightBound){
        //新数组
        int[] temp = new int[rightBound-leftPrt+1];
        //起始位置
        int i = leftPrt;
        int j = rightPrt;
        int k = 0;
        while (i<rightPrt&&j<=rightBound){
            temp[k++]=arr[i]<=arr[j]?arr[i++]:arr[j++];
        }
        //剩余元素处理
        while (i<rightPrt)temp[k++]=arr[i++];
        while (j<=rightBound) temp[k++]=arr[j++];
        //打印数组
//        SortUtils.print(temp);
        //将合并后数组放入原数组中
        for(int m=0;m<temp.length;m++){
            arr[leftPrt+m]=temp[m];
        }
    }
}
