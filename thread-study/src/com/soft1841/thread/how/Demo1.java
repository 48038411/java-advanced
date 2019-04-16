package com.soft1841.thread.how;

/**
 * 通过继承Thread新建线程
 */
public class Demo1 extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo1());
        thread.setName("线程1");
        thread.start();
    }
}