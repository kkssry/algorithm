package baekjoon.q1731;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = sc.nextInt();
        }

        if (isSameplus(nums)) {
            int samePlus = nums[1] - nums[0];
            System.out.println(nums[count - 1] + samePlus);
            return;
        }

        int sameMultiply = nums[1] / nums[0];
        System.out.println(nums[count - 1] * sameMultiply);
    }

    private static boolean isSameplus(int[] nums) {
        boolean flag = true;
        int difference = nums[1] - nums[0];
        for (int i = 2; i < nums.length; i++) {
            if (difference  != nums[i] - nums[i - 1]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
