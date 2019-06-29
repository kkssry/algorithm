package baekjoon.q1912;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        initNums(nums, sc);
        saveMaxValue(nums);
    }

    private static void saveMaxValue(int[] nums) {
        int max  = nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i], nums[i] + nums[i - 1]);
            if (max < nums[i]) {
                max = nums[i];
            }
        }
        System.out.println(max);
    }

    private static void initNums(int[] nums, Scanner sc) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
    }
}
