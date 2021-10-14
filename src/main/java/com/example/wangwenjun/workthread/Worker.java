package com.example.wangwenjun.workthread;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName Worker
 * @Description
 * @Author xsir
 * @Date 2021/10/8 上午6:47
 * @Version V1.0
 */
public class Worker extends Thread {

    private final ProductionChannel channel;

    private final static Random random = new Random(System.currentTimeMillis());

    public Worker(String workerName,ProductionChannel channel){
        super(workerName);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            try {
                Production production = channel.takeProduction();
                System.out.println(getName()+" process the "+ production);
                production.create();
                TimeUnit.SECONDS.sleep(random.nextInt(10));
            }catch (InterruptedException e){

            }
        }
    }
}
