package com.lzq.demo.entity;

import java.util.Date;

/**
 * @Author: zq_leng
 * @Description: 双色球
 * @Time: 12:05 2021/1/27
 */
public class TwoColorBall {
    /**
     * 主键id
     */
    private Long id;
    /**
     * 期数
     */
    private String code;
    /**
     * 蓝球
     */
    private String blue;
    /**
     * 红球
     */
    private String red;
    /**
     * 星期
     */
    private String week;
    /**
     * 日期
     */
    private String date;
    /**
     * 插入时间
     */
    private Date insertTime;
    public TwoColorBall() {
    }

    public TwoColorBall(String code, String blue, String red, String week,String date) {
        this.code = code;
        this.blue = blue;
        this.red = red;
        this.week = week;
        this.date = date;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBlue() {
        return blue;
    }

    public void setBlue(String blue) {
        this.blue = blue;
    }

    public String getRed() {
        return red;
    }

    public void setRed(String red) {
        this.red = red;
    }

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    @Override
    public String toString() {
        return "TwoColorBall{" +
                "code='" + code + '\'' +
                ", blue='" + blue + '\'' +
                ", red='" + red + '\'' +
                ", week='" + week + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
