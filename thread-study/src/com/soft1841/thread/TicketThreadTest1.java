package com.soft1841.thread;

/**
 * @author admin
 * 多线程售票程序1
 * 通过继承Thread类的方式实现
 */
public class TicketThreadTest1  {
    public static void main(String[] args) {
        TicketThread1 t1 = new TicketThread1();
        t1.start();
        TicketThread1 t2 = new TicketThread1();
        t2.start();
        TicketThread1 t3 = new TicketThread1();
        t3.start();
    }
}
class TicketThread1 extends Thread{
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0){
            System.out.println(currentThread().getName()+"售票，当前票数"+ --tickets);
        }
    }
}
