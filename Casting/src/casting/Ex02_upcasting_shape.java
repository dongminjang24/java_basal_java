package casting;





class Shape{
    public double calcArea() {return 0;}
    public String getName() {return "도형";}
}

class React extends Shape{
    private int width;
    private int height;

    public React(int width, int height){
        super();
        this.height= height;
        this.width =width;
    }

    @Override
    public double calcArea() {
        return width *height;}

    @Override
    public String getName() {
        return "사각형";
    }
}

class Circle extends Shape {
    private double radius;

    public Circle(double radius){
        super();
        this.radius = radius;
    }

    @Override
    public double calcArea() {
        return Math.PI * Math.pow(radius,2);
    }

    @Override
    public String getName() {
        return "원";
    }
}


class Triangle extends Shape {
    private int width;
    private int height;

    public Triangle(int width , int height){
        super();
        this.width = width;
        this.height = height;
    }

    @Override
    public double calcArea() {
        return width * height / 2.0;
    }

    @Override
    public String getName() {
        return "삼각형";
    }
}
public class Ex02_upcasting_shape {

    public static void main(String[] args) {
        Shape[] shapeList = new Shape[3];

        shapeList[0] = new React(2,3);
        shapeList[1] = new Circle(1.5);
        shapeList[2] = new Triangle(3,5);

        for (Shape shape : shapeList){
            System.out.println(shape.getName()+ "의 크기 : " + shape.calcArea());
        }
    }

}
