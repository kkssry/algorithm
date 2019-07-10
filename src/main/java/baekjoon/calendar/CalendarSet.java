package baekjoon.calendar;

import java.util.Calendar;

public class CalendarSet {
    public static void main(String[] args) {
        Calendar cal = Calendar.getInstance();
        cal.set(2019,0,31);
        System.out.println(toString(cal));
        cal.roll(Calendar.MONTH, 1);
        System.out.println(toString(cal));

    }

    private static String toString(Calendar cal) {

        return  cal.get(Calendar.YEAR) + "년 " +
                (cal.get(Calendar.MONTH)+1) + "월 " +
                cal.get(Calendar.DATE) + "일";
    }
}
