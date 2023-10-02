package object;

class Calc2 {
     int plus(int x,int y){
        return x + y;
    }
     int minus(int x,int y){
        return x - y;
    }

     int times(int x,int y){
        return x * y;
    }

     int divide(int x,int y){
        return x / y;
    }

}

public class Main01 {
    public static void main(String[] args) {
        Calc2 result = new Calc2();
        System.out.println(result.plus(3,4));
        System.out.println(result.minus(3,4));
        System.out.println(result.times(3,4));
        System.out.println(result.divide(12,4));

    }
}
