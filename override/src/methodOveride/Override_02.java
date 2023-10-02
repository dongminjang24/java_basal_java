package methodOveride;


class Pizza{
    String dough;
    int cheese;

    Pizza(String dough,int cheese){
        this.dough = dough;
        this.cheese =cheese;
    }

    void printPizza(){
        System.out.println("도우 : " + dough);
        System.out.println("치즈함량 : " + cheese);
    }
}
class BulgogiPizza extends Pizza{
    String bulgogi;
    BulgogiPizza(String bulgogi,String dough, int cheese){
        super(dough,cheese);
        this.bulgogi = bulgogi;
    }
    @java.lang.Override
void printPizza(){
    super.printPizza();
    System.out.println("고기 원산지 : " + bulgogi);
}

}
public class Override_02 {
    public static void main(String[] args) {
        BulgogiPizza bp = new BulgogiPizza("Newzealnd","sin",100);
        bp.printPizza();
    }
}
