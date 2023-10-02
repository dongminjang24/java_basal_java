package day12_interface;

interface Shape{
    double calcArea(); //인터페이스는 자동으로 public abstract double 로 처리가 된다.
    String getName();

}
class Rect implements Shape{
    private int width;
    private int height;

    public Rect(int width, int height) {
        this.width = width;
        this.height = height;
    };

    @Override
    public double calcArea() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}

//구현 클래스

class Circle implements Shape{
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return 0;
    }

    @Override
    public String getName() {
        return null;
    }
}
public class Ex01_shape {

}
