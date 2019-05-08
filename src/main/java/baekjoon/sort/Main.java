package baekjoon.sort;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] nums = new int[input];
        for (int i = 0; i < input; i++) {
            nums[i] = Integer.parseInt(br.readLine());
        }

        int min = 0;
        callAverage(nums);
        callCenterValue(nums);
        min = callMostCount(nums);
        callRange(nums, min);
    }

    private static void callAverage(int[] nums) {
        System.out.println(Math.round(Arrays.stream(nums).average().getAsDouble()));
    }

    private static void callCenterValue(int[] nums) {
        int[] arr = Arrays.stream(nums).sorted().toArray();
        int center = nums.length / 2;
        System.out.println(arr[center]);
    }

    private static int callMostCount(int[] nums) {          // 빈도수
        Map<Integer, Integer> map = new HashMap<>();
        int findMin = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if (findMin > nums[i]) {
                findMin = nums[i];
            }
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
                continue;
            }
            map.put(nums[i], map.get(nums[i]) + 1);
        }

        int[] arr = map.values().stream().mapToInt(i -> i).sorted().toArray();
        int lastIndex = arr.length - 1;

        List<Integer> list = new ArrayList<>();
        for (Integer key : map.keySet()) {
            if (map.get(key) == arr[lastIndex]) {
                list.add(key);
            }
        }

        Collections.sort(list);
        if (list.size() == 1) {
            System.out.println(list.get(0));
        } else {
            System.out.println(list.get(1));
        }

        return findMin;
    }

    private static void callRange(int[] nums, int min) {
        int max = Arrays.stream(nums).max().getAsInt();
        System.out.println(max - min);
    }
}
