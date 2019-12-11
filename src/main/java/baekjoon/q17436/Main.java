package baekjoon.q17436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] decimals = new int[count];
        long number = sc.nextLong();
        initDecimals(decimals, sc);
        long sum = 0;
        sum = firstSum(decimals, number);
        long minusSum = minusSum(decimals, number);
        System.out.println(sum - minusSum);
    }

    private static long minusSum(int[] decimals, long number) {
        int sum = 0;
        for (int i = 0; i < decimals.length - 1; i++) {
            sum += number / (decimals[i] * decimals[i + 1]);
        }
        return sum;
    }

    private static long firstSum(int[] decimals, long number) {
        long sum = 0;
        for (int decimal : decimals) {
            sum += number / decimal;
        }
        return sum;
    }

    private static void initDecimals(int[] decimals, Scanner sc) {
        for (int i = 0; i < decimals.length; i++) {
            decimals[i] = sc.nextInt();
        }
    }
}
