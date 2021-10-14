package com.example.wangwenjun;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

/**
 * @ClassName ThreadJoin
 * @Description
 * @Author xsir
 * @Date 2021/9/14 上午6:12
 * @Version V1.0
 */
public class ThreadJoin {

    public static void main(String[] args) {

        // ① 定义两个线程，并保存在 threads 中
        List<Thread> threads = IntStream.range(1,3).mapToObj(ThreadJoin::create).collect(toList());

        // ② 启动这两个线程
        threads.forEach(Thread::start);

        // ③ 执行这两个线程的 join 方法
        // for (Thread thread : threads) {
        //     try {
        //         thread.join();
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     }
        // }

        // ④ main 线程循环输出
        for (int i = 0; i < 3; i++) {
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }

    // 构造一个简单的线程，每个线程只是简单的循环输出
    private static Thread create(int seq){
        return new Thread(()->{
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        },String.valueOf(seq));
    }

    private static void shortSleep(){
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
