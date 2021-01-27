package com.lzq.demo.day02;

import com.lzq.demo.entity.Student;

import java.util.*;

/**
 * @Author: zq_leng
 * @Description:
 * @Time: 17:07 2021/1/15
 */
public class ListDemo {
    public static void main(String[] args) {
        //创建集合对象
        List<String> list = new ArrayList<>();
        //向集合中添加元素
        list.add("周星驰");
        list.add("刘德华");
        list.add("伍佰");

        //遍历集合
        //ConcurrentModificationException
        //由于增强for采用迭代方式取数据,迭代中next()检验modeCount
        /*
        添加元素
        public boolean add(E e) {
            ensureCapacityInternal(size + 1);  // Increments modCount!!
            elementData[size++] = e;
            return true;
        }
        集合size增加
        private void ensureCapacityInternal(int minCapacity) {
            if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
                minCapacity = Math.max(DEFAULT_CAPACITY, minCapacity);
            }

            ensureExplicitCapacity(minCapacity);
        }
        集合扩容
        private void ensureExplicitCapacity(int minCapacity) {
            modCount++;//改变修改次数

            // overflow-conscious code
            if (minCapacity - elementData.length > 0)
                grow(minCapacity);
        }
        private class Itr implements Iterator<E> {
            //初始化预期修改次数
            int expectedModCount = modCount;//初始相同
        }
        public E next() {
            checkForComodification();
            int i = cursor;
            if (i >= size)
                throw new NoSuchElementException();
            Object[] elementData = ArrayList.this.elementData;
            if (i >= elementData.length)
                throw new ConcurrentModificationException();
            cursor = i + 1;
            return (E) elementData[lastRet = i];
        }
        //判断修改次数和预期修改次数是否相同
        final void checkForComodification() {
            if (modCount != expectedModCount)
                throw new ConcurrentModificationException();
        }*/
        //增强for循环处理
//        for(String name:list){
//            if("伍佰".equals(name)){
//                list.add("王晶");
//            }
//        }
        //迭代处理 1 ListIterator支持正序和逆序遍历
//        ListIterator<String> listIterator = list.listIterator();
//        //正序
//        while (listIterator.hasNext()){
//            String name = listIterator.next();
//            if("伍佰".equals(name)){
//                list.add("王晶");
//            }
//        }
        //逆序
//        while ((listIterator.hasPrevious())){
//            String name = listIterator.previous();
//            if("伍佰".equals(name)){
//                list.add("王晶");
//            }
//        }
        //迭代处理2
//        Iterator<String> listIterator = list.iterator();
//        while (listIterator.hasNext()){
//            String name = listIterator.next();
//            if("伍佰".equals(name)){
//                list.add("王晶");
//            }
//        }
        //一般for循环
//        for(int i=0;i<list.size();i++){
//            String name = list.get(i);
//            if("伍佰".equals(name)){
//                list.add("王晶");
//            }
//        }
        //打印集合
//        System.out.println(list);
        Set<Student> students = new HashSet<>();
        students.add(new Student("刘德华",30));
        students.add(new Student("房祖名",33));
        students.add(new Student("谢霆锋",30));
        //打印集合
        System.out.println(students);
    }
}
