package threadTest1;


public class MainThread  implements Runnable {

    @Override
    public void run() {
        for (int i =0 ; i< 10 ; i++){
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    public static void main(String[] args) {

        MainThread animal1 = new MainThread();
        MainThread animal2 = new MainThread();
        MainThread animal3 = new MainThread();

        Thread thread1 = new Thread(animal1,"웅냥");
        Thread thread2 = new Thread(animal2,"코코");
        Thread thread3 = new Thread(animal3,"찹찹");
        thread1.start();
        thread2.start();
        try{
            //join 사용한 쓰레드가 다 끝나야 다른 쓰레드가 동작한다.
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){;}
        thread3.start();
    }
}
