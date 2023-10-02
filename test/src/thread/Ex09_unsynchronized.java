package thread;

class USB{
    private int memorySize;
    public USB( int memorySize){this.memorySize = memorySize;}
    public int getMemorySize(){ return memorySize;}
    public void setMemorySize(int memorySize){
        try{
            Thread.sleep(3000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        this.memorySize =memorySize;
        System.out.println(Thread.currentThread().getName()+", memorySize = " + this.memorySize);
    }
}
class Computer1 extends Thread{
    private USB usb;
    public void plugUSB(USB usb){
        this.usb =usb;
    }

    @Override
    public void run() {
        usb.setMemorySize(10);
    }
}
class Computer2 extends Thread{
    private USB usb;
    public void plugUSB(USB usb){
        this.usb =usb;
    }

    @Override
    public void run() {
        usb.setMemorySize(20);
    }
}
public class Ex09_unsynchronized {
    public static void main(String[] args) {
        USB usb = new USB(1);
        Computer1 com1 = new Computer1();
        com1.plugUSB(usb);
        com1.start();

        Computer2 com2 = new Computer2();
        com2.plugUSB(usb);
        com2.start();


    }
}
