package com.example.wangwenjun.workthread;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @ClassName Test
 * @Description
 * @Author xsir
 * @Date 2021/10/8 上午6:50
 * @Version V1.0
 */
public class Test {

    public static void main(String[] args) {
        final ProductionChannel channel = new ProductionChannel(5);

        AtomicInteger productionNo = new AtomicInteger();

        IntStream.range(1,8).forEach(i->new Thread(()->{
            while (true){
                channel.offerProduction(new Production(productionNo.getAndIncrement()));

                try {
                    TimeUnit.SECONDS.sleep(3);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }).start()
        );

    }

}
