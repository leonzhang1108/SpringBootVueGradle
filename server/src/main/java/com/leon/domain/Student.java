package com.leon.domain;

import java.io.Serializable;

/**
 * Author: jianliangzhang
 * Date: 2017/11/24
 * Time: 19:18
 */
public class Student implements Serializable{
    private int id;
    private String name;
    private String age;
    private String sex;

    private ClassInSchool classInSchool;

    public ClassInSchool getClassInSchool() {
        return classInSchool;
    }

    public void setClassInSchool(ClassInSchool classInSchool) {
        this.classInSchool = classInSchool;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
