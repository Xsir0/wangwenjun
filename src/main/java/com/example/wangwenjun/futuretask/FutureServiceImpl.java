package com.example.wangwenjun.futuretask;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName FutureServiceImpl
 * @Description FutureServiceImpl的主要作用在于当提交任务时创建一个新的线程来受理该任务 , 进而达到任务异步执行的效果
 * @Author xsir
 * @Date 2021/9/27 上午6:47
 * @Version V1.0
 */
public class FutureServiceImpl<IN,OUT> implements FutureService<IN,OUT> {

    private final static String FUTURE_THREAD_PREFIX = "FUTURE-";

    private final AtomicInteger nextCounter = new AtomicInteger(0);

    private String getNextName(){
        return FUTURE_THREAD_PREFIX + nextCounter.getAndIncrement();
    }

    @Override
    public Future<?> submit(Runnable runnable) {

        final FutureTask<Void> future = new FutureTask<>();
        new Thread(()->{
            runnable.run();
            future.finish(null);
        },getNextName()).start();

        return future;
    }

    @Override
    public Future<OUT> submit(Task<IN, OUT> task, IN input) {
        final FutureTask<OUT> future = new FutureTask<>();
        new Thread(()->{
            OUT result = task.get(input);
            future.finish(result);
        },getNextName()).start();
        return future;
    }

}
