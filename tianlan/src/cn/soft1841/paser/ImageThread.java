package cn.soft1841.paser;

import javax.swing.*;

/**
 * @author 郭瑞昌
 * 首页banner轮播线程文件
 */
public class ImageThread extends Thread {
    private JLabel imgLabel;

    public ImageThread(JLabel imgLabel){
        this.imgLabel = imgLabel;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(PaserTools.class.getResource("/img/banner1.jpg")));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            imgLabel.setIcon(new ImageIcon(PaserTools.class.getResource("/img/banner2.png")));
        }
    }
}
