package baekjoon.q1932;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        int[][] nums = new int[input][];
        initNums(nums);
        inputValueInNums(nums, sc);
        if (input == 1) {
            System.out.println(nums[0][0]);
            return;
        }
        saveMaxRoute(nums);

        System.out.println(Arrays.stream(nums[input - 1]).max().getAsInt());
    }

    private static void saveMaxRoute(int[][] nums) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                if (j == 0) {
                    nums[i][j] += nums[i - 1][j];
                    continue;
                }

                if (j == nums[i].length - 1) {
                    nums[i][j] += nums[i - 1][j - 1];
                    continue;
                }

                nums[i][j] += Math.max(nums[i - 1][j - 1], nums[i - 1][j]);
            }
        }
    }

    private static void inputValueInNums(int[][] nums, Scanner sc) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums[i].length; j++) {
                nums[i][j] = sc.nextInt();
            }
        }
    }

    private static void initNums(int[][] nums) {
        for (int i = 0; i < nums.length; i++) {
            nums[i] = new int[i+1];
        }
    }
}
