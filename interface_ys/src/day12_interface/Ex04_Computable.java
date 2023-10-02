package day12_interface;

interface Computable{
    void playApp();
    void connectInternet();
}

class Phone{

    private String owner;
    public Phone(String owner) {
        this.owner =owner;
    }

    //method

    public void sendCall(){
        System.out.println(owner+ "의 전화걸기");
    }
    public void receiveCall(){
        System.out.println(owner+ "의 전화받기");
    }
};

class SmartPhone extends Phone implements Computable{
    public SmartPhone(String owner) {
        super(owner);
    };

    @Override
    public void playApp() {
        System.out.println("앱 실행");
    }

    @Override
    public void connectInternet() {
        System.out.println("인터넷 접속");
    };
}
public class Ex04_Computable {
    public static void main(String[] args) {
        Phone phone1 = new SmartPhone("박병훈");
        phone1.sendCall();
        phone1.receiveCall();
        ((Computable)phone1).playApp();
        ((Computable)phone1).connectInternet();

        Computable phone2 = new SmartPhone("장동민");
        phone2.playApp();
        phone2.connectInternet();
        ((Phone)phone2).sendCall();
        ((Phone)phone2).receiveCall();


        SmartPhone phone3 = new SmartPhone("김예슬");
        phone3.connectInternet();
        phone3.playApp();
        phone3.receiveCall();
        phone3.sendCall();
    }
}
