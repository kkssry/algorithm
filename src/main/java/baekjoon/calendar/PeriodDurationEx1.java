package baekjoon.calendar;

import java.time.Duration;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class PeriodDurationEx1 {
    public static void main(String[] args) {
        Period pe = Period.of(1, 12, 31);
        Duration du = Duration.of(60, ChronoUnit.SECONDS);

        pe = pe.withYears(2);           // 1년 -> 2년
        du = du.withSeconds(120);       // 60초 -> 120초

        pe = Period.of(1,13,32).normalized();
    }
}
