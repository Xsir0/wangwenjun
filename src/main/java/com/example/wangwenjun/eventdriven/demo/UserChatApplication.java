package com.example.wangwenjun.eventdriven.demo;

import com.example.wangwenjun.eventdriven.AsyncEventDispatcher;

/**
 * @ClassName UserChatApplication
 * @Description
 * @Author xsir
 * @Date 2021/10/15 上午6:46
 * @Version V1.0
 */
public class UserChatApplication {

    public static void main(String[] args) {
        final AsyncEventDispatcher dispatcher = new AsyncEventDispatcher();

        dispatcher.registerChannel(UserOnlineEvent.class,new UserOnlineEventChannel());
        dispatcher.registerChannel(UserOfflineEvent.class,new UserOfflineEventChannel());
        dispatcher.registerChannel(UserChatEvent.class,new UserChatEventChannel());

        new UserChatThread(new User("Leo"),dispatcher).start();;
        new UserChatThread(new User("Alex"),dispatcher).start();;
        new UserChatThread(new User("Tina"),dispatcher).start();;
    }

}
