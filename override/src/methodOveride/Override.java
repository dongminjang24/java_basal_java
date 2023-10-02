package methodOveride;


class Espresso{
    String beanOrigin;
    int water;

    Espresso(String beanOrigin, int water){
        this.beanOrigin = beanOrigin;
        this.water = water;
    }
    // Method

    void taste(){
        System.out.println("쓰다.");
    }

}
class Latte extends Espresso{

    int milk;
    Latte(int milk,String beanOrigin,int water){
        super(beanOrigin,water);
        this.beanOrigin =beanOrigin;
        this.water=water;
    }
    //Method
    //오버라이드하는 메소드는 @override 어노테이션을 붙여주는 게 좋다.
    @java.lang.Override
    void taste() {
        System.out.println("부드럽다.");
    }
};
public class Override {
    public static void main(String[] args) {
        Latte latte = new Latte(200,"인도네시아",50);
        latte.taste();
    }

}
