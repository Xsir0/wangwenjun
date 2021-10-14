package com.example.wangwenjun.eventdriven.demo;

/**
 * @ClassName UserChatEvent
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午8:31
 * @Version V1.0
 */
public class UserChatEvent extends UserOnlineEvent {

    private final String message;

    public UserChatEvent(User user,String message) {
        super(user);
        this.message = message;
    }

    public String getMessage(){
        return this.message;
    }


}
