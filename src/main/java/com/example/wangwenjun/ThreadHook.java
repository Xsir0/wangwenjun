package com.example.wangwenjun;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName ThreadHook
 * @Description
 * @Author xsir
 * @Date 2021/9/17 上午6:44
 * @Version V1.0
 */
public class ThreadHook {

    public static void main(String[] args) {
        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 1 is running.");
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("The hook thread 1 will exit");
            }
        });

        Runtime.getRuntime().addShutdownHook(new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println("The hook thread 2 is running.");
                    TimeUnit.SECONDS.sleep(1);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println("The hook thread 2 will exit");
            }
        });
        System.out.println("The program will stopping.");
    }

}
