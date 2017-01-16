package com.xhlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <pre>
 *   被@的信息
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/11 22:15
 */
@Entity
public class Ate {
    @Id
    @GeneratedValue
    private Long id;
    private Long uidA; //@人
    private Long uidB;//被@人
    private Long wbId;//@相关微博ID
    private String time;//@时间

    public Ate() {
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
