package baekjoon.q11053;

import java.util.*;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numberCount = sc.nextInt();
        Number[] numbers = new Number[numberCount];
        initNumbers(numbers, sc);
        initCountFromFront(numbers);
        initCountFromBack(numbers);
        initTotal(numbers);
        System.out.println(Arrays.stream(numbers).mapToInt(number->number.total).max().getAsInt() - 1);
    }

    private static void initTotal(Number[] numbers) {
        for (Number number : numbers) {
            number.total = number.countFromFront + number.countFromBack;
        }
    }

    private static void initCountFromBack(Number[] numbers) {
        for (int i = numbers.length - 2; i >= 0; i--) {
            Number compareNumber  = numbers[i];
            int maxCount = 0;
            for (int j = numbers.length - 1; j > i; j--) {
                Number targetNumber = numbers[j];
                if (compareNumber.value > targetNumber.value && maxCount < numbers[j].countFromBack) {
                    maxCount = targetNumber.countFromBack;
                    compareNumber.countFromBack = targetNumber.countFromBack + 1;
                }
            }
        }

    }


    private static void initCountFromFront(Number[] numbers) {
        for (int i = 1; i < numbers.length; i++) {
            int compareValue  = numbers[i].value;
            Optional<Number> maybeNumber = Stream.of(numbers).limit(i)
                                .filter(number -> number.value < compareValue)
                                .max(Comparator.comparingInt(o -> o.countFromFront));
            if (maybeNumber.isPresent()) {
                numbers[i].countFromFront = maybeNumber.get().countFromFront + 1;
            }
        }
    }

    private static void initNumbers(Number[] numbers, Scanner sc) {
        for (int i = 0; i < numbers.length; i++) {
            int numberValue = sc.nextInt();
            numbers[i] = new Number(numberValue);
        }
    }

    static class Number {
        int value;
        int countFromFront = 1;
        int countFromBack = 1;
        int total;

        Number(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return countFromBack +" ";
        }
    }

}
