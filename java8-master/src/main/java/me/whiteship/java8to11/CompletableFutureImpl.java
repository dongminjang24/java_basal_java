package me.whiteship.java8to11;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletableFutureImpl {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		// 이 쓰레드풀 사용해서 하라고 각각 넣어둠
		CompletableFuture<String> future = new CompletableFuture<>();
		future.complete("whiteship");
		System.out.println(future.get());

		// CompletableFuture<String> future2 = CompletableFuture.completedFuture("whiteship");
		// System.out.println(future2.get());

		CompletableFuture<Void> future3 = CompletableFuture.runAsync(() -> {
			System.out.println("Hello3 " + java.lang.Thread.currentThread().getName());
		},executorService);
		future3.get();  // return이 없을 경우 runAsync를 사용한다.

		CompletableFuture<String> future4 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello4 " + java.lang.Thread.currentThread().getName());
			return "Hello4";
		},executorService).thenApply(s -> {
			System.out.println(java.lang.Thread.currentThread().getName());
			return s.toUpperCase();
		});
		System.out.println("future4 " +future4.get()); // return이 있을 경우 supplyAsync를 사용한다. get을 호출해야함.

		CompletableFuture<Void> future5 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + java.lang.Thread.currentThread().getName());
			return "accept";
		},executorService).thenAccept(s -> {
			System.out.println(java.lang.Thread.currentThread().getName());
			System.out.println(s.toUpperCase());
		});
		System.out.println("future5 = " + future5.get());

		CompletableFuture<Void> future6 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello6 " + Thread.currentThread().getName());
			return "run";
		},executorService).thenRun(() -> {
			System.out.println("thenRun " + Thread.currentThread().getName());
		});
		System.out.println("future6 = " + future6.get());


		CompletableFuture<Void> future7 = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello7 " + Thread.currentThread().getName());
			return "run";
		},executorService).thenRunAsync(() -> {
			System.out.println("thenRunAsync " + Thread.currentThread().getName());
		});
		executorService.shutdown();

		// CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		// 	System.out.println("Hello " + java.lang.Thread.currentThread().getName());
		// });
		// future.get();

		// CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
		// 	System.out.println("Hello " + java.lang.Thread.currentThread().getName());
		// });
		// future.get();



	}
}
