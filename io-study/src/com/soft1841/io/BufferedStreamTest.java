package com.soft1841.io;

import java.io.*;

public class BufferedStreamTest {
    public static void main(String[] args) {
        String content[] = {"我喜欢了你很久很久","却永远不及，","她的一颦一笑。"};
        File file  = new File("word.txt");
        FileOutputStream fileOutputStream = null;
        BufferedOutputStream bufferedOutputStream = null;
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;
            try {
                fileOutputStream = new FileOutputStream(file);
                bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
                byte[] bContent = new byte[1024];
                for (int k = 0;k< content.length;k++){
                    bContent = content[k].getBytes();
                    bufferedOutputStream.write(bContent);
                }
                System.out.println("写入成功!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                    try {
                        bufferedOutputStream.close();
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                    try {
                        fileInputStream = new FileInputStream(file);
                        bufferedInputStream = new BufferedInputStream(fileInputStream);
                        byte[] bContent = new byte[1024];
                        int len = bufferedInputStream.read(bContent);
                        System.out.println("文件中的信息为：" + new String(bContent,0,len));
                    } catch (IOException e) {
                        e.printStackTrace();
                    }finally {
                        try {
                            bufferedInputStream.close();
                            fileInputStream.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
        }


