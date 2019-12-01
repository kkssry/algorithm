package baekjoon.calendar;

import java.util.Calendar;

public class CalendarEx3_Hour_minute_seconds {
    public static void main(String[] args) {
        final int[] Time_UNIT = {3600, 60, 1};
        final String[] TIME_UNIT_NAME = {"시간", "분", "초"};

        Calendar time1 = Calendar.getInstance();
        Calendar time2 = Calendar.getInstance();

        time1.set(Calendar.HOUR_OF_DAY, 10);        // 10시 20분 30초
        time1.set(Calendar.MINUTE, 20);
        time1.set(Calendar.SECOND, 30);


        time2.set(Calendar.HOUR_OF_DAY, 20);        // 20시 30분 10초
        time2.set(Calendar.MINUTE, 30);
        time2.set(Calendar.SECOND, 10);

        System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "시 " + time1.get(Calendar.MINUTE) + "분 " + time1.get(Calendar.SECOND));
        System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "시 " + time2.get(Calendar.MINUTE) + "분 " + time2.get(Calendar.SECOND));

        long difference = Math.abs(time1.getTimeInMillis() - time2.getTimeInMillis()) / 1000;
        System.out.println("time1 과 time2의 차이는 " + difference + "초 입니다.");

        String tmp = "";
        for (int i = 0; i < Time_UNIT.length; i++) {
            tmp += difference / Time_UNIT[i] + TIME_UNIT_NAME[i];
            difference %= Time_UNIT[i];
        }

        System.out.println("시분 초로 변환하면 " + tmp + "입니다. ");
    }
}

