package baekjoon.bfs.dfs.q1890;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int length = inputLength(br);
        int[][] square = new int[length][length];
        initSquare(square, br);
        long optimizeCount = saveMinimumCount(square);
        printResult(optimizeCount);
    }

    private static long saveMinimumCount(int[][] square) {
        long[][] counts = new long[square.length][square.length];
        counts[0][square[0][0]]++;
        counts[square[0][0]][0]++;
        for (int i = 0; i < square.length; i++) {
            for (int j = 0; j < square[i].length; j++) {
                if (counts[i][j] != 0) {
                    if (i == square.length - 1 && j == square.length - 1) {
                        break;
                    }

                    if (j + square[i][j] < square.length ) {       // 오른쪽
                        counts[i][j + square[i][j]]+=counts[i][j];
                    }

                    if (i + square[i][j] < square.length ) {        // 아래
                        counts[i + square[i][j]][j]+=counts[i][j];
                    }
                }
            }
        }
        return counts[square.length - 1][square.length - 1] ;
    }

    private static void initSquare(int[][] square, BufferedReader br) throws IOException {
        for (int i = 0; i < square.length; i++) {
            square[i] = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        }
    }

    private static int inputLength(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    private static void printResult(long optimizeCount) {
        System.out.println(optimizeCount);
    }

}
