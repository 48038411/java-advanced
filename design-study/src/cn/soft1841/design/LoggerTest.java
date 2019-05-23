package cn.soft1841.design;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger1 = new TimeLoggerDecorator(new LoggerFileSystem());
        logger1.log("登录系统...");
        Logger logger2 = new TimeLoggerDecorator(new LoggerCloud());
        logger2.log("登陆系统...");
    }
}
