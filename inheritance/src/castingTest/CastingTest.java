package castingTest;



class Car{
    void engineStart(){
        System.out.println("열쇠 또는 버튼으로 시동킴");
    }
}

class SuperCar extends Car{
    @Override
    void engineStart() {
        System.out.println("음성으로 시동 킴");
    }

    void openRoof(){
        System.out.println("지붕 엶");
    }
}





public class CastingTest {
    public static void main(String[] args) {
        Car matiz = new Car();
        SuperCar ferrari = new SuperCar();

        Car noOptionFerrari = new SuperCar();
//        SuperCar brokenFerrari = (SuperCar) new Car();
//        brokenFerrari.engineStarrt();
        SuperCar fullOptionFerrari =(SuperCar)noOptionFerrari;
        fullOptionFerrari.openRoof();
    }
}
