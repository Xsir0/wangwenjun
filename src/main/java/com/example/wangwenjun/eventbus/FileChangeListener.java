package com.example.wangwenjun.eventbus;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName FileChangeListener
 * @Description
 * @Author xsir
 * @Date 2021/10/13 上午7:00
 * @Version V1.0
 */
public class FileChangeListener {

    @Subscribe
    public void onChange(FileChangeEvent event){
        System.out.printf("%s-%s\n",event.getPath(),event.getKind());
    }

    public static void main(String[] args)throws Exception{
        ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*2);

        final EventBus eventBus = new AsyncEventBus(executor);

        eventBus.register(new FileChangeListener());
        DirectoryTargetMonitor monitor = new DirectoryTargetMonitor(eventBus,"/Users/xsir/Desktop/test");
        monitor.startMonitor();
    }

}
