package com.example.wangwenjun.eventdriven.demo;

/**
 * @ClassName UserOfflineEvent
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午8:31
 * @Version V1.0
 */
public class UserOfflineEvent extends UserOnlineEvent {
    public UserOfflineEvent(User user) {
        super(user);
    }
}
