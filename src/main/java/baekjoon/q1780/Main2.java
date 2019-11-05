package baekjoon.q1780;

import java.io.*;
import java.util.Arrays;

public class Main2 {
    public static int[][] one;
    public static int[] result = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        one = new int[input][input];

        for (int i = 0; i < one.length; i++) {
            one[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        divide(0, input - 1, 0, input - 1, input);

        Arrays.stream(result).forEach(System.out::println);
    }

    private static void divide(int rowStartIndex, int rowEndIndex, int ColumnStartIndex, int columnEndIndex, int length) {
        if (isSame(rowStartIndex, rowEndIndex, ColumnStartIndex, columnEndIndex)) {
            result[one[rowStartIndex][ColumnStartIndex] + 1]++;
            return;
        }

        length /=3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(rowStartIndex + j * length, rowStartIndex + (j + 1) * length - 1,
                        ColumnStartIndex + i * length, ColumnStartIndex + (i + 1) * length - 1, length);
            }
        }
    }

    private static boolean isSame(int rowStartIndex, int rowEndIndex, int ColumnStartIndex, int columnEndIndex) {
        int firstNUm = one[rowStartIndex][ColumnStartIndex];
        for (int i = rowStartIndex; i <= rowEndIndex; i++) {
            for (int j = ColumnStartIndex; j <= columnEndIndex; j++) {
                if (firstNUm != one[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
