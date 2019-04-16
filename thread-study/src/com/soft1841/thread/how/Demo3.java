package com.soft1841.thread.how;

/**
 * 使用匿名内部类
 */
public class Demo3 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        });
        thread.setName("使用匿名内部类新建的线程");
        thread.start();
    }
}