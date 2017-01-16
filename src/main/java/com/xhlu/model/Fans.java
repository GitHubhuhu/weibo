package com.xhlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <pre>
 *   粉丝表
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/11 21:55
 */
@Entity
public class Fans {

    @Id
    @GeneratedValue
    private Long id;
    private Long uidA;
    private Long uidB;//粉丝
    private String time;//被关注时间

    public Fans() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUidA() {
        return uidA;
    }

    public void setUidA(Long uidA) {
        this.uidA = uidA;
    }

    public Long getUidB() {
        return uidB;
    }

    public void setUidB(Long uidB) {
        this.uidB = uidB;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}