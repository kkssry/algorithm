package baekjoon.q10844;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[][] numsEachCount = new int[101][10];
        int result = 0;

        numsEachCount[1][0] = 0;
        for (int i = 1; i <= 8; i++) {
            numsEachCount[1][i] = 1;
        }
        numsEachCount[1][9] = 1;

        for (int i = 2; i <= input; i++) {
            numsEachCount[i][0] = numsEachCount[i-1][1] % 1000000000;
            for (int j = 1; j <= 8; j++) {
                numsEachCount[i][j] = ((numsEachCount[i-1][j - 1] % 1000000000) + (numsEachCount[i-1][j + 1] % 1000000000)) % 1000000000;
            }
            numsEachCount[i][9] = numsEachCount[i-1][8] % 1000000000;
        }

        for (int i = 0; i < 10; i++) {
            result = (result + numsEachCount[input][i]) % 1000000000;
        }

        System.out.println(result);
    }
}
