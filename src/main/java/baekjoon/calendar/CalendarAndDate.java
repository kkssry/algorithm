package baekjoon.calendar;

import java.util.Calendar;
import java.util.Date;

public class CalendarAndDate {
    public static void main(String[] args) {
        //case 1 :
        // Calendar -> Date
        Calendar cal = Calendar.getInstance();
        Date date = new Date(cal.getTimeInMillis());
        System.out.println(date);

        //case 2 :
        // Date -> Calendar
        Calendar cal2 = Calendar.getInstance();
        Date d = new Date();
        cal2.setTime(d);          // date -> Calendar
        System.out.println(cal2);
    }
}
