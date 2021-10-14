package com.example.wangwenjun.guardedsuspension;

import java.util.LinkedList;

/**
 * @ClassName GuardedSuspensionQueue
 * @Description
 * @Author xsir
 * @Date 2021/9/27 上午8:12
 * @Version V1.0
 */
public class GuardedSuspensionQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();

    private final int LIMIT = 100;

    public void  offer(Integer data)throws InterruptedException{
        synchronized (this){
            while (queue.size()>=LIMIT){
                this.wait();
            }
            queue.add(data);
            this.notify();
        }
    }

    public Integer take() throws InterruptedException{
        synchronized (this){
            while (queue.isEmpty()){
                this.wait();
            }
            this.notify();
            return queue.removeFirst();
        }
    }

}
