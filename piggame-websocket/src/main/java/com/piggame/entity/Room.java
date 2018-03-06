package com.piggame.entity;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author:zhujie
 * @Date: Create in 16:15 2018/3/2
 **/
public class Room {

    //房间ID
    private Long id;

    //房间成员
    private List<User> users = new ArrayList<User>();

    //房间状态0:准备,1:开始,3:结束
    private int status;

    //正在画画的用户ID
    private String userId;

    //创建者ID
    private String ownerId;

    //倒计时
    private Long time = 60*1000L;

    //轮数
    private int times = 2;

    public void joinRoom(User user){
        this.users.add(user);
    }

    public User getUser(Long id){
        for (User user : this.users){
            if(user.getId().longValue() == id){
                return user;
            }
        }
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }
}
