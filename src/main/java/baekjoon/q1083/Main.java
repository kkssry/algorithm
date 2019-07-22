package baekjoon.q1083;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int amountOfNumer = sc.nextInt();
        int[] numbers = new int[amountOfNumer];
        initNumbers(numbers, sc);
        List<Integer> list = new LinkedList<>();
        initList(list, numbers);

        int[] amountOfSwapOpportunity = new int[1];
        amountOfSwapOpportunity[0] = sc.nextInt();

        startSwap(list, amountOfSwapOpportunity);
        System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    private static void initList(List<Integer> list, int[] numbers) {
        for (int number : numbers) {
            list.add(number);
        }
    }

    private static void startSwap(List<Integer> list, int[] amountOfSwapOpportunity) {
        int i = 0;
        while (i < list.size() && amountOfSwapOpportunity[0] > 0 && !isNoSwap(list)) {
            seekSwapNumber(list, i, amountOfSwapOpportunity);
            i++;
        }
    }

    private static void seekSwapNumber(List<Integer> list, int targetStartIndex, int[] amountOfSwapOpportunity) {
        int max = findMaxvalue(list, targetStartIndex, amountOfSwapOpportunity);
        int maxValueIndex = findMaxIndex(list, targetStartIndex, max, amountOfSwapOpportunity);
        if (maxValueIndex == targetStartIndex) {
            return;
        }
        amountOfSwapOpportunity[0] -= (maxValueIndex - targetStartIndex);
        int maxValue = list.get(maxValueIndex);
        list.remove(maxValueIndex);
        list.add(targetStartIndex, maxValue);
    }

    private static int findMaxvalue(List<Integer> list, int targetStartIndex, int[] amountOfSwapOpportunity) {
        int max = Integer.MIN_VALUE;
        int roundsCount = initRoundsCount(amountOfSwapOpportunity, list.size());
        int range = initRange(targetStartIndex, roundsCount, list.size());

        for (int i = targetStartIndex; i <= range; i++) {
            int value = list.get(i);
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    private static boolean isNoSwap(List<Integer> list) {
        boolean isNoSwap = true;
        for (int i = 0; i < list.size() - 1; i++) {
            int pre = list.get(i);
            int post = list.get(i + 1);
            if (isSwapAble(pre, post)) {
                isNoSwap = false;
                break;
            }
        }
        return isNoSwap;
    }

    private static int findMaxIndex(List<Integer> list, int targetStartIndex, int max, int[] amountOfSwapOpportunity) {
        int maxValueIndex = 0;
        int roundsCount = initRoundsCount(amountOfSwapOpportunity, list.size());
        int range = initRange(targetStartIndex, roundsCount, list.size());

        for (int i = targetStartIndex; i <= range; i++) {
            int value = list.get(i);
            if (max == value) {
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }

    private static int initRange(int targetStartIndex, int roundsCount, int size) {
        int range = targetStartIndex + roundsCount;
        if (size  <= range) {
            range = size - 1;
        }
        return range;
    }

    private static int initRoundsCount(int[] amountOfSwapOpportunity, int size) {
        int roundsCount = amountOfSwapOpportunity[0];
        if (amountOfSwapOpportunity[0] >= size - 1) {
            roundsCount = size - 1;
        }
        return roundsCount;
    }

    private static boolean isSwapAble(int pre, int post) {
        return pre < post;
    }

    private static void initNumbers(int[] numbers, Scanner sc) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
    }
}
