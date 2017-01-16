package com.xhlu.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * <pre>
 *   评论
 *
 * </pre>
 * <p>
 * Created by luxiaohu at 2017/1/11 21:58
 */
@Entity
public class Comment {

    @Id
    @GeneratedValue
    private Long id;
    private Long uidA; //评论方
    private Long uidB;//被评论方
    private Long wbId;//被评论的微博ID
    private String time;//评论时间
    private Integer hd;//评论互动次数（相互回复的次数）

    public Comment() {
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

    public Integer getHd() {
        return hd;
    }

    public void setHd(Integer hd) {
        this.hd = hd;
    }
}
