package com.syz.java.test.java8.date;

import java.time.*;
import java.time.chrono.HijrahDate;
import java.time.chrono.IsoChronology;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.util.TimeZone;

/**
 * @Author steven.sheng
 * @Date 2020/3/13/01311:17
 */
public class DateTest {
    public static void main(String[] args) {
//        testLocalDate();
//        testLocalTime();
        testInstant();
        testHijrahDate();
    }

    private static void testHijrahDate() {
        HijrahDate date  =
                HijrahDate.now().with(ChronoField.DAY_OF_MONTH,1)
                .with(ChronoField.MONTH_OF_YEAR,9);
        System.out.println("ramadan stats on "+ IsoChronology.INSTANCE.date(date)
        +" , and ends on " + IsoChronology.INSTANCE.date(date.with(TemporalAdjusters.lastDayOfMonth())));
    }

    private static void testInstant() {
        Instant now = Instant.now(Clock.systemDefaultZone());
        System.out.println(now);
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(Instant.now().atZone(zoneId));
        Instant instant = Instant.now(Clock.offset(Clock.systemDefaultZone(), Duration.ofHours(8)));
        System.out.println(instant);
        System.out.println(Instant.now().atZone(TimeZone.getDefault().toZoneId()));
    }

    private static void testLocalTime() {
        LocalTime time = LocalTime.of(13, 45, 20);
        System.out.println(time);
        int hour = time.getHour();
        System.out.println(hour);
        int minute = time.getMinute();
        System.out.println(minute);
        int second = time.getSecond();
        System.out.println(second);
        LocalDate date = LocalDate.parse("2014-03-18");
        System.out.println(date);
        LocalTime timeStr = LocalTime.parse("13:45:20");
        System.out.println(timeStr);
    }

    private static void testLocalDate() {

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate);
        localDate = LocalDate.of(2020,3,3);
        System.out.println(localDate);
        System.out.println(localDate.getMonth());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfMonth());
        System.out.println(localDate.getDayOfWeek());
        System.out.println(localDate.isLeapYear());
        LocalDate date = LocalDate.of(2014,3, 18);
        LocalDate date2 = date.withYear(2011);
        LocalDate date3 = date2.withDayOfMonth(25);
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9);

        date = date.with(temporal -> {
            DayOfWeek dow =
                    DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY){
                dayToAdd = 3;
            }
            else if(dow == DayOfWeek.SATURDAY){
                 dayToAdd = 2;
            }
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        System.out.println(date);
    }
}
