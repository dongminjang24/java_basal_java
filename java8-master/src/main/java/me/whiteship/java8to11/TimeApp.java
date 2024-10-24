package me.whiteship.java8to11;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TimeApp {

    public static void main(String[] args) {
        new GregorianCalendar(1990, Calendar.DECEMBER, 30);

        Date date = new Date();
        long time = date.getTime(); // 기계용 시간
        System.out.println("time = " + time);

        Instant instant = Instant.now();
        System.out.println("instant now = " + instant); // 기준시 UTC, GMT'

        ZonedDateTime kst = instant.atZone(ZoneId.of("UTC+9"));
        System.out.println("kst = " + kst);

        ZonedDateTime zonedDateTime = instant.atZone(ZoneId.systemDefault());// 기본 시스템 존
        System.out.println("zonedDateTime = " + zonedDateTime);

        ZonedDateTime zonedDateTime1 = instant.atZone(ZoneId.systemDefault());
        System.out.println("zonedDateTime1 = " + zonedDateTime1);

        ZonedDateTime zonedDateTime2 = instant.atZone(ZoneId.of("Asia/Seoul"));
        System.out.println("zonedDateTime2 = " + zonedDateTime2);

        Instant plus = instant.plus(10, ChronoUnit.SECONDS);
        Duration between = Duration.between(instant, plus);
        System.out.println("between = " + between.getSeconds());



    }

}
