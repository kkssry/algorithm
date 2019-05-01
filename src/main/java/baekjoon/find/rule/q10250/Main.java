package baekjoon.find.rule.q10250;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] answers = new String[input];

        for (int i = 0; i < input; i++) {
            String[] arr = br.readLine().split(" ");
            int[] nums = Arrays.stream(arr).mapToInt(Integer::parseInt).toArray();
            answers[i] = callFunc(nums);
        }
        Arrays.stream(answers).forEach(System.out::println);
    }

    private static String callFunc(int[] nums) {
        int column = nums[0];
        int target = nums[2];

        int floor = target % column;
        int ho = target / column;

        if (floor == 0) {
            return String.format("%d%02d", column, ho);
        }
        return String.format("%d%02d", floor, ho + 1);

    }
}
