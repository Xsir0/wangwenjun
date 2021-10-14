package com.example.wangwenjun;

import java.util.stream.IntStream;

/**
 * @ClassName ThreadYield
 * @Description
 * @Author xsir
 * @Date 2021/9/13 上午6:44
 * @Version V1.0
 */
public class ThreadYield {

    public static void main(String[] args) {
        IntStream.range(0,2).mapToObj(ThreadYield::create).forEach(Thread::start);
    }

    private static Thread create(int index){
        return new Thread(()->{
           // if (index == 0){
           //     Thread.yield();
           // }
            System.out.println(index);
        });
    }
}
