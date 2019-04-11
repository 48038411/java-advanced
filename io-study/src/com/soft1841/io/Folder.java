package com.soft1841.io;

import java.io.File;

public class Folder {
    public static void main(String[] args) {
        File file = new File("E:\\Java");
        if (!file.exists()){
            file.mkdirs();
        }
}
}
