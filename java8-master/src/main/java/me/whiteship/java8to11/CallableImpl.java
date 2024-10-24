package me.whiteship.java8to11;

import java.security.PrivilegedAction;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableImpl {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		ExecutorService executorService = Executors.newSingleThreadExecutor();

		Callable<String> hello = () -> {
			Thread.sleep(1000L);
			return "Hello";
		};
		Future<String> future = executorService.submit(hello);
		boolean done = future.isDone();
		System.out.println("done = " + done);
		System.out.println("submit get before");
		future.cancel(false); // 기다리지만 값을 가져올 수 없다.
		// future.cancel(true); // 현재 진행중인 작업을 interrupt하고 취소
		String s = future.get(); // blocking call , cancel을 하면 여기서 에러가 발생한다.
		System.out.println("s = " + s);  // cancel을 하면 여기서 에러가 발생한다.
		System.out.println("submit get after");
		boolean done2 = future.isDone();
		System.out.println("done2 = " + done2);
		executorService.shutdown();

	}
}
