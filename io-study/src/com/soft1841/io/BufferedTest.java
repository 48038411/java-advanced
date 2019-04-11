package com.soft1841.io;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) {
        String content[] = {"一切都太耀眼了，","太过刺目，","于是我闭上了双眼，","但内心还是无法停止对未来的渴望"};
        File file = new File("April.txt");
        try {
            FileWriter fileWriter = new FileWriter(file);
            //创建BufferedWriter类对象
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            for (int k = 0; k < content.length; k ++){
                bufferedWriter.write(content[k]);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fileReader = new FileReader(file);
            //创建BufferedReader类对象
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String string = null;
            int i = 0;
            //如果文本行数不为null，则进入循环
            while ((string = bufferedReader.readLine()) != null){
                i ++;
                System.out.println("第" + i + "行:" + string);
            }
            bufferedReader.close();
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
