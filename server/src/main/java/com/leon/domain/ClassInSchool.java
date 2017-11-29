package com.leon.domain;

import com.leon.base.domain.BaseResponse;

import java.io.Serializable;

/**
 * Author: jianliangzhang
 * Date: 2017/11/28
 * Time: 16:12
 */
public class ClassInSchool implements Serializable {
    private int id;
    private String teacher;
    private String classNo;
    private int floor;

    public int getId() {
        return id;
    }

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTeacher() {
        return teacher;
    }

    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

}
