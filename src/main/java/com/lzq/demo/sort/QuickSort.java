package com.lzq.demo.sort;

import com.lzq.demo.sort.util.SortUtils;

/**
 * @Author: zq_leng
 * @Description: 快速排序
 * @Time: 16:10 2021/1/26
 */
public class QuickSort {
//    public static void main(String[] args) {
//        int[] arr = {1,3,5,7,2,4,6,8,10};
//        //调用排序
//        sort(arr,0,arr.length-1);
////        //第二次调用
////        sort(arr,0,arr.length-1);
////        //第三次调用
////        sort(arr,0,arr.length-1);
//        //打印排序后数据
//        SortUtils.print(arr);
//    }

    public static void sort(int[] arr,int left,int right){
        if(left==right)return;
        int mid = left+(right-left)/2;
        //左边
        compare(arr,left,mid);
        compare(arr,mid+1,right);
    }

    static void compare(int[] arr,int left,int right){
        int mid = left+(right-left)/2;
        int i = left;
        int j = right;
        while (i<mid&&j>=mid){
            if(arr[i]>arr[mid]&&arr[j]<arr[i]){
                SortUtils.swap(arr,i++,j--);
            }else{
                if(arr[i]<=arr[mid]){
                    i++;
                }
                if(arr[j]>=arr[j]){
                    j--;
                }
            }
        }
        //剩余数据处理
        if(i<mid){
            SortUtils.swap(arr,i,mid);
        }
        if(j>mid){
            SortUtils.swap(arr,j,mid);
        }
    }
}
