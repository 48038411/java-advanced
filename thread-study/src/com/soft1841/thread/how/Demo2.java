package com.soft1841.thread.how;

/**
 * 通过实现Runnable接口实现线程
 */
public class Demo2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Demo2());
        thread.setName("通过实现接口新建的线程");
        thread.start();
    }
}