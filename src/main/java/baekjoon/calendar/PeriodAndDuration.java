package baekjoon.calendar;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.time.chrono.ChronoLocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;

public class PeriodAndDuration {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.of(2014 , 1, 1);
        LocalDate date2 = LocalDate.of(2015 , 12, 31);

        LocalTime time1 = LocalTime.of(00,00,00);
        LocalTime time2 = LocalTime.of(12,34,56);

        Period pe = Period.between(date1, date2);                   // 날짜 차이
        Duration du = Duration.between(time1, time2);               // 시간 차이

        System.out.println(pe.getUnits());
        System.out.println(du.getUnits());

        long hour = du.getSeconds() / 3600;
        long min = (du.getSeconds() - hour * 3600) / 60;
        long sec = (du.getSeconds() - hour * 3600 - min * 60) % 60;
        int nano = du.getNano();

        LocalTime tmpTime = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
        int hour2 = tmpTime.getHour();
        int min2 = tmpTime.getMinute();
        int sec2 = tmpTime.getSecond();
        int nano2 = tmpTime.getNano();

        LocalDate today = LocalDate.now();
        ChronoLocalDate myBirthDay = LocalDate.of(1991, 10 , 31);
        Period pe3 = today.until(myBirthDay);
        long dday = today.until(myBirthDay, ChronoUnit.DAYS);




    }
}
