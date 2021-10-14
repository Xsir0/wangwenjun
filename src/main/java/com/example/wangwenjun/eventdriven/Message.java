package com.example.wangwenjun.eventdriven;

public interface Message {

    /**
     * @desc 返回 Message 的类型
     * @author xsir
     * @date 2021/10/14 上午5:58
     * @return java.lang.Class<? extends com.example.wangwenjun.eventdriven.Message>
     */
    Class<? extends Message> getType();

}
