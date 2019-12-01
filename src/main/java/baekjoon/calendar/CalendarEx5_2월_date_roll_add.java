package baekjoon.calendar;

import java.util.Calendar;

public class CalendarEx5_2월_date_roll_add {
    public static void main(String[] args) {
        Calendar date = Calendar.getInstance();

        date.set(2015, 0, 31);
        System.out.println(toString(date));
        date.roll(Calendar.MONTH,1);
        System.out.println(toString(date));

        // 1월에서 1달을 더했을때 roll, add 모두 2월은 31일이 없으니 28일로 출력한다.
    }

    private static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH)+ 1) + "월 " + date.get(Calendar.DATE) + "일";
    }


}
