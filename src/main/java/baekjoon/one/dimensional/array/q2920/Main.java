package baekjoon.q2920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] nums = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();


        checkDescending(nums);
        checkAscending(nums);
        checkMixed(nums);
    }

    private static void checkMixed(int[] nums) {
        if (list.size() == 0) {
            System.out.println("mixed");
        }
    }

    private static void checkAscending(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] - nums[i + 1] != -1) {
                return;
            }
        }
        list.add(1);
        System.out.println("ascending");
    }

    private static void checkDescending(int[] nums) {
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] - nums[i + 1] != 1) {
                return;
            }
        }
        list.add(1);
        System.out.println("descending");
    }
}
