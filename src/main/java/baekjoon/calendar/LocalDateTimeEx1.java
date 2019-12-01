package baekjoon.calendar;

import java.time.*;
import java.util.HashMap;
import java.util.Map;

public class LocalDateTimeEx1 {
    public static void main(String[] args) {
//        LocalDate date = LocalDate.now();
//        LocalTime  time = LocalTime.now();
//
//        System.out.println(date);
//        System.out.println(time);
//
//        LocalDateTime localDateTime = LocalDateTime.now();
//        ZonedDateTime dateTimeInkr = ZonedDateTime.now();
//
//        System.out.println(localDateTime);
//        System.out.println(dateTimeInkr);


//      !!!! map에서 키에 해당하는 밸류값을 1증가 시켜고자 하는 방법 2가지
        Map<Integer, Integer> map = new HashMap<>();

        // 0 1 2 3 4 5 6 7 8 9
        // 0 1 2 0 1 2 0 1 2 0 (키값)

        for (int i = 0; i < 10; i++) {
            int rest = i % 3;

//          방법 1. getOrdefault메서드 활용
            map.put(rest, map.getOrDefault(rest, 0) + 1);

/*
            방법 2. putIfAbsent + computeIfPresent
            putIfAbsent 메서드 로 키값이 없을시 초기화 셋팅을 해주었다.
            computeIfPresent 메서드로 키가 있을시 해당 밸류값을 +1 증가 시켰다.


            if (map.get(rest) == null) {
                map. putIfAbsent(rest,1);
                continue;
            }
            int value1 = map.computeIfPresent(rest, (Integer key, Integer value)->++value);
            map.put(rest, value1);
*/
        }
        System.out.println(map);    // {0=4, 1=3, 2=3}
    }
}
