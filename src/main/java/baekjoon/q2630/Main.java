package baekjoon.q2630;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int[][] one;
    public static int[] results = new int[2];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        one = new int[input][input];
        for (int i = 0; i < input; i++) {
            one[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        divide(0, input - 1, 0, input - 1, input);
        Arrays.stream(results).forEach(System.out::println);
    }

    private static void divide(int rowStartIndex, int rowEndIndex, int columnStartIndex, int columnEndIndex, int length) {
        if (isSame(rowStartIndex, rowEndIndex, columnStartIndex, columnEndIndex)) {
            results[one[rowStartIndex][columnStartIndex]]++;
            return;
        }

        length /= 2;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                divide(rowStartIndex + j * length, rowStartIndex + (j + 1) * length -1,
                        columnStartIndex + i * length, columnStartIndex + (i + 1) * length -1, length
                );
            }
        }
    }

    private static boolean isSame(int rowStartIndex, int rowEndIndex, int columnStartIndex, int columnEndIndex) {
        int firstNum = one[rowStartIndex][columnStartIndex];
        for (int i = rowStartIndex; i <= rowEndIndex; i++) {
            for (int j = columnStartIndex; j <= columnEndIndex; j++) {
                if (firstNum != one[i][j]) {
                    return false;
                }

            }
        }
        return true;
    }
}
