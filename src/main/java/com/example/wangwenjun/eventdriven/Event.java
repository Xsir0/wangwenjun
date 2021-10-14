package com.example.wangwenjun.eventdriven;

/**
 * @ClassName Event
 * @Description
 * @Author xsir
 * @Date 2021/10/14 上午6:09
 * @Version V1.0
 */
public class Event implements Message {

    @Override
    public Class<? extends Message> getType() {
        return getClass();
    }
}
