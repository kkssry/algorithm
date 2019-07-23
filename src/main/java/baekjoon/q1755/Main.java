package baekjoon.q1755;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> numberAndEnglish = new HashMap<>();
        initNumberAndEnglish(numberAndEnglish);

        Scanner sc = new Scanner(System.in);
        int[] nums = new int[2];
        iniNums(nums, sc);
        Arrays.sort(nums);

        int length = Math.subtractExact(nums[1], nums[0]) + 1;
        Number[] numbers = new Number[length];
        initNumbers(nums, numbers, numberAndEnglish);
        Arrays.sort(numbers);

        printResult(numbers);
    }

    private static void printResult(Number[] numbers) {
        StringBuilder sb = new StringBuilder();
        int[] changeDtypeNumber = Arrays.stream(numbers).mapToInt(number->number.value).toArray();
        for (int i = 0; i < changeDtypeNumber.length; i++) {
            if (i / 10 > 0 && i % 10 == 0) {
                sb.append("\n");
            }
            if (i % 10 == 9) {
                sb.append(changeDtypeNumber[i]);
                continue;
            }
            sb.append(changeDtypeNumber[i]);
            sb.append(" ");
        }
        System.out.println(sb.toString());
    }

    private static void initNumberAndEnglish(Map<Integer, String> numberAndEnglish) {
        numberAndEnglish.put(0, "zero");
        numberAndEnglish.put(1, "one");
        numberAndEnglish.put(2, "two");
        numberAndEnglish.put(3, "three");
        numberAndEnglish.put(4, "four");
        numberAndEnglish.put(5, "five");
        numberAndEnglish.put(6, "six");
        numberAndEnglish.put(7, "seven");
        numberAndEnglish.put(8, "eight");
        numberAndEnglish.put(9, "nine");
    }

    private static void initNumbers(int[] nums, Number[] numbers, Map<Integer, String> numberAndEnglish) {
        for (int i = nums[0]; i <= nums[1]; i++) {
            int index = i - nums[0];
            String[] tenOne = initTenOne(i, numberAndEnglish);
            if (tenOne[0] == null) {
                tenOne[0] = "";
            }
            numbers[index] = new Number(i, tenOne[0] + tenOne[1]);
        }
    }

    private static String[] initTenOne(int num, Map<Integer, String> numberAndEnglish) {
        String[] tenOne = new String[2];
        int oneSeat = num % 10;
        tenOne[1] = numberAndEnglish.get(oneSeat);
        if (num > 9) {
            int tenSeat = num / 10;
            tenOne[0] = numberAndEnglish.get(tenSeat);
        }
        return tenOne;
    }

    private static void iniNums(int[] nums, Scanner sc) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
    }


    static class Number implements Comparable<Number> {
        int value;
        String fullName;


        Number(int value, String fullName) {
            this.value = value;
            this.fullName = fullName;
        }

        @Override
        public int compareTo(Number o) {
            return fullName.compareTo(o.fullName);
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", fullName='" + fullName + '\'' +
                    '}';
        }
    }
}
