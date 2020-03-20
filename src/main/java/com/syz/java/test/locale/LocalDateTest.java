package com.syz.java.test.locale;

import org.springframework.cglib.core.Local;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @ProjectName: javaTest
 * @Package: com.syz.java.test.locale
 * @ClassName: LocalDateTest
 * @Author: Administrator
 * @Description:
 * @Date 2020/1/4/00416:24
 */
public class LocalDateTest {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();
        test8();
        test9();
        test10();
        test11();
        test12();
    }

    private static void test12() {
        String sdf = "yyyyMMdd",date = "20201212";
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.BASIC_ISO_DATE);
        System.out.println(localDate);


    }

    private static void test11() {
        Instant instant = Instant.now();
        System.out.println("instant:"+instant);
    }

    private static void test10() {
        LocalDate now = LocalDate.now(),
                date = LocalDate.of(2020,2,2);
        Period between = Period.between(now, date);
        System.out.println("between month "+between.getMonths());
        System.out.println("between date "+between.getDays());
    }

    private static void test9() {
        LocalDate now = LocalDate.now(),
                date = LocalDate.of(2020,2,2);
        System.out.println(now.isAfter(date));
        System.out.println(now.isBefore(date));
        System.out.println(now.isBefore(LocalDate.of(2020,1,4)));
        System.out.println(now.isAfter(LocalDate.of(2020,1,4)));
    }

    private static void test8() {
        Clock clock = Clock.systemUTC();
        System.out.println("clock"+clock);
        ZoneId zone = clock.getZone();
        System.out.println("zone"+zone);
        System.out.println("default clock"+Clock.systemDefaultZone());
    }

    private static void test7() {
        LocalDate date = LocalDate.now();
        LocalDate plus = date.plus(32, ChronoUnit.DAYS);
        System.out.println("day, "+date);
        System.out.println("after 32day, "+plus);
        LocalDate plus1 = date.plus(-300, ChronoUnit.DAYS);
        LocalDate minus = date.minus(300, ChronoUnit.DAYS);
        System.out.println("300day before"+plus1);
        System.out.println("300day before"+minus);
    }

    private static void test6() {
        LocalTime time = LocalTime.now();
        System.out.println();
        System.out.println("当前时间:"+time);
        LocalTime plus = time.plus(2, ChronoUnit.HOURS);
        System.out.println("2h后，"+plus);
    }

    private static void test5() {
        LocalDate today = LocalDate.now();
        LocalDate dateOfBirth = LocalDate.of(2018, 01, 4);
        MonthDay birthday = MonthDay.of(dateOfBirth.getMonth(), dateOfBirth.getDayOfMonth());
        MonthDay currentMonthDay = MonthDay.from(today);
        if(currentMonthDay.equals(birthday)){
            System.out.println("Many Many happy returns of the day !!");
        }else{
            System.out.println("Sorry, today is not your birthday");
        }
    }

    private static void test4() {
        LocalDate now = LocalDate.now(),today = LocalDate.of(2020,1,4);
        System.out.println();
        System.out.println(now.equals(today));

    }

    private static void test3() {
        LocalDate date = LocalDate.of(2019,1,2);
        System.out.println();
        System.out.printf("%d  %d  %d",date.getYear(),date.getMonth().getValue(),date.getDayOfMonth());
    }

    private static void test2() {
        LocalDate date = LocalDate.now();
        System.out.println();
        System.out.printf("%d  %d  %d",date.getYear(),date.getMonth().getValue(),date.getDayOfMonth());
    }

    private static void test1() {
        LocalDate now = LocalDate.now();
        System.out.println("now:"+now);
        Date date = new Date();
        System.out.println("now:"+date);
    }
}
