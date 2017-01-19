package com.xhlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 *   用户实体
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/11 21:34
 */
@Entity
@Table(name = "wb_user")
public class User {

    @Id
    private Long uid;
    private String userName; //昵称
    private String gender; //性别
    private Integer age; //年纪
    private String xl; //学历
    private String school; //学校
    private String schoolTime; //入学时间
    private String address;//所在地
    private String tag;//标签
    private String type;//用户类型(普通用户 微博会员  个人认证 官方认证 多媒体 )
    private String client;//登陆客户端
    private Integer wb;//微博数量
    private Integer gz;//关注数量
    private Integer fs;//粉丝数量

    public User() {
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getXl() {
        return xl;
    }

    public void setXl(String xl) {
        this.xl = xl;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getSchoolTime() {
        return schoolTime;
    }

    public void setSchoolTime(String schoolTime) {
        this.schoolTime = schoolTime;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public Integer getWb() {
        return wb;
    }

    public void setWb(Integer wb) {
        this.wb = wb;
    }

    public Integer getGz() {
        return gz;
    }

    public void setGz(Integer gz) {
        this.gz = gz;
    }

    public Integer getFs() {
        return fs;
    }

    public void setFs(Integer fs) {
        this.fs = fs;
    }
}
