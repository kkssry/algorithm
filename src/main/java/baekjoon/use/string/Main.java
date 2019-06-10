package baekjoon.use.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = initInput(br);
        int[] results = countValue(input);
        Arrays.stream(results).forEach(System.out::println);
    }

    private static int[] countValue(int input) {
        String[] values = (input + "").split("");
        int[] results = new int[10];

        for (int i = 0; i < values.length; i++) {
            int numValue = Integer.parseInt(values[i]);
            results[numValue]++;
        }
        return results;
    }

    private static int initInput(BufferedReader br) throws IOException {
        int[] input = new int[3];
        for (int i = 0; i < 3; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        return multiplyInput(input);
    }

    private static int multiplyInput(int[] input) {
        return Arrays.stream(input).reduce(1,(a,b)->a*b);
    }
}
