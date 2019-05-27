package programmers.q1654;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] nums = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long[] lanLine = new long[(int) nums[0]];
        inputLanLine(lanLine, br);

        long totalLength = Arrays.stream(lanLine).sum();
        long binaryMax = totalLength / nums[1];
        calculateMaxLanline(binaryMax, nums[1], lanLine);
    }

    private static void calculateMaxLanline(long binaryMax, long wantValue, long[] lanLine) {
        long left = 1;
        long right = binaryMax;
        long mid;
        while (left <= right) {
            mid = callMid(left, right);
            long count = calculateCount(mid, lanLine);
            if (isExceedWantValue(count, wantValue)) {
                right = mid - 1;
                continue;
            }
            left = mid + 1;
        }

        System.out.println(right);
    }


    private static boolean isExceedWantValue(long count, long wantValue) {
        return count < wantValue;
    }

    private static long calculateCount(long mid, long[] lanLine) {
        long count = 0;
        for (int i = 0; i < lanLine.length; i++) {
            count += lanLine[i] / mid;
        }
        return count;
    }

    private static long callMid(long left, long right) {
        return left + (right - left) / 2;
    }

    private static void inputLanLine(long[] lanLine, BufferedReader br) throws IOException {
        for (int i = 0; i < lanLine.length; i++) {
            lanLine[i] = Integer.parseInt(br.readLine());
        }
    }
}
