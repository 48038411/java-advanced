package cn.soft1841.design;

public class AdapterTest {
    public static void main(String[] args) {
        System.out.println("特长生招募中...");
        Student student = new Student() {
            @Override
            public void javaStudy() {
                System.out.println("我是练习时常两年半的Java工程师");
            }
        };
        student.javaStudy();
        Student student1 = new Student() {
            @Override
            public void playBasketball() {
                System.out.println("我篮球打的超棒哦");
            }

            @Override
            public void playFootball() {
                System.out.println("足球也踢的超棒");
            }
        };
        student1.playBasketball();
        student1.playFootball();
    }
}
