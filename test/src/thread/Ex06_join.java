package thread;


class SumThread extends Thread{
    private int sum;
    private int startNum;
    private int stopNum;

    public SumThread (String name,int startNum, int stopNum){
        setName(name);
        this.startNum = startNum;
        this.stopNum = stopNum;
    }

    public int getSum() {return sum;}

    public void addNum(int n) {sum +=n ; }

    @Override
    public void run() {
        for (int n = startNum; n < stopNum +1 ; n++){
            addNum(n);
        }
        System.out.println(sum);
    }
}
public class Ex06_join {
    public static void main(String[] args) {
        SumThread adder1 = new SumThread("adder1",1,10);
        SumThread adder2 = new SumThread("adder2",11,100);
        adder1.start();
        adder2.start();

        try{
            adder1.join();
            adder2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    System.out.println(adder1.getName()+"의 합 :" +adder1.getSum());
    System.out.println(adder2.getName()+"의 합 :" +adder2.getSum());
    System.out.println("총 합 : " +adder1.getSum()+adder2.getSum());
    }
}
