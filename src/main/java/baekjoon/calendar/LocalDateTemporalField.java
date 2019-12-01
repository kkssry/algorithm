package baekjoon.calendar;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;

import static java.time.temporal.ChronoField.*;

public class LocalDateTemporalField {
    public static void main(String[] args) {
        LocalDate today = LocalDate.now();
        LocalDate today2 = LocalDate.now();

        today = today.withYear(2018);

        System.out.println(today.isEqual(today2));
        System.out.println(today.equals(today2));


    }
}
