package baekjoon.q4307;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCount = Integer.parseInt(br.readLine());
        String[] result = new String[testCount];
        saveResult(br, testCount, result);
        Arrays.stream(result).forEach(System.out::println);
    }

    private static void saveResult(BufferedReader br, int testCount, String[] result) throws IOException {
        for (int i = 0; i < testCount; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int ropeLength = arr[0];
            int[] ants = new int[arr[1]];
            initAnts(ants, br);
            Arrays.sort(ants);
            int[] maxAndMin = calculateMaxAndMin(ants, ropeLength);
            result[i] = maxAndMin[0] + " " + maxAndMin[1];
        }
    }

    private static int[] calculateMaxAndMin(int[] ants, int ropeLength) {
        int[] minAndMax = new int[2];
        minAndMax[0] = Integer.MIN_VALUE;
        minAndMax[1] = Integer.MIN_VALUE;
        for (int i = 0; i < ants.length; i++) {
            int thisMax = Math.max(ants[i], ropeLength - ants[i]);
            int thisMin = Math.min(ants[i], ropeLength - ants[i]);
            comparisonValue(minAndMax, thisMax, thisMin);
        }
        return minAndMax;
    }

    private static void comparisonValue(int[] minAndMax, int thisMax, int thisMin) {
        minAndMax[0] = Math.max(minAndMax[0], thisMin);
        minAndMax[1] = Math.max(minAndMax[1], thisMax);
    }

    private static void initAnts(int[] ants, BufferedReader br) throws IOException {
        for (int i = 0; i < ants.length; i++) {
            ants[i] = Integer.parseInt(br.readLine());
        }
    }
}
