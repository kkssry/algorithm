package baekjoon.q10867;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Set<Integer> nums = new TreeSet<>();
        int[] number = new int[count];
        iniNumber(number, scanner);
        removeDuplicate(number, nums);
        String[] result = new String[nums.size()];
        saveResult(result, nums);
    }

    private static void saveResult(String[] result, Set<Integer> nums) {
        int i = 0;
        for (Integer num : nums) {
            result[i++] = num+"";
        }
        System.out.println(String.join(" ",result));
    }

    private static void removeDuplicate(int[] number, Set<Integer> nums) {
        for (int i = 0; i < number.length; i++) {
            nums.add(number[i]);
        }
    }

    private static void iniNumber(int[] number, Scanner scanner) {
        for (int i = 0; i < number.length; i++) {
            number[i] = scanner.nextInt();
        }
    }
}
