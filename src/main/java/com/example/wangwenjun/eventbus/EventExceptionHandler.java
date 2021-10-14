package com.example.wangwenjun.eventbus;

public interface EventExceptionHandler {

    void handle(Throwable cause,EventContext context);

}
