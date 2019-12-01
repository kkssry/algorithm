package baekjoon.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarEx6_년도와일을입력하면_그달의달력을출력 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();

        System.out.println("SU MO TU WE TH FR SA");
        Calendar date = Calendar.getInstance();
        date.set(year, month - 1, 1);

        int startDayOfWeek = date.get(Calendar.DAY_OF_WEEK) - 1;
        date.add(Calendar.MONTH, 1);
        date.add(Calendar.DATE, -1);
        int dateCount = date.get(Calendar.DATE);
        date.set(Calendar.DATE, 1);

        for (int i = 0; i < startDayOfWeek; i++) {
            System.out.print("   ");
        }

        for (int i = 0; i < dateCount; i++) {
            toString(date.get(Calendar.DATE));
            if (date.get(Calendar.DAY_OF_WEEK) % 7 == 0) {
                System.out.println();
            }
            date.add(Calendar.DATE, 1);
        }
    }

    private static void toString(int i) {
        System.out.print(String.format("%2d", i) + " ");
    }
}
