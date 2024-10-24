package me.whiteship.java8to11;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ExecutorsImpl {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.submit(() -> {
                try {
                    System.out.println("쓰레드 실행중");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    System.out.println("쓰레드 종료");
                }
        });
       executorService.shutdown();  // graceful shutdown
       // executorService.shutdownNow();

        ExecutorService executorServic2 = Executors.newFixedThreadPool(2);
        executorServic2.submit(printThreadName("Thread 1"));
        executorServic2.submit(printThreadName("Thread 2"));
        executorServic2.submit(printThreadName("Thread 3"));
        executorServic2.submit(printThreadName("Thread 4"));
        executorServic2.submit(printThreadName("Thread 5"));
        executorServic2.submit(printThreadName("Thread 6"));
        executorServic2.submit(printThreadName("Thread 7"));
        executorServic2.submit(printThreadName("Thread 8"));
        executorServic2.submit(printThreadName("Thread 9"));
        executorServic2.shutdown();

        ScheduledExecutorService executorService3 = Executors.newSingleThreadScheduledExecutor();
        executorService3.schedule(printThreadName("Scheduled Thread 1"), 10, TimeUnit.SECONDS);
        executorService3.shutdown();

        ScheduledExecutorService executorService4 = Executors.newSingleThreadScheduledExecutor();
        executorService4.scheduleAtFixedRate(printThreadName("Scheduled Thread 2"), 1, 3, TimeUnit.SECONDS);
    }
    private static Runnable printThreadName(String name) {
        return () -> {
			try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("Thread name: " + name + " " + Thread.currentThread().getName());
        };
    }


}
