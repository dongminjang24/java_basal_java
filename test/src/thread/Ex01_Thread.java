package thread;

class ThreadTask extends Thread{
    private String taskName;

    public ThreadTask(String taskName){
        this.taskName  = taskName;
    }

    @Override
    public void run() {
        try{
            sleep(1000); //1초
            System.out.println(taskName);
            sleep(1000);sleep(1000); //1초
            System.out.println(taskName);
            sleep(1000);sleep(1000); //1초
            System.out.println(taskName);
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Ex01_Thread {
    public static void main(String[] args) {
        Thread thread = new ThreadTask("첫 쓰레드");

        thread.start();

        System.out.println("main 쓰레드는 종료됩니다.");
    }
}
