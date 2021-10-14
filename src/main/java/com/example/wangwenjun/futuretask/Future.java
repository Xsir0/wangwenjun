package com.example.wangwenjun.futuretask;

public interface Future<T> {

    // 返回计算结果后，该方法会陷入阻塞状态
    T get() throws InterruptedException;

    // 判断任务是否执行完成
    boolean done();

}
