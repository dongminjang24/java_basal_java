package thread;

class Gun extends Thread{
    private String model;
    private int bullet;
    public Gun(String model,int bullet){
        this.model = model;
        this.bullet = bullet;
    }

    @Override
    public void run() {//쓰레드를 실행하는 메소드
        for(int i = 0; i< bullet; i++){
            System.out.println(model + " :  " + (i+1)+ "발 발사");
            try {
                sleep(500);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
public class Ex02_MultiThread {

    public static void main(String[] args) {
        Gun gun1 = new Gun("베레타" ,6);
        Gun gun2 = new Gun("콜트" ,12);
        gun1.start();
        gun2.start();

        System.out.println("main의 종료");
    }

}
