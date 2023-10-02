package thread.threadTest2;

import java.util.Scanner;

public class ThreadMain {

    public static void main(String[] args) throws InterruptedException {
        ThreadTask threadTask = new ThreadTask();

        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] order = input.split(" ");

        Thread thread1 = new Thread(() -> threadTask.printThird(() -> System.out.print("third ")));
        Thread thread2 = new Thread(() -> threadTask.printFirst(() -> System.out.print("first ")));
        Thread thread3 = new Thread(() -> threadTask.printSecond(() -> System.out.print("second ")));

        // 스레드 실행 순서를 사용자 입력 순서에 따라 설정합니다.
        for (String num : order) {
            switch (num) {
                case "1":
                    thread1.start();
                    thread1.join();
                    break;
                case "2":
                    thread2.start();
                    thread2.join();
                    break;
                case "3":
                    thread3.start();
                    thread3.join();
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }

        sc.close();
    }
}
