package com.example.wangwenjun.threadpool;

@FunctionalInterface
public interface ThreadFactory {

    // 用于创建线程
    Thread createThread(Runnable runnable);

}
