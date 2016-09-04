package com.github.demo.model;

import java.util.Date;

public class AddressModel {
    private Integer id;

    /**
    * 地址1
    */
    private String address;

    /**
    * 地址2
    */
    private String address2;

    /**
    * 手机号
    */
    private String phone;

    /**
    * 邮政编码
    */
    private String postalCode;

    /**
    * 创建时间
    */
    private Date createDatetime;

    /**
    * 更新时间
    */
    private Date updateDatetime;

    /**
    * 用户ID
    */
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}