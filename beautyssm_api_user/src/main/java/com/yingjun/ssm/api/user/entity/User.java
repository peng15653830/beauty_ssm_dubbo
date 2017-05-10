package com.yingjun.ssm.api.user.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;


/**
 * 用户
 *
 * @author yingjun
 */
public class User implements Serializable {


    private long id;

    private String name;

    private long phone;

    //这里展示了jackson封装好的以及自定义的对时间格式的转换方式
    //后续对于一些复杂的转换可以自定义转换方式
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gmtCreate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date gmtModified;

    private int score;

    private String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}
