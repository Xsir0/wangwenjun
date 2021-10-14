package com.example.wangwenjun.futuretask;


public interface FutureService<IN,OUT> {

    // 提交不需要返回值的任务，Future.get()方法返回的是 null
    Future<?> submit(Runnable runnable);

    // 提交需要返回值的任务，其中 task 接口替代了 Runnable 接口
    Future<OUT> submit(Task<IN,OUT> task, IN input);

    // 使用静态方法创建一个 FutureService 的实现
    static <T,R> FutureService<T,R> newService(){
        return new FutureServiceImpl<>();
    }

}
