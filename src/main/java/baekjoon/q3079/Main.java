package baekjoon.q3079;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int checkerCount = sc.nextInt();
        long peopleCount = sc.nextLong();
        int[] checkers = new int[checkerCount];
        initCheckers(checkers, sc);
        long result = saveResult(checkers, peopleCount);
        if (result > 0) {
            result -= 1;
        }
        detail(result, checkers, peopleCount);
    }

    private static void detail(long result, int[] checkers, long peopleCount) {
        long result2 = result;
        while (true) {
            if (saveSum(result2, checkers, peopleCount)) {
                System.out.println(result2);
                return;
            }
            result2 += 1;
        }
    }

    private static long saveResult(int[] checkers, long peopleCount) {
        long low = 0;
        long high = Long.MAX_VALUE;
        long mid;

        while (low < high) {
            mid = (low + high) / 2;
            if (saveSum(mid, checkers, peopleCount)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private static boolean saveSum(long mid, int[] checkers, long peopleCount) {
        long sum = 0;
        for (int checker : checkers) {
            sum += mid / checker;
            if (sum >= peopleCount) {
                return true;
            }
        }
        return false;
    }

    private static void initCheckers(int[] checkers, Scanner sc) {
        for (int i = 0; i < checkers.length; i++) {
            checkers[i] = sc.nextInt();
        }
    }
}
