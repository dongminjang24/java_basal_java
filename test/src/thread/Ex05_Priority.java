package thread;


class  PriorityThread extends Thread{
    public PriorityThread(String name){
        setName(name);
    }

    @Override
    public void run() {
        try {
            sleep(10000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("PriorityThread의 이름 : " +getName());
    }
}
public class Ex05_Priority {
    public static void main(String[] args) {
        // 기본적인 Thread 우선 순위 확인
        System.out.println("가장 낮은 우선 순위" + Thread.MIN_PRIORITY);
        System.out.println("중간 낮은 우선 순위" + Thread.NORM_PRIORITY);
        System.out.println("가장 높은 우선 순위" + Thread.MAX_PRIORITY);

        for (int  i = 0 ; i < 10;  i++) {
            Thread task = new PriorityThread("PriorityThread - " + (i+1));
            if (i <3 ){
                //초반 3개
                task.setPriority(Thread.MAX_PRIORITY);
            }else if (i< 8){
                task.setPriority(Thread.NORM_PRIORITY);
            }else{
                task.setPriority(Thread.MIN_PRIORITY);
            }

            task.start();
        }
    }


}
