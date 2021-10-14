package com.example.wangwenjun.eventdriven.demo;

import com.example.wangwenjun.eventdriven.Event;

/**
 * @ClassName UserOnlineEvent
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午8:29
 * @Version V1.0
 */
public class UserOnlineEvent extends Event {

    private final User user;

    public UserOnlineEvent(User user){
        this.user = user;
    }

    public User getUser(){
        return this.user;
    }

}
