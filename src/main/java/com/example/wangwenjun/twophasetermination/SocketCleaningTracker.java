package com.example.wangwenjun.twophasetermination;

import sun.misc.Cleaner;

import javax.sound.midi.Track;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.net.Socket;

/**
 * @ClassName SocketCleaningTracker
 * @Description 释放 socket 资源
 * @Author xsir
 * @Date 2021/9/30 上午6:43
 * @Version V1.0
 */
public class SocketCleaningTracker {

    // 定义 ReferenceQueue
    private  static final  ReferenceQueue<Object> queue = new ReferenceQueue<>();

    static {
        // 启动 cleaner 线程
        new Cleaner().start();
    }

    private static void track(Socket socket){
        new Tracker(socket,queue);
    }

    private static class Cleaner extends  Thread{
        private Cleaner(){
            super("SocketCleaningTracker");
            setDaemon(true);
        }
        @Override
        public void run() {
            for (;;){
                try{
                    Tracker tracker = (Tracker) queue.remove();
                    tracker.close();
                }catch (InterruptedException e){

                }
            }
        }
    }

    private static class Tracker extends PhantomReference<Object>{
        private final Socket socket;

        Tracker(Socket socket,ReferenceQueue<? super Object> queue){
            super(socket,queue);
            this.socket = socket;
        }

        public void close(){
            try{
                socket.close();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }


}
