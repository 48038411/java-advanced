package com.soft1841.io;
/**
 * @author 郭瑞昌
 * io的学习
 */

import java.io.File;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) {
        File file = new File("E:/README.md");
        //判断是否存在该文件
        if (file.exists()==false){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
