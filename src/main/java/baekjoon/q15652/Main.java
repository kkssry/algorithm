package baekjoon.q15652;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] numbers = new int[count];
        initNumbers(numbers);
        Arrays.sort(numbers);
        int resultCount = sc.nextInt();
        int[] results = new int[resultCount];
        int st = 0;
        int previousIndex = 0;
        saveResult(numbers, results, st, previousIndex);
    }

    private static void saveResult(int[] numbers, int[] results, int st, int previousIndex) {
        if (results.length == st) {
            System.out.println(printResult(results));
            return;
        }

        for (int i = previousIndex; i < numbers.length; i++) {
            results[st] = numbers[i];
            saveResult(numbers, results, st + 1, i);
        }
    }

    private static String printResult(int[] results) {
        StringBuilder sb = new StringBuilder();
        for (int result : results) {
            sb.append(result).append(" ");
        }
        return sb.toString();
    }

    private static void initNumbers(int[] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
    }
}
