package com.example.wangwenjun;

/**
 * @ClassName TicketWindow
 * @Description
 * @Author xsir
 * @Date 2021/9/12 上午10:22
 * @Version V1.0
 */
public class TicketWindowRunnable implements Runnable{

    private String name;
    private static final int MAX = 50;
    private int index = 1;


    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(Thread.currentThread().getName()+", 当前号码："+(index++));
        }
    }

    public static void main(String[] args) {
        TicketWindowRunnable ticketWindow = new TicketWindowRunnable();
        Thread thread1 = new Thread(ticketWindow, "一号窗口");
        Thread thread2 = new Thread(ticketWindow, "二号窗口");
        Thread thread3 = new Thread(ticketWindow, "三号窗口");
        Thread thread4 = new Thread(ticketWindow, "四号窗口");

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }

}
