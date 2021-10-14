package com.example.wangwenjun.eventbus;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName SimpleSubscriber1
 * @Description
 * @Author xsir
 * @Date 2021/10/12 上午8:13
 * @Version V1.0
 */
public class SimpleSubscriber1 {

    @Subscribe
    public void method1(String message) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("== SimpleSubscriber1==method1=="+message);
    }

    @Subscribe(topic = "test")
    public void method2(String message){
        System.out.println("== SimpleSubscriber1==method2=="+message);
    }

    public static void main(String[] args) {

        // 同步
        // Bus bus = new EventBus("TestBus");
        //    异步
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        Bus bus = new AsyncEventBus("TestBus",executor);
        bus.register(new SimpleSubscriber1());
        bus.post("Hello");
        System.out.println("-----------------");
        bus.post("Hello","test");
        executor.shutdown();

    }

}
