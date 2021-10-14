// package com.example.wangwenjun.threadpool;
//
// import java.util.ArrayDeque;
// import java.util.concurrent.TimeUnit;
//
// /**
//  * @ClassName BasicThreadPool
//  * @Description
//  * @Author xsir
//  * @Date 2021/9/17 上午8:23
//  * @Version V1.0
//  */
// public class BasicThreadPool extends Thread implements ThreadPool {
//
//     private final int initSize;
//
//     private final int maxSize;
//
//     private final int coreSize;
//
//     private int activeCount;
//
//     private final ThreadFactory threadFactory;
//
//     private final RunnableQueue runnableQueue;
//
//     private volatile boolean isShutdown = false;
//
//     private final Queue<ThreadTask> threadQueue = new ArrayDeque<>();
//
//     private final static DenyPolicy DEFAULT_DENY_POLICY = new DenyPolicy.DiscardDenyPolicy();
//
//     private final static ThreadFactory DEFAULT_THREAD_FACTORY = new DefaultThreadFactory();
//
//     private final long keepAliveTime;
//
//     private final TimeUnit timeUnit;
//
//     public BasicThreadPool(int initSize,int maxSize,int coreSize,int queueSize){
//         this(initSize,maxSize,coreSize,DEFAULT_THREAD_FACTORY,queueSize,DEFAULT_DENY_POLICY,10,TimeUnit.SECONDS);
//     }
//
//
//     public BasicThreadPool(int initSize, int maxSize, int coreSize, ThreadFactory defaultThreadFactory, int queueSize, DenyPolicy defaultDenyPolicy, int keepAliveTime, TimeUnit timeUnit) {
//         this.initSize = initSize;
//         this.maxSize = maxSize;
//         this.coreSize = coreSize;
//         this.threadFactory = defaultThreadFactory;
//         this.runnableQueue = new LinkedRunnableQueue(queueSize,defaultDenyPolicy,this);
//         this.keepAliveTime = keepAliveTime;
//         this.timeUnit = timeUnit;
//         this.init();
//     }
//
//     private void init(){
//         start();
//         for (int i = 0; i < initSize; i++) {
//              new Thread();
//         }
//     }
// }
