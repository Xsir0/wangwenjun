package com.example.wangwenjun.threadpool;

public interface RunnableQueue {

    // 当有新的任务进来时首先会 offer 到队列中
    void offer(Runnable runnable);

    // 工作线程通过 take 方法获取 Runnable
    Runnable take() throws InterruptedException;

    // 获取任务队列中任务的数量
    int size();

}
