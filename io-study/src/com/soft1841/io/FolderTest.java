package com.soft1841.io;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FolderTest {
    public static void main(String[] args) throws IOException {
        String folderName = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        File folder = new File("E:\\"+folderName+"\\");
        if (!folder.exists()){
            folder.mkdir();
        }
        String fileName = new SimpleDateFormat("HH-mm-ss").format(new Date())+".txt";
        File file = new File(folder+"\\hello_"+fileName);
        file.createNewFile();
        }
    }
