package baekjoon.q1300;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        long[][] arr = new long[input][input];

        for (int i = 0; i < arr.length; i++) {
            int first = i + 1;
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = first * (j + 1);
            }
        }

        long[] result = Arrays.stream(arr).flatMapToLong(Arrays::stream).sorted().toArray();
        int st = Integer.parseInt(br.readLine());
        System.out.println(result[st-1]);

    }
}
