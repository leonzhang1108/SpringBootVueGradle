package com.leon.domain;

import java.io.Serializable;

/**
 * Author: jianliangzhang
 * Date: 2017/11/24
 * Time: 19:18
 */
public class User implements Serializable{
    private String id;
    private String userName;
    private String age;
    private String sex;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
