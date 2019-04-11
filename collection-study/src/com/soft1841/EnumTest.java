package com.soft1841;
/**
 * author 郭瑞昌
 * 2019.03.21
 */
import java.util.Scanner;
public class EnumTest {
    enum Week {
        // 定义枚举，记录星期
        MONDAY("星期一"), TUESDAY("星期二"), WEDNESDAY("星期三"), THURSDAY("星期四"), FRIDAY("星期五"), SATURDAY("星期六"), SUNDAY("星期日");
        String week;
        Week(String week) {
            // 定义枚举构造函数
            this.week = week;
        }
        public String getName() {
            return week;
        }
        public static Week getWeek(String week) {
            // 定义一个方法，根据输入获取对应的Week枚举的值
            switch (week) {
                case "mon":
                    return Week.MONDAY;
                case "tues":
                    return Week.TUESDAY;
                case "wedn":
                    return Week.WEDNESDAY;
                case "thur":
                    return Week.THURSDAY;
                case "fri":
                    return Week.FRIDAY;
                case "satu":
                    return Week.SATURDAY;
                case "sun":
                    return Week.SUNDAY;
                default:
                    return Week.SUNDAY;
            }
        }
    }
        public static void main(String[] args) {
            System.out.println("**************中英文星期对照表**************");
            System.out.print("\n输入要查询的英文星期单词的小写缩写：");
            Scanner sc = new Scanner(System.in);
            Week week = Week.getWeek(sc.next());
            // 根据输入获取枚举值
            switch (week) {
                case MONDAY:
                    System.out.println("MONDAY————" + week.getName());
                    // 获取枚举值的中文描述
                    break;
                case TUESDAY:
                    System.out.println("TUESDAY-" + week.getName());
                    break;
                case WEDNESDAY:
                    System.out.println("WEDNESDAY-" + week.getName());
                    break;
                case THURSDAY:
                    System.out.println("THURSDAY-" + week.getName());
                    break;
                case FRIDAY:
                    System.out.println("FRIDAY-" + week.getName());
                    break;
                case SATURDAY:
                    System.out.println("SATURDAY-" + week.getName());
                    break;
                case SUNDAY:
                    System.out.println("SUNDAY-" + week.getName());
            }
            sc.close();

    }
}
