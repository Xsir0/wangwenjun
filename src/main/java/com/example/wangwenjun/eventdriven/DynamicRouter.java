package com.example.wangwenjun.eventdriven;

public interface DynamicRouter<E extends Message> {

    /**
     * @desc 针对每一种message 类型注册相关的 Channel，只有找到合适的 Channel 该 Message 才会被处理
     * @author xsir
     * @date 2021/10/14 上午6:06
     * @param messageType
     * @param channel
     */
    void registerChannel(Class<? extends E> messageType,Channel<? extends E> channel);

    /**
     * @desc 为相应的 Channel 分配 message
     * @author xsir
     * @date 2021/10/14 上午6:06
     * @param message
     */
    void dispatch(E message);

}
