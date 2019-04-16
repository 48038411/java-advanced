package com.soft1841.thread.how;

/**
 * 通过lambda 表达式实现新建线程
 */
public class Demo4 {
    public static void main(String[] args) {
        new Thread(() -> {
            //通过lambda 表达式实现
            System.out.println(Thread.currentThread().getName());
        }).start();
    }
}