package static_n;

class MyMethod{
    final static double PI =3.141592;//static final double PI =3.141592

    // static 메소드 선정 기준
    //non-static 필드(인스턴스 필드)를 사용하지 않는 메소드
    // Methods
    static int add(int a, int b){
        return a+b;
    }
    static double add(double a,double b) {
        return a+b;
    }

    static double pow(double a, double b){
        double result = 1;
        for (int i = 0; i<b;i++){
            result *=a;
        }
        return result;
    }
}
public class MyMath {
    public static void main(String[] args) {
        System.out.println("MyMath PI : " + MyMethod.PI);
        System.out.println(MyMethod.add(1,2));
        System.out.println(MyMethod.add(1.5,2.4));
        System.out.println(MyMethod.pow(2,3));
    }
}
