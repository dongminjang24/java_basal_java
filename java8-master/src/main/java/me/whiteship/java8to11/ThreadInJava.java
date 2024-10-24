package me.whiteship.java8to11;

public class ThreadInJava {

	public static void main(String[] args) throws InterruptedException {
		String name = java.lang.Thread.currentThread().getName();
		System.out.println("기본name = " + name);

		SonThread sonThread = new SonThread();
		sonThread.start();

		System.out.println("Hello"); // Thread의 순서는 보장되지 않는다.

		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("OldThread: " + java.lang.Thread.currentThread().getName());
			}
		}).start();

		new Thread(() -> {
			try {
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}
			System.out.println("람다Thread: " + java.lang.Thread.currentThread().getName());
		}).start();

		Thread 쓰레드_방해하기 = new Thread(() -> {
			while (true) {
				try {
					System.out.println("쓰레드 방해 출력");
					Thread.sleep(1000L);
				} catch (InterruptedException e) {
					System.out.println("쓰레드 방해 exit!");
					return;
				}
			}
		});

		쓰레드_방해하기.start();
		Thread.sleep(3000L);
		쓰레드_방해하기.interrupt(); // 종료가 아니라 깨우는 것. -> InterruptedException 발생

		Thread join쓰레드 = new Thread(() -> {
			try {
				System.out.println("조인 쓰레드 출력");
				Thread.sleep(3000L);
			} catch (InterruptedException e) {
				throw new RuntimeException(e);
			}

		});
		join쓰레드.start();

		System.out.println("join쓰레드join전");
		join쓰레드.join(); // join쓰레드가 끝날때까지 기다린다.

		System.out.println("join쓰레드join 후 ");
	}

	static class SonThread extends java.lang.Thread {
		@Override
		public void run() {
			System.out.println("SonThread: " + java.lang.Thread.currentThread().getName());
		}
	}

}
