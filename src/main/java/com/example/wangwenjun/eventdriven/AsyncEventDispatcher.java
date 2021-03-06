package com.example.wangwenjun.eventdriven;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName AsyncEventDispatcher
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午6:57
 * @Version V1.0
 */
public class AsyncEventDispatcher implements DynamicRouter<Event> {

    private final Map<Class<? extends Event>,AsyncChannel> routerTable;

    public AsyncEventDispatcher(){
        this.routerTable = new ConcurrentHashMap<>();
    }


    @Override
    public void registerChannel(Class<? extends Event> messageType, Channel<? extends Event> channel) {
        if (!(channel instanceof AsyncChannel)){
            throw new IllegalArgumentException("The channel must be AsyncChannel Type.");
        }
        this.routerTable.put(messageType, (AsyncChannel) channel);
    }

    @Override
    public void dispatch(Event message) {
        if (routerTable.containsKey(message.getType())){
            routerTable.get(message.getType()).dispatch(message);
        }else {
            throw new MessageMatcherException("Can't match the channel for [ "+message.getType()+"] type");
        }
    }

    public void shutdown(){
        routerTable.values().forEach(AsyncChannel::stop);
    }

}
