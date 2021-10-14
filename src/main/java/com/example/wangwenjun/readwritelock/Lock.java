package com.example.wangwenjun.readwritelock;

public interface Lock {

    void lock() throws InterruptedException;

    void unlock();

}
