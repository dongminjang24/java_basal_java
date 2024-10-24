package me.whiteship.java8to11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

public class CompletableFutureImpl2 {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(10);
		// 이 쓰레드풀 사용해서 하라고 각각 넣어둠


		CompletableFuture<String> hello = CompletableFuture.supplyAsync(() -> {
			System.out.println("Hello " + java.lang.Thread.currentThread().getName());
			return "Hello";
		});
		hello.get();

		CompletableFuture<String> world = CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + java.lang.Thread.currentThread().getName());
			return "World";
		});
		world.get();

		CompletableFuture<String> thenCompose = hello.thenCompose(CompletableFutureImpl2::getWorld);
		System.out.println(thenCompose.get());



		CompletableFuture<String> thenCombine = hello.thenCombine(world, (h, w) -> {
			System.out.println(h + w + java.lang.Thread.currentThread().getName());
			return h + w;
		});
		System.out.println(thenCombine.get());

		CompletableFuture.allOf(hello, world)
			.thenAccept(result -> {
				System.out.println(java.lang.Thread.currentThread().getName());
			});


		List<CompletableFuture<String>> futures = Arrays.asList(hello, world);
		CompletableFuture[] array = futures.toArray(new CompletableFuture[futures.size()]);
		CompletableFuture<List<String>> results = CompletableFuture.allOf(array)
			.thenApply(v -> futures.stream()
				.map(CompletableFuture::join)
				.collect(Collectors.toList()));
		results.get().forEach(v -> {
			System.out.println(v +"sdf");
		});

		CompletableFuture<Void> future = CompletableFuture.anyOf(hello, world)
			.thenAccept(v -> {
				System.out.println(v + "asd");
			});

		CompletableFuture.supplyAsync(() ->{
			if (true) throw new IllegalArgumentException();
			return "Hello";
		}).handle((result, ex) -> {
			if (ex != null) {
				System.out.println(ex);
				return "ERROR!";
			}
			return result;
		});
	}

	private static CompletableFuture<String> getWorld(String message) {
		return CompletableFuture.supplyAsync(() -> {
			System.out.println("World " + java.lang.Thread.currentThread().getName());
			return message + " World";
		});
	}
}
