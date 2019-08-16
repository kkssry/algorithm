package baekjoon.q2981;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        int[] numbers = new int[numberCount];
        initNumbers(numbers, sc);
        List<Integer> difference = new ArrayList<>();
        initDifference(numbers, difference);
        saveMaxCommonNumber(difference);
    }

    private static void saveMaxCommonNumber(List<Integer> difference) {
        int gcp = 0;
        if (difference.size() == 1) {
            gcp = difference.get(0);
        }

        if (difference.size() > 1) {
            gcp = euclidsMethod(difference.get(0), difference.get(1));
        }

        for (int i = 2; i < difference.size(); i++) {
            gcp = euclidsMethod(gcp, difference.get(i));
        }

        saveResult(gcp);
    }

    private static void saveResult(int gcp) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 2; i <= gcp; i++) {
            if (gcp % i == 0) {
                numbers.add(i);
            }
        }
        String result = numbers.stream().map(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    private static int euclidsMethod(Integer first, Integer second) {
        int max = Math.max(first, second);
        int min = Math.min(first, second);

        int rest;
        while ((rest = max % min) != 0) {
            max = min;
            min = rest;
        }
        return min;
    }

    private static void initDifference(int[] numbers, List<Integer> difference) {
        for (int i = 0; i < numbers.length - 1; i++) {
            difference.add(Math.abs(numbers[i] - numbers[i + 1]));
        }
    }


    private static void initNumbers(int[] numbers, Scanner sc) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }
}
