package com.example.wangwenjun.booleanlock;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * @ClassName Client
 * @Description
 * @Author xsir
 * @Date 2021/9/16 上午6:28
 * @Version V1.0
 */
public class Client {

    private final Lock lock = new BooleanLock();

    public void syncMethod(){

        try {
            lock.lock();
            int randomInt = 2;
            System.out.println(currentThread()+" get the lock.");
            TimeUnit.SECONDS.sleep(randomInt);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private String currentThread(){
        return Thread.currentThread().getName();
    }


    public static void main(String[] args) {
        Client client = new Client();
        IntStream.range(0,10).mapToObj(i->new Thread(client::syncMethod)).forEach(Thread::start);
    }

}
