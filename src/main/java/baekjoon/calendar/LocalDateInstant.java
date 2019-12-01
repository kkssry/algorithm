package baekjoon.calendar;

import java.time.*;

public class LocalDateInstant {
    public static void main(String[] args) {
        Instant now = Instant.now();
        System.out.println(LocalDateTime.now());
        System.out.println(Instant.now());
        System.out.println(Instant.ofEpochSecond(now.getEpochSecond()));
        System.out.println(Instant.ofEpochSecond(now.getEpochSecond(), now.getNano()));

        System.out.println("/////////////////////////////////////////////////");

        LocalDateTime dateTime = LocalDateTime.now();       // LocalDateTime + ZoneId --> ZoneDateTime
        ZoneId zid = ZoneId.of("Asia/Seoul");
        ZonedDateTime zdt = dateTime.atZone(zid);
        System.out.println(zdt);

        ZonedDateTime zdt2 = LocalDate.now().atStartOfDay(zid);
        System.out.println(zdt2);
    }
}
