package override;

public class Main01 {
    public static void main(String[] args) {
        Army am = new Army("육군");
        Navy navy = new Navy("해군");
        AirForce airForce = new AirForce("공군");

        am.attack();
        am.tank();
        navy.attack();
        navy.nucleus();
        airForce.attack();
        airForce.bombing();

    }
}
