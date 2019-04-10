package com.soft1841.thread;

public class ATeam extends Thread {
    @Override
    public void run() {
        for (int i = 1; i<= 11; i++){
            System.out.print("a"+i+"\t");
        }
    }
}
