package com.example.wangwenjun.eventbus;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName AsyncEventBus
 * @Description
 * @Author xsir
 * @Date 2021/10/12 上午8:18
 * @Version V1.0
 */
public class AsyncEventBus extends EventBus {

    AsyncEventBus(String busName, EventExceptionHandler eventExceptionHandler, ThreadPoolExecutor executor){
        super(busName,eventExceptionHandler,executor);
    }

    public AsyncEventBus(String busName,ThreadPoolExecutor executor){
        this(busName,null,executor);
    }

    public AsyncEventBus(ThreadPoolExecutor executor){
        this("default-async",null,executor);
    }

    public AsyncEventBus(EventExceptionHandler eventExceptionHandler,ThreadPoolExecutor executor){
        this("default-async",eventExceptionHandler,executor);
    }

}
