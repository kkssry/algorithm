package baekjoon.q2579;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        int[] inputs = new int[input];

        for (int i = 0; i < input; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        Number[][] dp = new Number[input][2];

        for (int i = 0; i < inputs.length; i++) {
            if (i == 0) {
                dp[i] = new Number[]{new Number(inputs[i], 0, 1)};
            }

            if (i == 1) {
                dp[i] = new Number[]{new Number(inputs[i - 1] + inputs[i], 1, 1), new Number(inputs[i], 0, 2)};
            }

            if (i > 1) {
                int num1 = Arrays.stream(dp[i - 1]).filter(p -> p.to == 2).mapToInt(number -> number.value).sum();
                int num2 = Arrays.stream(dp[i - 2]).max(Comparator.comparingInt(o -> o.value)).get().value;

                dp[i] = new Number[]{new Number(num1 + inputs[i], 2, 1), new Number(num2 + inputs[i], 2, 2)};
            }
        }

        int maxNum = Arrays.stream(dp[input - 1]).max(Comparator.comparingInt(o -> o.value)).get().value;
        System.out.println(maxNum);
    }

    static class Number {
        int value;
        int from;
        int to;

        public Number(int value, int from, int to) {
            this.value = value;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "Number{" +
                    "value=" + value +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }
}
