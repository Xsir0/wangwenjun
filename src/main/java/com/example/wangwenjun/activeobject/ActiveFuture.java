package com.example.wangwenjun.activeobject;


import com.example.wangwenjun.futuretask.FutureTask;

/**
 * @ClassName ActiveFuture
 * @Description
 * @Author xsir
 * @Date 2021/10/9 上午8:23
 * @Version V1.0
 */
public class ActiveFuture<T> extends FutureTask<T> {

    @Override
    protected void finish(T result) {
        super.finish(result);
    }
}
