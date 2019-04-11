package com.soft1841.io;

public class RunnableTest extends Object implements Runnable{
    private int count = 10;
    @Override
    public void run() {
        while (true){
            System.out.print(count + " ");
            if (--count == 0){
                break;
            }
        }
    }

    public static void main(String[] args) {
        Runnable test =new RunnableTest();
        Thread thread = new Thread(test);
        thread.start();

    }
}
