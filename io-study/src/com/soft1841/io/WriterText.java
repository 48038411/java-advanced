package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class WriterText {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串");
        String str = scanner.nextLine();
        System.out.println(str);
        char[] chars = str.toCharArray();
        System.out.println(chars);
        File destFile = new File("E:/hello.txt");
        Writer out = new FileWriter(destFile);
        out.write(chars);
        out.close();
    }
}
