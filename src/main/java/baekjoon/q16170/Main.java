package baekjoon.q16170;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class Main {
    public static void main(String[] args) {
        ZonedDateTime utcDateTime = ZonedDateTime.now(ZoneId.of("UTC"));
        System.out.println(utcDateTime.getYear());
        System.out.println(utcDateTime.getMonth().getValue());
        System.out.println(utcDateTime.getDayOfMonth());
    }
}
