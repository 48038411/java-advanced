package com.soft1841.io;

import java.io.File;

public class ImageTest {
    public static void main(String[] args) {
        String path = "C:\\Users\\admin\\Pictures";
        File file = new File(path);
        File[] files = file.listFiles();
        for (File f :
                files) {
            if (!f.isDirectory()) {
                String srcFileName = f.getName();
                int position = srcFileName.indexOf(".");
                String suffixName = srcFileName.substring(position);
                if (suffixName.equals(".jpg") | suffixName.equals(".png")) {
                    System.out.println(f);
                }
            }
        }
    }
}
