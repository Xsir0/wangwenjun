package com.example.wangwenjun.eventbus;

import java.lang.reflect.Method;

/**
 * @ClassName Subscriber
 * @Description
 * @Author xsir
 * @Date 2021/10/12 上午6:39
 * @Version V1.0
 */
public class Subscriber {

    private final Object subscribeObject;

    private final Method subscribeMethod;

    private boolean disable = false;

    public Subscriber(Object subscribeObject,Method subscribeMethod){
        this.subscribeObject = subscribeObject;
        this.subscribeMethod = subscribeMethod;
    }

    public Object getSubscribeObject(){
        return subscribeObject;
    }

    public Method getSubscribeMethod(){
        return subscribeMethod;
    }

    public boolean isDisable(){
        return disable;
    }

    public void setDisable(boolean disable){
        this.disable = disable;
    }

}
