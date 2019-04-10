package com.soft1841.thread;

public class Admission {
    public static void main(String[] args) {
        System.out.println("A队与B队开始入场了！！！");
        ATeam aTeam = new ATeam();
        aTeam.start();
        BTeam bTeam = new BTeam();
        bTeam.start();
    }
}
