package com.example.wangwenjun.eventdriven.demo;

import com.example.wangwenjun.eventdriven.AsyncChannel;
import com.example.wangwenjun.eventdriven.Event;

/**
 * @ClassName UserOnineEventChannel
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午8:32
 * @Version V1.0
 */
public class UserOnlineEventChannel extends AsyncChannel {
    @Override
    protected void handle(Event message) {
        UserOnlineEvent event = (UserOnlineEvent) message;
        System.out.println("The User["+event.getUser().getName()+"] is online. ");
    }
}