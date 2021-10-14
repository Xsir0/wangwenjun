package com.example.wangwenjun.eventdriven;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName EventDispatcher
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午6:11
 * @Version V1.0
 */
public class EventDispatcher implements DynamicRouter<Message> {

    private final Map<Class<? extends Message>,Channel> routerTable;

    public EventDispatcher(){
        this.routerTable = new HashMap<>();
    }

    @Override
    public void registerChannel(Class<? extends Message> messageType, Channel<? extends Message> channel) {
        this.routerTable.put(messageType,channel);
    }

    @Override
    public void dispatch(Message message) {
        if (routerTable.containsKey(message.getType())){
            routerTable.get(message.getType()).dispatch(message);
        }else {
            throw new MessageMatcherException("Can't match the channel for [ "+message.getType()+" ] type");
        }
    }
}
