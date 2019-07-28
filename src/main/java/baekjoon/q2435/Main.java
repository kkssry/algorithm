package baekjoon.q2435;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int days = sc.nextInt();
        int duringDays = sc.nextInt();

        int[] temperature = new int[days];
        initTemperature(temperature, sc);
        int newDaysLength = days-duringDays + 1;
        int[] newDays = new int[newDaysLength];
        saveDuringDaysTemprature(newDays, temperature, duringDays);
        System.out.println(IntStream.of(newDays).max().getAsInt());
    }

    private static void initTemperature(int[] temperature, Scanner sc) {
        for (int i = 0; i < temperature.length; i++) {
            temperature[i] = sc.nextInt();
        }
    }

    private static void saveDuringDaysTemprature(int[] newDays, int[] temperature, int duringDays) {
        for (int i = 0; i < newDays.length; i++) {
            for (int j = i; j < i + duringDays; j++) {
                newDays[i] += temperature[j];
            }
        }
    }
}
