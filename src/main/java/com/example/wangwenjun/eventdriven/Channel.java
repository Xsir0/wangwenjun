package com.example.wangwenjun.eventdriven;

public interface Channel<E extends Message> {

    /**
     * @desc dispatch 方法用于负责 Message 的调度
     * @author xsir
     * @date 2021/10/14 上午6:02
     * @param message
     */
    void dispatch(E message);

}
