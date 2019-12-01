package baekjoon.calendar;

import java.time.*;

public class LocalDateTimeEx2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015 ,11, 23);
        LocalTime time = LocalTime.of(23, 59, 59);
        System.out.println(date);
        System.out.println(time);

        LocalDateTime dateTime = LocalDateTime.of(date, time);
        ZonedDateTime zDateTime = ZonedDateTime.of(date, time, ZoneId.of("Asia/Seoul"));
        System.out.println(dateTime);
        System.out.println(zDateTime);

    }
}
