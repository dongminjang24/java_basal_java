package generic;


class LegacyOmniBox{
    private Object a;

    public LegacyOmniBox(Object a){ this.a =a ;}

    public Object getA(){return a;}

    public void setA(Object a ){this.a =a;}
}

class Computer{}

class SmartPhone{}

public class Ex01_generic {
    public static void main(String[] args) {
        LegacyOmniBox box = new LegacyOmniBox(new Computer());
        Computer myComputer = (Computer) box.getA(); //getA의 리턴타입 object이다. Object타입은 적절한 형변환이 가능하다.
        System.out.println(myComputer);
    }
}
