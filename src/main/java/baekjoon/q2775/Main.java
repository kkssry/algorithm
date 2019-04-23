package baekjoon.q2775;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] corrects = new int[input];

        int[][] tests = new int[input][];

        for (int i = 0; i < tests.length; i++) {
            int floor = Integer.parseInt(br.readLine());
            int part = Integer.parseInt(br.readLine());
            tests[i] = new int[]{floor, part};
        }

        for (int i = 0; i < tests.length; i++) {
            findCorrect(tests[i][0], tests[i][1], corrects, i);
        }

        Arrays.stream(corrects).forEach(System.out::println);
    }

    private static void findCorrect(int floor, int part, int[] corrects, int at) {
        int[][] find = new int[floor + 1][part];

        for (int i = 0; i < find.length; i++) {
            for (int j = 0; j < find[i].length; j++) {
                if (i == 0) {
                    find[i][j] = j + 1;
                    continue;
                }

                if (j == 0) {
                    find[i][j] = j + 1;
                    continue;
                }

                for (int k = 0; k <= j; k++) {
                    find[i][j] += find[i - 1][k];
                }
            }
        }

        System.out.println(Arrays.deepToString(find));

        corrects[at] = find[floor][part - 1];
    }
}
