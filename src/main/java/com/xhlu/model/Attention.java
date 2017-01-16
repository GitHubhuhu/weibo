package com.xhlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <pre>
 *   关注表
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/11 21:53
 */
@Entity
public class Attention {


    @Id
    @GeneratedValue
    private Long id;
    private Long uidA;
    private Long uidB;//关注的人
    private String time;//关注时间

    public Attention() {
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

