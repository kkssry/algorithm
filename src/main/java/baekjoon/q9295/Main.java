package baekjoon.q9295;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] results = new int[count];
        initResults(results, br);
        saveResult(results);
    }

    private static void saveResult(int[] results) {
        for (int i = 0; i < results.length; i++) {
            int st = i + 1;
            System.out.println("Case " + st + ": " + results[i]);
        }
    }

    private static void initResults(int[] results, BufferedReader br) throws IOException {
        for (int i = 0; i < results.length; i++) {
            int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            results[i] = arr[0] + arr[1];
        }
    }
}
