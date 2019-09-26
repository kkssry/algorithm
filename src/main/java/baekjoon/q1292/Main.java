package baekjoon.q1292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int first = sc.nextInt();
        int end = sc.nextInt();
        int[] numbers = new int[1001];
        initNumbers(numbers);
        printResult(numbers, first ,end);
    }

    private static void printResult(int[] numbers, int first, int end) {
        int sum = 0;
        for (int i = first; i <= end; i++) {
            sum += numbers[i];
        }
        System.out.println(sum);
    }

    private static void initNumbers(int[] numbers) {
        numbers[1] = 1;
        for (int i = 2; i <= 44; i++) {
            int first = ((i - 1) * i /2) + 1;
            int end = i * (i + 1) / 2;
            for (int j = first; j <= end; j++) {
                numbers[j] = i;
            }
        }
        for (int i = 991; i <= 1000 ; i++) {
            numbers[i] = 45;
        }
    }
}
