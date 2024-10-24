package me.whiteship.java8to11;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProgressApp {
	public static void main(String[] args) {

		List<OnlineClass> springClasses = new ArrayList<>();
		springClasses.add(new OnlineClass(1, "spring boot", true));
		springClasses.add(new OnlineClass(2, "spring data jpa", true));
		springClasses.add(new OnlineClass(3, "spring mvc", false));
		springClasses.add(new OnlineClass(4, "spring core", false));
		springClasses.add(new OnlineClass(5, "rest api development", false));

		OnlineClass spring_boot = new OnlineClass(1, "spring boot", true);
		// Duration studyDuration = spring_boot.getProgress().orElse(null).getStudyDuration();
		Optional<OnlineClass> optional = springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring"))
			.findFirst();

		boolean present = optional.isPresent();
		System.out.println("optional = " + present);


		optional.ifPresent(oc->
			System.out.println("oc = " + oc.getTitle()));

		OnlineClass onlineClass = optional.orElse(createNewClass());
		OnlineClass onlineClassGet = optional.orElseGet(()->createNewClass());
		OnlineClass onlineClassThrow = optional.orElseThrow(()-> new IllegalArgumentException());

		Optional<Progress> progress = optional.flatMap(onlineClass1 -> onlineClass1.getProgress());
		Optional<Optional<Progress>> progress1 = optional.map(onlineClass1 -> onlineClass1.getProgress());
		Optional<Progress> progress2 = progress1.orElseThrow();

	}

	private static OnlineClass createNewClass() {
		System.out.println("creating new online class");
		return new OnlineClass(10, "New Class", false);
	}
}
