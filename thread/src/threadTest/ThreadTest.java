package threadTest;

public class ThreadTest {
    public static void main(String[] args) {
//        Thread1 t1 = new Thread1("✨");
//        Thread1 t2 = new Thread1("💚");
////        t1.run();
////        t2.run();
//        t1.start();
//        t2.start();

        Thread2 t1 = new Thread2();
        Thread2 t2 = new Thread2();
        Thread thread1 = new Thread(t1,"?");
        Thread thread2 = new Thread(t2,"!");
        thread1.start();
        thread2.start();
        try{
            //join 사용한 쓰레드가 다 끝나야 다른 쓰레드가 동작한다.
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            ;
        }

        System.out.println("main쓰레드 종료");

//        t1.run();
//        t2.run();
    }

}
