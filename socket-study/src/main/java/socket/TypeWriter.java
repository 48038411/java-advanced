package socket;


import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TypeWriter extends JFrame { // 创建“打字”类继承JFrame

	private JPanel contentPane; // 内容面板
	private JTextArea textArea; // 文本域
	private JButton btnStart; // “开始打字”按钮
	private ReadData readData; //

	public static void main(String[] args) {
		TypeWriter frame = new TypeWriter(); // 创建“打字”窗体对象
		frame.setVisible(true); // 使“打字”窗体对象可视
	}

	/**
	 * 创建窗体
	 */
	public TypeWriter() { // “打字”窗体的构造方法
		init(); // 初始化窗体
		addAction(); // 添加窗体中的监听事件
	}

	private void init(){ // 初始化窗体的方法
		setResizable(false); // 不可改变窗体的大小
		setTitle("模拟英文打字");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 关闭窗体的方式
		setBounds(100, 100, 450, 300); // 窗体的位置、大小
		// 内容面板（边界布局）
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		// 按钮面板（流布局）
		JPanel buttonPane = new JPanel();
		buttonPane.setBackground(Color.WHITE);
		contentPane.add(buttonPane, BorderLayout.SOUTH);
		// “开始打字”按钮
		btnStart = new JButton("开始打字");

		btnStart.setFont(new Font("微软雅黑", Font.PLAIN, 16));
		buttonPane.add(btnStart);
		// 滚动面板
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		// 文本域
		textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		scrollPane.setViewportView(textArea);

		readData = new ReadData(textArea); // 创建线程的子类（“读取线程”）对象

	}

	private void addAction(){ // 监听方法
		btnStart.addActionListener(new ActionListener() { // 添加按钮的动作监听事件
			public void actionPerformed(ActionEvent e) {
				String buttonName=btnStart.getText();
				if (buttonName.equals("开始打字")) { // 启用线程
					readData.start();
					btnStart.setText("敲累了！歇会儿...");
				} else if (buttonName.equals("敲累了！歇会儿...")) { // 挂起线程
					readData.pause();
					btnStart.setText("革命尚未成功！同志仍需努力...");
				} else if (buttonName.equals("革命尚未成功！同志仍需努力...")) { // 重新启用线程
					readData.reStart();
					btnStart.setText("敲累了！歇会儿...");
				}
			}
		});
	}
}

class ReadData extends Thread { // “读取数据”继承线程类

	private JTextArea textArea; // 文本域
	static boolean flag = false; // 挂起线程的标志

	public ReadData(JTextArea textArea) { // 以文本域为参数的构造方法，利用构造方法初始化变量
		this.textArea = textArea;
	}

	synchronized void pause() { // 挂起线程
		flag = true;
	}

	synchronized void reStart() { // 重新启用线程（唤醒正在等待的线程）
		notifyAll();
		flag = false;
	}

	@Override
	public void run() { // 线程要执行的任务
		FileInputStream fis = null; // 字节输入流
		try {
			fis = new FileInputStream("E:\\hello.txt"); // 创建字节输入流对象
			byte[] b = new byte[1]; // 创建可容纳1个字节的缓冲区
			StringBuilder sb = new StringBuilder(); // 字符串存储器
			while (fis.read(b) != -1) { // 循环读取"白雪公主.txt"中的文本内容
				String str = new String(b); // 将字节数组转换为字符串
				sb.append(str); // 向字符串存储器添加字符串
				synchronized (this) { // 挂起区
					while (flag) {
						try {
							wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
				}
				textArea.setText(sb.toString()); // 把字符串存储器中的字符串显示在文本域上
				try {
					Thread.sleep(200); // 显示的字符串之间的时间间隔为0.2秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close(); // 关闭字节输入流
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

