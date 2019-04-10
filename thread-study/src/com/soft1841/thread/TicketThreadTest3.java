package com.soft1841.thread;

/**
 * 售票线程程序3
 * 实现runnable接口并同步线程 加锁
 * @author 侯粤嘉
 * 2019.4.8
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt  =new TicketThread3();
        Thread thread1 = new Thread(tt,"郴州站");
        Thread thread2 = new Thread(tt,"长沙站");
        Thread thread3 = new Thread(tt,"株洲站");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class TicketThread3 implements Runnable{
    private int  tickets = 10;

    @Override
    public void run() {
        while (true){
            //进行加锁  同步售票代码块 也就是线程加锁
            synchronized (this) {

                if (tickets>0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                    //先减 currentThread当前票数  获取线程的名字，，
                    System.out.println(Thread.currentThread().getName() + " 售票，当前票数：" + --tickets);
                }else{
                    break;
                }
            }
        }

    }
}
