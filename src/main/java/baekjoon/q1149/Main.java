package baekjoon.q1149;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[][] houses = new int[input][3];

        for (int i = 0; i < input; i++) {
            houses[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        int[][] dp = new int[input][3];

        for (int i = 0; i < houses[0].length; i++) {
            dp[0][i] = houses[0][i];
        }

        for (int i = 1; i < houses.length; i++) {
            for (int j = 0; j < houses[i].length; j++) {
                if (j == 0) {
                    dp[i][j] = Math.min(dp[i - 1][j + 1], dp[i - 1][j + 2]) + houses[i][j];
                }

                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][j - 1], dp[i - 1][j + 1]) + houses[i][j];
                }

                if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][j - 2], dp[i - 1][j - 1]) + houses[i][j];
                }
            }
        }

        System.out.println(Arrays.stream(dp[dp.length - 1]).min().getAsInt());

    }
}
