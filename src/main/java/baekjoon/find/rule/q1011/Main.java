package baekjoon.find.rule.q1011;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] results = new int[input];

        for (int i = 0; i < input; i++) {
            results[i] = callFunc(Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
        }
        Arrays.stream(results).forEach(System.out::println);
    }

    private static int callFunc(int[] nums) {
        int difference = nums[1] - nums[0];
        if (difference == 1) {
            return 1;
        }
        int resultNum;
        int coreNum = ReturnCoreNum(difference);
        resultNum = coreNum + (coreNum - 1);
        if (difference <= calculateExecuteCount(coreNum)) {
            return resultNum - 1;
        }
        return resultNum;
    }

    private static int ReturnCoreNum(int difference) {
        int coreNum = -1;
        for (int i = 2; i < difference; i++) {
            if (difference <= Math.pow(i,2)) {
                coreNum = i;
                break;
            }
        }
        return coreNum;
    }

    private static long calculateExecuteCount(int coreNum) {
        return coreNum * (coreNum - 1);
    }
}
