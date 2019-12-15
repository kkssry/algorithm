package baekjoon.q2753;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        LocalDate targetDate = LocalDate.of(year,1,1);
        if (targetDate.isLeapYear()) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
