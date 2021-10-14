package com.example.wangwenjun.readwritelock;


/**
 * @ClassName ReadWriteLockTest
 * @Description
 * @Author xsir
 * @Date 2021/9/26 上午6:41
 * @Version V1.0
 */
public class ReadWriteLockTest {

    private final static String text = "Thisistheexampleforreadwritelock";

    public static void main(String[] args){
        final ShareData shareData = new ShareData(50);
        for (int i = 0; i < 2; i++) {
            new Thread(()->{
                for (int index = 0; index < text.length(); index++) {
                    try {
                        char c = text.charAt(index);
                        shareData.write(c);
                        System.out.println(currentThread()+" write "+c);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }

        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    try {
                        System.out.println(currentThread()+" read "+new String(shareData.read()));
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    private static Thread currentThread(){
        return Thread.currentThread();
    }

}
