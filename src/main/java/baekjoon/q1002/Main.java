package baekjoon.q1002;

import java.io.*;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        int[] results = new int[testCount];
        runTest(testCount, results, br);
        IntStream.of(results).forEach(System.out::println);

    }

    private static void runTest(int testCount, int[] results, BufferedReader br) throws IOException {
        for (int i = 0; i < testCount; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            double twoPointDistance = calculateTwoPointDistance(arr[0], arr[3], arr[1], arr[4]);
            int sum = arr[2] + arr[5];
            int subtract = Math.abs(arr[2] - arr[5]);

            if (twoPointDistance == sum) {
                results[i] = 1;
            }
            if (twoPointDistance == 0 && (arr[2] == arr[5])) {
                results[i] = -1;
            }
            if (twoPointDistance != 0 && twoPointDistance == subtract) {
                results[i] = 1;
            }
            if (twoPointDistance < sum && twoPointDistance > subtract) {
                results[i] = 2;
            }
            if (twoPointDistance > sum) {
                results[i] = 0;
            }
            if (twoPointDistance < subtract) {
                results[i] = 0;
            }

        }
    }

    private static double calculateTwoPointDistance(int x1, int x2, int y1, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
