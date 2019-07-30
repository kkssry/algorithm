package baekjoon.q1697;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Number subinNumber = new Number(sc.nextInt(), 0);
        Number subinSisterNumber = new Number(sc.nextInt(), 0);
        boolean[] isCheck = new boolean[100001];
        if (subinNumber.value > subinSisterNumber.value) {
            System.out.println(subinNumber.value - subinSisterNumber.value);
            return;
        }
        int reuslt = calculateResult(subinNumber, subinSisterNumber, isCheck);
        System.out.println(reuslt);
    }

    private static int calculateResult(Number subinNumber, Number subinSisterNumber, boolean[] isCheck) {
        int resultCount = 0;
        Queue<Number> numbers = new LinkedList<>();
        numbers.add(subinNumber);
        while (!numbers.isEmpty()) {
            Number number = numbers.poll();
            int comparisonValue = number.value;

            if (comparisonValue > 100000 || comparisonValue < 0) {
                continue;
            }

            if (number.value == subinSisterNumber.value) {
                resultCount = number.count;
                break;
            }

            findSister(number, isCheck, numbers);
        }

        return resultCount;
    }

    private static void findSister(Number number, boolean[] isCheck, Queue<Number> numbers) {
        int comparisonValue = number.value;
        int jumpBack = comparisonValue - 1;
        int jump = comparisonValue + 1;
        int teleport = comparisonValue * 2;
        int nextCount = number.count + 1;

        move(jump,isCheck, nextCount, numbers);
        move(jumpBack, isCheck, nextCount, numbers);
        move(teleport, isCheck, nextCount, numbers);
    }

    private static void move(int moveDistance, boolean[] isCheck, int nextCount, Queue<Number> numbers) {
        if (isSafeLimit(moveDistance) && !isCheck[moveDistance]) {
            numbers.add(new Number(moveDistance, nextCount));
            isCheck[moveDistance] = true;
        }
    }

    private static boolean isSafeLimit(int value) {
        return value <= 100000 && value >= 0;
    }

    static class Number {
        int value;
        int count;

        Number(int value, int count) {
            this.value = value;
            this.count = count;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", count=" + count +
                    '}';
        }
    }
}
