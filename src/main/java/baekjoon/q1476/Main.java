package baekjoon.q1476;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] targetNums = new int[3];
        intTargetNums(targetNums,sc);
        int result = saveResult(targetNums);
        System.out.println(result);
    }

    private static void intTargetNums(int[] targetNums, Scanner sc) {
        for (int i = 0; i < targetNums.length; i++) {
            targetNums[i] = sc.nextInt();
        }
    }

    private static int saveResult(int[] result) {
        int count = 0;
        int[] planetYear = new int[3];
        do {
            for (int i = 0; i < planetYear.length; i++) {
                planetYear[i]++;
            }
            checkNewYear(planetYear);
            count++;

        } while (!checkCompleteMatch(planetYear, result));
        return count;
    }

    private static void checkNewYear(int[] planetYear) {
        if (planetYear[0] > 15) {
            planetYear[0] = 1;
        }
        if (planetYear[1] > 28) {
            planetYear[1] = 1;
        }

        if (planetYear[2] > 19) {
            planetYear[2] = 1;
        }
    }

    private static boolean checkCompleteMatch(int[] planetYear, int[] result) {
        for (int i = 0; i < planetYear.length; i++) {
            if (planetYear[i] != result[i]) {
                return false;
            }
        }
        return true;
    }
}
