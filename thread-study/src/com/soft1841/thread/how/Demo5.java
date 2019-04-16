package com.soft1841.thread.how;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 通过线程池获取线程
 */
public class Demo5 {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(() -> {
            System.out.println(Thread.currentThread().getName());
        });
    }
}
