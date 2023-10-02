package thread;

class Cleaner{
    //
    public synchronized void diningRoomCleaning(){
        try{
            System.out.println("다이닝 룸 청소 중");
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("다이닝 룸 청소 완료!!");
        notify();
        try {
            System.out.println("거실 청소 완료까지 기다리겠다.");
            wait(); // 다른 쓰레드의 동작이 끝났다는 신호를 받을 때까지
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
    public synchronized void livingRoomCleaning(){
        try{
            System.out.println("거실 청소 중");
            Thread.sleep(5000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("거실 청소 완료!!");
        notify();
        try {
            System.out.println("다이닝 룸 청소 완료까지 기다리겠다.");
            wait(); // 다른 쓰레드의 동작이 끝났다는 신호를 받을 때까지
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}

class Papa extends Thread{
    private Cleaner cleaner;
    public void setCleaner(Cleaner cleaner){
        this.cleaner = cleaner;
    }

    @Override
    public void run() {
        for(int i =0 ; i < 5 ; i++){
            cleaner.livingRoomCleaning();
        }
    }
}class Mama extends Thread{
    private Cleaner cleaner;
    public void setCleaner(Cleaner cleaner){
        this.cleaner = cleaner;
    }

    @Override
    public void run() {
        for(int i =0 ; i < 5 ; i++){
            cleaner.diningRoomCleaning();
        }
    }
}
public class Ex10_synchronized {
    public static void main(String[] args) {
        Cleaner cleaner = new Cleaner();

        Papa papa = new Papa();
        Mama mama = new Mama();

        papa.setCleaner(cleaner);
        mama.setCleaner(cleaner);

        papa.start();
        mama.start();
    }
}
