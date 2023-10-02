package thread;

class Adder{
    private int rentalCount;
    public Adder(){ rentalCount = 0 ;}

    public int add(int from ,int to){
        rentalCount++;
        int sum =0;
        for(int n = from; n< to+1; n++){
            sum += n;
        }
        return sum;
    }

    public void rentalCountInfo(){
        System.out.println("렌탈 횟수 : " + rentalCount + "회");
    }
}

class  User extends Thread{
    private Adder adder;
    public User(Adder adder){
        this.adder = adder;
    }
    public  void useAdder(){
        System.out.println(adder.add(1,10));
        System.out.println(adder.add(11,20));
        System.out.println(adder.add(21,30));
        System.out.println(adder.add(31,40));
        System.out.println(adder.add(41,50));
    }

    public void run(){
        try{
            sleep(1000);
            useAdder();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
public class Ex07_join {
    public static void main(String[] args) throws InterruptedException {
        Adder calculator = new Adder();

        User user = new User(calculator);

        user.start();
        user.join();

        calculator.rentalCountInfo();
    }
}
