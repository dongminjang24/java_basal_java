package thread;

class RunnableImpl implements Runnable{
    @Override
    public void run() {
        while (true){
            System.out.println(Thread.currentThread().getName());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Ex08_stop {
    public static void main(String[] args) {
        Runnable run = new RunnableImpl();

        Thread thread1 = new Thread(run,"alice");
        Thread thread2 = new Thread(run,"james");

        thread1.start();
        thread2.start();

        try {
            Thread.sleep(5000);
            thread1.stop();
            thread2.stop();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
