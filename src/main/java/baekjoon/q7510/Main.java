package baekjoon.q7510;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        String[] results = new String[count];
        initResults(results, sc);
        printResults(results);
    }

    private static void printResults(String[] results) {
        for (int i = 0; i < results.length; i++) {
            System.out.println("Scenario #" + (i + 1) + ":");
            System.out.println(results[i]);
            System.out.println();
        }
    }

    private static void initResults(String[] results, Scanner sc) {
        for (int i = 0; i < results.length; i++) {
            results[i] = saveResult(sc);
        }
    }

    private static String saveResult(Scanner sc) {
        int[] triangleLengths = new int[3];
        for (int i = 0; i < triangleLengths.length; i++) {
            triangleLengths[i] = sc.nextInt();
        }
        Arrays.sort(triangleLengths);
        boolean sameCase1 = Math.pow(triangleLengths[2], 2) == Math.pow(triangleLengths[0], 2) + Math.pow(triangleLengths[1], 2);
        boolean sameCase2 = triangleLengths[2] < triangleLengths[0] + triangleLengths[1];
        if (sameCase1 && sameCase2) {
            return "yes";
        }
        return "no";
    }
}
