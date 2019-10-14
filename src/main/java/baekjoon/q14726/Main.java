package baekjoon.q14726;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        executeTest(count, br, bw);
        bw.flush();
    }

    private static void executeTest(int count, BufferedReader br, BufferedWriter bw) throws IOException {
        for (int i = 0; i < count; i++) {
            int[] nums = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            changeNum(nums);
            judgeResult(nums, bw);
        }
    }

    private static void judgeResult(int[] nums, BufferedWriter bw) throws IOException {
        int sum = IntStream.of(nums).sum();
        if (sum % 10 == 0) {
            bw.write("T\n");
        } else {
            bw.write("F\n");
        }
    }

    private static void changeNum(int[] nums) {
        int sum;
        int tmp;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                tmp = nums[i] * 2;
                if (tmp >= 10) {
                    String[] arr = String.valueOf(tmp).split("");
                    sum = Integer.parseInt(arr[0]) + Integer.parseInt(arr[1]);
                    nums[i] = sum;
                } else {
                    nums[i] = tmp;
                }
            }
        }
    }


}
