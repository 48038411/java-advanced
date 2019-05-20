package cn.soft1841.design;

/**
 * 单列模式测试程序
 */
public class SingletonTest {
    public static void main(String[] args) {
        //编译错误  因为构造方法是不可能的 只能在Singleton类内部使用
        //Singleton object = new Singleton():


        //通过Singleton的类方法Singleton.getInstance()获取唯一可用对象
        Singleton object = Singleton.getInstance();
        //显示消息
        object.showMessage();
    }
}
