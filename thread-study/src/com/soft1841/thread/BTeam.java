package com.soft1841.thread;

public class BTeam extends Thread {
    @Override
    public void run() {
        for (int i = 1; i<= 11; i++){
            System.out.print("b" + i+"\t");
        }
    }
}
