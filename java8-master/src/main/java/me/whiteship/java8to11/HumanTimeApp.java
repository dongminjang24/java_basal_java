package me.whiteship.java8to11;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HumanTimeApp {

    public static void main(String[] args) {
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        LocalDate birthday = LocalDate.of(1990, 12, 30);
        System.out.println("birthday = " + birthday);

        LocalDate localDateTime = LocalDate.of(2020, Month.JANUARY,24);
        Period between = Period.between(birthday, localDateTime);
        System.out.println("between = " + between);

        Period until = birthday.until(localDateTime);

        System.out.println("until = " + until);
        long days = until.get(ChronoUnit.DAYS);
        System.out.println("days = " + days);

        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        System.out.println("dateTimeFormatter = " + dateTimeFormatter.format(now));

        LocalDate parse = LocalDate.parse("07/15/1982", dateTimeFormatter);
        System.out.println("parse = " + parse);

        LocalDate plus = now.plus(10, ChronoUnit.DAYS);
        System.out.println("plus = " + plus);

    }

}
