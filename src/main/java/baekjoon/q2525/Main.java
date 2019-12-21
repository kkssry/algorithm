package baekjoon.q2525;

import org.assertj.core.util.Sets;

import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int minute = sc.nextInt();
        int cookTime = sc.nextInt();

        LocalTime localTime = LocalTime.of(hour, minute).plus(Duration.ofMinutes(cookTime));
        String time = localTime.format(DateTimeFormatter.ofPattern("H m"));
        System.out.println(time);
    }
}
