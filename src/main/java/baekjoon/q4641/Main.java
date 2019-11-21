package baekjoon.q4641;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        while (!input.equals("-1")) {
            int[] nums = Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
            saveResult(nums, bw);
            input = br.readLine();
        }

        bw.flush();
    }

    private static void saveResult(int[] nums, BufferedWriter bw) throws IOException {
        int count = 0;
        for (int num : nums) {
            int doubleValue = num * 2;
            for (int i : nums) {
                if (doubleValue == i) {
                    count++;
                    break;
                }
            }
        }
        bw.write(Integer.toString(count - 1));
        bw.newLine();
    }
}
