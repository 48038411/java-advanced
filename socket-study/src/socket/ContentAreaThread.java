package socket;

import javax.swing.*;

/**
 * 主服务器刷新聊天内容的线程
 */
public class ContentAreaThread extends Thread {
    //将主服务器的窗体传过来
    private JTextArea contentArea;
    //将主服务器获取的客户端发送的内容传过来
    private byte[] b;
    public void setB(byte[] b){
        this.b = b;
    }
    public ContentAreaThread(JTextArea contentArea){
        this.contentArea= contentArea;
    }
    @Override
    public void run() {
        //执行线程，使主服务器界面的聊天内容显示组件一直追加
            contentArea.append(new String(b)+"\n");
    }
}
