package com.xhlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <pre>
 *   转发
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/11 22:03
 */
@Entity
public class Zf {

    @Id
    @GeneratedValue
    private Long id;
    private Long uidA; //转发人
    private Long uidB;//被转发人
    private Long wbId;//被转发的微博ID
    private String time;//转发时间

    public Zf() {
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

    public Long getWbId() {
        return wbId;
    }

    public void setWbId(Long wbId) {
        this.wbId = wbId;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
