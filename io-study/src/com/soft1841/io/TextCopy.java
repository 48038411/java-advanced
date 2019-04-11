package com.soft1841.io;

import java.io.*;

/**
 * @author admin
 * 文本复制操作
 */
public class TextCopy {
    public static void main(String[] args) throws IOException {
        File srcFile = new File("E:/hello.txt");
        File destFile = new File("F:hello副本.txt");
        Reader in = new FileReader(srcFile);
        char[] chars = new char[(int) srcFile.length()];
        in.read(chars);
        Writer out = new FileWriter(destFile);
        out.write(chars);
        in.close();
        out.close();
    }
}
