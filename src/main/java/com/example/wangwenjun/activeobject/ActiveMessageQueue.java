package com.example.wangwenjun.activeobject;

import java.util.LinkedList;

/**
 * @ClassName ActiveMessageQueue
 * @Description
 * @Author xsir
 * @Date 2021/10/10 上午7:00
 * @Version V1.0
 */
public class ActiveMessageQueue {

    private final LinkedList<ActiveMessage> messages = new LinkedList<>();

    public ActiveMessageQueue(){
        new ActiveServiceFactory.ActiveDaemonThread(this).start();
    }

    public void offer(ActiveMessage message){
        synchronized (this){
            messages.addLast(message);
            this.notify();
        }
    }

    public ActiveMessage take(){
        synchronized (this){
            while (messages.isEmpty()){
                // this.wait();
            }
            return messages.removeFirst();
        }
    }

}
