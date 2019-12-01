package baekjoon.calendar;

import java.time.*;

public class NewTimeEx2 {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2015, 12, 31);
        LocalTime time = LocalTime.of(12 ,34 , 56);

        LocalDateTime dt = LocalDateTime.of(date , time);

        ZoneId seoulId = ZoneId.of("Asia/Seoul");
        ZonedDateTime pastSeoulTime = dt.atZone(seoulId);

        ZonedDateTime seoulTime = ZonedDateTime.now();
        ZoneId newYorkId = ZoneId.of("America/New_York");
        ZonedDateTime nyTime = seoulTime.withZoneSameInstant(newYorkId);

        // ZonedDatetime -> OffsetDateTime
        OffsetDateTime odt = seoulTime.toOffsetDateTime();

        System.out.println(dt);
        System.out.println(seoulId);
        System.out.println(pastSeoulTime);
        System.out.println(seoulTime);
        System.out.println(nyTime);
        System.out.println(odt);

    }
}
