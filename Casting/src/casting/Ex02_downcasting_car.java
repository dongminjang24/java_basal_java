package casting;

class Car{
    private String model;

    public Car(String model) {
        this.model = model;
    }

    public void drive(){System.out.println(model +"타고 드라이브 중");}


}
class EV extends Car{
    private int battery;

    private final int FULL_BATTERY =80;

    public EV(String model, int battery) {
        super(model);
        this.battery = battery;
    }

    public void charging(int battery){
        this.battery += battery;
        if (this.battery> FULL_BATTERY){
            this.battery = FULL_BATTERY;
        }
        System.out.println("전기");
    }
}

class Hybrid extends EV{
    private int oil;
    private final int FULL_OIL=50;

    public Hybrid(String model,int battery, int oil) {
        super(model,battery);
        this.oil = oil;
    }
    public void addOil(int oil){
        this.oil = oil;
        if (this.oil > FULL_OIL){
            this.oil =  FULL_OIL;
        }
        System.out.println("오일");
    }
}
public class Ex02_downcasting_car {
    public static void main(String[] args) {
        Car[] motors = new Car[2];
        motors[0] = new EV("bmw",50);
        motors[1] = new Hybrid("sonata",30,50);

        for (Car car : motors){
            car.drive();
            if (car instanceof EV){
                ((EV)car).charging(10);
            }
            if (car instanceof Hybrid){
                ((Hybrid)car).addOil(20);
            }
            System.out.println("---------------------------------");
        }
    }

}
