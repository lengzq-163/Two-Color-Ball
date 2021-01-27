package com.lzq.demo.entity;

/**
 * @Author: zq_leng
 * @Description: 学生类
 * @Time: 11:49 2021/1/18
 */
public class Student implements Comparable<Student>{
    /**
     * 姓名
     */
    private String name;
    /**
     * 年龄
     */
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        return name != null ? name.equals(student.name) : student.name == null;
    }

    @Override
    public int hashCode() {
//        int result = name.hashCode();
        //        result = 31 * result + age;
        return age;
    }

    @Override
    public int compareTo(Student o) {
        if(this.age>o.age)return 1;
        else if(this.age<o.age)return -1;
        return this.name.equals(o.name)?-1:0;
    }

    /**
     * 取小值
     * @param o
     * @return
     */
    public boolean less(Student o) {
        if(this.age<o.age)return true;
        return false;
    }
}
