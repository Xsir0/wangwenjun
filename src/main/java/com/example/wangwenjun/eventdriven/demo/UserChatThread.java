package com.example.wangwenjun.eventdriven.demo;

import com.example.wangwenjun.eventdriven.AsyncEventDispatcher;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName UserChatThread
 * @Description
 * @Author xsir
 * @Date 2021/10/15 上午6:32
 * @Version V1.0
 */
public class UserChatThread extends Thread {

    private final User user;

    private final AsyncEventDispatcher dispatcher;

    public UserChatThread(User user,AsyncEventDispatcher dispatcher){
        super(user.getName());
        this.user = user;
        this.dispatcher = dispatcher;
    }

    @Override
    public void run() {
        try {
            dispatcher.dispatch(new UserOnlineEvent(user));
            for (int i = 0; i < 5; i++) {
                 dispatcher.dispatch(new UserChatEvent(user,getName()+"-Hello-"+i));
                TimeUnit.SECONDS.sleep(1);
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            dispatcher.dispatch(new UserOfflineEvent(user));
        }
    }
}
