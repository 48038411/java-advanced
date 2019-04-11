package com.soft1841.io;

import java.io.*;
import java.util.Scanner;

public class TestCopy2 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一段字符串：" );
        String inputStream = scanner.nextLine();
        char[] chars = inputStream.toCharArray();
        File destFile = new File("E:/字符串.txt");
        Writer out = new FileWriter(destFile);
        out.write(chars);
        out.close();
    }
}
