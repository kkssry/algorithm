package baekjoon.calendar;

import java.util.Calendar;

public class CalendarFeature {
    public static void main(String[] args) {
        //기본적으로 현재 날짜와 시간으로 설정 된다.
        Calendar cal = Calendar.getInstance();

        System.out.println("올해의 년도 : " + cal.get(Calendar.YEAR));
        System.out.println("월(0~11), [ex) 0 : 1월] : " + cal.get(Calendar.MONTH));
        System.out.println("올 해의 몇 째주 : " + cal.get(Calendar.WEEK_OF_YEAR));
        System.out.println("이 달의 몇 째주 : " + cal.get(Calendar.WEEK_OF_MONTH));

        System.out.println("---------------------------------------------------------");

        //DATE와 DAY_OF_MONTH는 같다.
        System.out.println("이 달의 몇 일 : " + cal.get(Calendar.DATE));
        System.out.println("이 달의 몇 일 : " + cal.get(Calendar.DAY_OF_MONTH));
        System.out.println("올 해의 몇 일 : " + cal.get(Calendar.DAY_OF_YEAR));
        System.out.println("요일(1~7), [ex) 1 : 일요일] : " + cal.get(Calendar.DAY_OF_WEEK));

        System.out.println("오전_오후 [ex) 0:오전, 1:오후] : " + cal.get(Calendar.AM_PM));
        System.out.println("시간(0~11) : " + cal.get(Calendar.HOUR));
        System.out.println("시간(0~23) : " + cal.get(Calendar.HOUR_OF_DAY));
        System.out.println("분(0~59) : " + cal.get(Calendar.MINUTE));
        System.out.println("초(0~59) : " + cal.get(Calendar.SECOND));
        System.out.println("1000분의 1초(밀리초) : " + cal.get(Calendar.MILLISECOND));

        System.out.println("---------------------------------------------------------");

        //천분의 1초를 시간으로 표시하기 위해 3600,000 으로 나누었다. (1시간 = 60 * 60초)
        System.out.println("TimeZone(-12~12) : " + cal.get(Calendar.ZONE_OFFSET));
        System.out.println("이 달의 마지막 : " + cal.getActualMaximum(Calendar.DATE));        //이 달의 마지막일


    }
}
