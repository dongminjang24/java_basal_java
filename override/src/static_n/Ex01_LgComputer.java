package static_n;


class LgComputer {
    // Data class ==LgComputer

    //Field

    //non-static 필드 - 인스턴스 필드(객체(인스턴스) 마다 다른 값을 가지는 변수)
    String model;
    int price;

    //static 필드 - 모든 객체(인스턴스)가 공유하는 변수
    static String manufacturer = "LG";

    //Constructor
    LgComputer(String model,int price){
        this.model = model;
        this.price = price;
    }
}
public class Ex01_LgComputer {
    //main이 static 메소드인이유
    //main 메소드를 포함하는 클래스인 "Ex_01LGComputer"의 객체 생성없이
    // 호출하기 위해서 (new Ex01_LGComputer()없이 실행)
    public static void main(String[] args) {
        //1. non-static 필드는 객체(인스턴스)를 만든 후 확인할 수 있다.
        // 객체(인스턴스)를 통해서만 접근이 가능하다.
        LgComputer lgComputer = new LgComputer("Gram",200);
        System.out.println("모델 : " + lgComputer.model);
        System.out.println("가격 : " + lgComputer.price);

        //2.static 필드는 객체(인스턴스)를 만들기 전에 확인할 수 있다.
        //객체(인스턴스) 없이도 접근이 가능하다.
        // 클래스의 이름으로 사용한다.
        System.out.println("제조사 : " + LgComputer.manufacturer);
        // new전에 사용가능한 것: static
        //아닌 것 :non-static

    }
}
