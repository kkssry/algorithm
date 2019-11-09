package baekjoon.q9610;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dotCount = sc.nextInt();
        int[] coordinates = new int[5];
        for (int i = 0; i < dotCount; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            if (x > 0 && y > 0) {
                coordinates[0]++;
            }
            if (x < 0 && y > 0) {
                coordinates[1]++;
            }
            if (x < 0 && y < 0) {
                coordinates[2]++;
            }
            if (x > 0 && y < 0) {
                coordinates[3]++;
            }
            if (x == 0 || y == 0) {
                coordinates[4]++;
            }
        }
        saveResult(coordinates);
    }

    private static void saveResult(int[] coordinates) {
        for (int i = 0; i < coordinates.length - 1; i++) {
            System.out.println("Q" + (i+1) +": " + coordinates[i]);
        }
        System.out.println("AXIS: " + coordinates[coordinates.length-1]);
    }
}
