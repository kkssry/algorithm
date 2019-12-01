package baekjoon.calendar;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class LocalDateTimeEx3 {
    public static void main(String[] args) {
        LocalTime now = LocalTime.now();
        int minute = now.getMinute();
        int minute2 = now.get(ChronoField.MINUTE_OF_HOUR);
        System.out.println(minute);
        System.out.println(minute2);

        LocalDate today = LocalDate.now();
        LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
        LocalDate tomorrow2 = today.plusDays(1);
        System.out.println(tomorrow);
        System.out.println(tomorrow2);



    }
}
