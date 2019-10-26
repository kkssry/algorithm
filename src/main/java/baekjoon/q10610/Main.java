package baekjoon.q10610;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num = sc.nextLine();
        if (!num.contains("0")) {
            System.out.println(-1);
            return;
        }

        String[] arr = num.split("");
        int[] nums = new int[arr.length];
        initNums(nums, arr);
        if(!isThreeMultiple(nums)) {
            System.out.println(-1);
            return;
        }

        List<Integer> list = new ArrayList<>();
        int zeroCount = saveResult(nums, list);
        list.sort(Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        initSb(list, zeroCount, sb);
        System.out.println(sb.toString());
    }

    private static void initNums(int[] nums, String[] arr) {
        for (int i = 0; i < arr.length; i++) {
            nums[i] = Integer.parseInt(arr[i]);
        }
    }

    private static void initSb(List<Integer> list, int zeroCount, StringBuilder sb) {
        for (Integer integer : list) {
            sb.append(integer);
        }
        for (int i = 0; i < zeroCount; i++) {
            sb.append(0);
        }
    }

    private static int saveResult(int[] nums, List<Integer> list) {
        int zeroCount = 0;
        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            }
            if (num > 0) {
                list.add(num);
            }
        }
        return zeroCount;
    }

    private static boolean isThreeMultiple(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        int mock = sum / 3;
        int rest = sum % 3;
        return mock > 0 && rest == 0;
    }
}
