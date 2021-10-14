package com.example.wangwenjun.futuretask;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName Test
 * @Description
 * @Author xsir
 * @Date 2021/9/27 上午6:58
 * @Version V1.0
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        FutureService<Void,Void> service = FutureService.newService();

        Future<?> submit = service.submit(() -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("I am finish done.");
        });
        submit.get();


        FutureService<String,Integer> service1 = FutureService.newService();

        Future<Integer> submit1 = service1.submit(input -> {
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return input.length();
        }, "HELLO");
        submit1.get();

    }

}
