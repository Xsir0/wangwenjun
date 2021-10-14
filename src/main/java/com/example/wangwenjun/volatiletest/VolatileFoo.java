package com.example.wangwenjun.volatiletest;

import java.util.concurrent.TimeUnit;

/**
 * @ClassName VolatileFoo
 * @Description
 * @Author xsir
 * @Date 2021/9/23 上午5:39
 * @Version V1.0
 */
public class VolatileFoo {

    // init_value 的最大值
    final  static int MAX = 5;
    // init_value 的初始化值
    static int init_value = 0;

    public static void main(String[] args) {
        // 启动一个 Reader 线程，当发现 local_value 和 init_value 不同时，则输出 init_value 被修改的信息；
        new Thread(()->{
            int localValue = init_value;
            while (localValue<MAX){
                if (init_value != localValue){
                    System.out.printf("The init_value is updated to [%s]\n",init_value);
                    // 对 localValue 重新赋值
                    localValue = init_value;
                }
            }
        },"Reader").start();

        // 启动 Updater 线程，主要用于对 init_value 的修改，当 local_value>=5的时候则退出生命周期
        new Thread(()->{
            int localValue = init_value;
            while (localValue < MAX){
                // 修改 init_value
                System.out.printf("The init_value will be changed to [%s]\n",++localValue);
                init_value = localValue;
                try {
                    // 短暂休眠，目的是为了使 Reader 线程能够来得及输出变化内容
                    TimeUnit.SECONDS.sleep(2);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        },"Updater").start();
    }
}
