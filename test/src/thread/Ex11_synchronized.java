package thread;

class Maker{
    private String message;
    private boolean isMade = false;
    public String getMessage(){
        try {
            synchronized (this){
                wait();
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        return message;
    }
    public synchronized void setMessage(String message){
        this.message=message;
        this.isMade = true;
        notify();
    }
}
class Sender extends Thread{
    private Maker maker;

    public Sender(Maker maker){
        this.maker = maker;
    }

    @Override
    public void run() {
        try {
            sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }
        maker.setMessage("보고싶다");
        System.out.println("전송 완료");
    }
}

class Reader extends Thread{
    private Maker maker;

    public Reader(Maker maker) {this.maker= maker;}

    @Override
    public void run() {
        System.out.println(maker.getMessage());
        System.out.println("수신 완료");
    }
}

public class Ex11_synchronized {
    public static void main(String[] args) {
        Maker maker = new Maker();
        Sender sender = new Sender(maker);
        Reader reader = new Reader(maker);
        sender.start();
        reader.start();

    }
}
