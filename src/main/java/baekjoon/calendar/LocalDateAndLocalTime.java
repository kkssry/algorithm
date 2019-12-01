package baekjoon.calendar;

import java.time.LocalDate;
import java.time.LocalTime;


public class LocalDateAndLocalTime {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalTime now = LocalTime.now();
        System.out.println(today);
        System.out.println(now);

        System.out.println(today.getMonth().getValue());
        System.out.println(today.getDayOfWeek().getValue());
        System.out.println(today.lengthOfMonth());
        System.out.println(today.lengthOfYear());
        System.out.println(today.isLeapYear());

    }
}
