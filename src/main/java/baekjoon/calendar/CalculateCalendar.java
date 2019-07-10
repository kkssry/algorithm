package baekjoon.calendar;

import java.util.Calendar;
import java.util.Scanner;

public class CalculateCalendar {
    public static void main(String[] args) {
        //년도 와 달을 입력 받아서 달력 출력
        Scanner sc = new Scanner(System.in);
        Calendar cal = Calendar.getInstance();
        int year = sc.nextInt();
        int month = sc.nextInt();
        cal.set(year,month - 1,1);

        printWeek();
        int startDayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
        int lastDay = cal.getActualMaximum(Calendar.DATE);
        printDay(startDayOfWeek, lastDay);

    }

    private static void printDay(int startDayOfWeek, int lastDay) {
        for (int i = 0; i < startDayOfWeek - 1; i++) {          // 처음 요일 공백
            System.out.print("   ");
        }

        int start  = 1;
        int nextLine;

        for (int i = startDayOfWeek; i <= 7 ; i++) {            // 첫째줄 출력
            System.out.print(setFormat(start));
            start++;
            if (i != 7) {
                System.out.print(" ");
            }
        }

        System.out.println();
        nextLine = start - 1;

        for (int i = start; i <= lastDay; i++) {
            System.out.print(setFormat(i));
            if (i % 7 == nextLine) {
                System.out.println();
                continue;
            }
                System.out.print(" ");
        }

    }

    private static String setFormat(int day) {
        return String.format("%2d", day);
    }

    private static void printWeek() {
        System.out.println("SU MO TU WE TH FR SA");
    }
}
