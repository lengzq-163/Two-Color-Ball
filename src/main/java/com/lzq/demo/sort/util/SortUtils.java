package com.lzq.demo.sort.util;

import com.lzq.demo.entity.Student;
import com.lzq.demo.sort.*;

import java.util.*;

/**
 * @Author: zq_leng
 * @Description: 排序工具类
 * @Time: 15:31 2021/1/22
 */
public class SortUtils {
    /**
     * 交换数组元素
     * @param arr 数组
     * @param i 源索引
     * @param j 目标索引
     */
    public static void swap(Student[] arr, int i, int j) {
        Student temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 获取具有相同的年龄学生集合
     * @param students
     * @return
     */
    public static Map<Integer, List<Student>> getSameStudents(Student[] students){
        Map<Integer,List<Student>> map = new HashMap<Integer, List<Student>>();
        for(Student stu:students){
            if(contains(students,stu)){
                List<Student> list = map.get(stu.getAge());
                if(list==null){
                    list = new ArrayList<Student>();
                }
                list.add(stu);
                map.put(stu.getAge(),list);
            }
        }
        return map;
    }

    /**
     * 判断数组中是否包含与指定学生相同年龄的学生
     * @param students
     * @param student
     * @return
     */
    private static boolean contains(Student[] students,Student student){
        for(Student stu:students){
            if(stu.compareTo(student)==0)
                return true;
        }
        return false;
    }

    /**
     * 证明选择排序不稳定性
     * 通过Student的年龄进行排序,
     * 然后根据排序前和排序后,相同年龄的人在数组中相对位置的变化验证选择排序不稳定
     */
    public static boolean validSelectionInstability(Map<Integer,List<Student>> sortBefore,Map<Integer,List<Student>> sortOfter){
        Set<Integer> integers = sortBefore.keySet();
        for(Integer age:integers){
            List<Student> sortBeforeList = sortBefore.get(age);
            //遍历排序前相同年龄数组
            System.out.println("排序前年龄为"+age+"岁的学生是:"+sortBeforeList);
            List<Student> sortOfterList = sortOfter.get(age);
            //遍历排序后相同年龄数组
            System.out.println("排序后年龄为"+age+"岁的学生是:"+sortOfterList);
            for(int i=0;i<sortBeforeList.size();i++){
                if(!sortBeforeList.get(i).equals(sortOfterList.get(i))){
                    return false;
                }
            }
        }
        return true;
    }

    public static Student[] createStudentArray(int length){
        Student[] students = new Student[length];
        //创建随机对象
        Random random = new Random();
        for (int i=0;i<length;i++){
            students[i] = new Student("name"+i,random.nextInt(20));
        }
        return students;
    }

    /**
     * 交换
     * @param arr
     * @param i
     * @param j
     */
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 打印数组
     * @param arr
     */
    public static void print(int[] arr){
        for(int i:arr){
            System.out.print(i+" ");
        }
    }

    public static void check(){
        boolean flag = true;
        int count = 0;
        //执行10000次排序和比较
        while (count < 10000 && flag){
            int[] arr = new int[100];
            Random random = new Random();
            for (int i=0;i<arr.length;i++){
                arr[i] = random.nextInt(10);
            }
            //复制数组
            int[] arrCopy = new int[arr.length];
            //复制
            System.arraycopy(arr,0,arrCopy,0,arr.length);
            //排序
            //选择排序验证
//            SelectionSortOptimization.sort(arr);
//            //冒泡排序验证
//            BubbleSort.sort(arr);
//            //插入排序验证
//            InsertionSort.sort(arr);
//            //希尔排序验证
//            ShellSort.sort(arr);
            //归并排序验证
            MergeSort.sort(arr,0,arr.length-1);
            //系统排序
            Arrays.sort(arrCopy);
            for (int i = 0; i < arr.length;i++) {
                if(arr[i]!=arrCopy[i]) {
                    flag = false;
                    break;
                }
            }
            count++;
//            System.out.println("第"+count+"次比较");
        }
        System.out.println("该插入排序方法编写:"+(flag?"成功":"失败"));
    }
}
