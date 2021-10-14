package com.example.wangwenjun.eventdriven;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName AsyncChannel
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午6:51
 * @Version V1.0
 */
public abstract class AsyncChannel implements Channel<Event> {

    private final ExecutorService executorService;

    public AsyncChannel(){
        this(Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2));
    }

    public AsyncChannel(ExecutorService executorService){
        this.executorService = executorService;
    }

    @Override
    public final void dispatch(Event message) {
        executorService.submit(()->this.handle(message));
    }

    public void hello(){
    }

    protected abstract void handle(Event message);

    void stop(){
        if (null != executorService && !executorService.isShutdown()){
            executorService.shutdown();
        }
    }
}
