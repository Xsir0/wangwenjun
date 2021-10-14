package com.example.wangwenjun;

/**
 * @ClassName TicketWindow
 * @Description
 * @Author xsir
 * @Date 2021/9/12 上午10:22
 * @Version V1.0
 */
public class TicketWindow extends Thread{

    private final String name;
    private static final int MAX = 50;
    private static int index = 1;

    public TicketWindow(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        while (index <= MAX){
            System.out.println(name+"柜台, 当前号码："+(index++));
        }
    }

    public static void main(String[] args) {
        TicketWindow ticketWindow1 = new TicketWindow("一号");
        ticketWindow1.start();

        TicketWindow ticketWindow2 = new TicketWindow("二号");
        ticketWindow2.start();

        TicketWindow ticketWindow3 = new TicketWindow("三号");
        ticketWindow3.start();

        TicketWindow ticketWindow4 = new TicketWindow("四号");
        ticketWindow4.start();

    }

}
