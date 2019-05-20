package cn.soft1841.design;

public class ShapeFactory {
    public static Shape getCircleInstance(){
        return new Circle();
    }
    public static Shape getRectangleInstance(){
        return new Rectangle();
    }
}
