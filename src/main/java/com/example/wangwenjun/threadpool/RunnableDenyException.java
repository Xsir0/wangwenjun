package com.example.wangwenjun.threadpool;

/**
 * @ClassName RunnableDenyException
 * @Description
 * @Author xsir
 * @Date 2021/9/17 上午8:05
 * @Version V1.0
 */
public class RunnableDenyException extends RuntimeException {

    public RunnableDenyException(String message) {
        super(message);
    }
}
