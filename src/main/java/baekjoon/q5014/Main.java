package baekjoon.q5014;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] numbers = new int[5];
        initNumbers(numbers, sc);
        if (numbers[1] == numbers[2]) {
            System.out.println(0);
            return;
        }
        String result = saveResult(numbers);
        System.out.println(result);
    }

    private static String saveResult(int[] numbers) {
        boolean[] isChecked = new boolean[numbers[0] + 1];
        isChecked[numbers[1]] = true;
        Queue<Number> queue = new LinkedList<>();
        queue.add(new Number(numbers[1], 0));

        while (!queue.isEmpty()) {
            Number targetNumber = queue.poll();
            if (targetNumber.value == numbers[2]) {
                return String.valueOf(targetNumber.count);
            }

            for (int i = 3; i < 5; i++) {
                int nextFloor = targetNumber.value + numbers[i];
                if (0 <= nextFloor && nextFloor <= numbers[0] && !isChecked[nextFloor]) {
                    isChecked[nextFloor] = true;
                    queue.add(new Number(nextFloor, targetNumber.count + 1));
                }
            }
        }
        return "use the stairs";
    }

    private static void initNumbers(int[] numbers, Scanner sc) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        numbers[4] = numbers[4] * -1;
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
