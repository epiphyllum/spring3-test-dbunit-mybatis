package com.github.demo.model;

import java.util.Date;

public class UserModel {
    private Integer id;

    /**
    * 用户名称
    */
    private String userName;

    /**
    * 用户密码
    */
    private String password;

    /**
    * 年龄
    */
    private Integer age;

    /**
    * 创建时间
    */
    private Date createDatetime;

    /**
    * 更新时间
    */
    private Date updateDatetime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}