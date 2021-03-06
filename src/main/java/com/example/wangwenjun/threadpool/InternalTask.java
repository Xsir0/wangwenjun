package com.example.wangwenjun.threadpool;

/**
 * @ClassName InternalTask
 * @Description
 * @Author xsir
 * @Date 2021/9/17 上午8:06
 * @Version V1.0
 */
public class InternalTask implements Runnable {

    private final RunnableQueue runnableQueue;
    private volatile boolean running = true;

    public InternalTask(RunnableQueue runnableQueue) {
        this.runnableQueue = runnableQueue;
    }

    @Override
    public void run() {
        while (running && !Thread.currentThread().isInterrupted()){
            Runnable task = null;
            try {
                task = runnableQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            task.run();
        }
    }

    public void  stop(){
        this.running = false;
    }
}
