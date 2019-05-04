package baekjoon.q2156;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] inputs = new int[input];

        for (int i = 0; i < input; i++) {
            inputs[i] = Integer.parseInt(br.readLine());
        }

        if (input == 1) {
            System.out.println(inputs[0]);
            return;
        }


        Wine[][] dp = new Wine[input][3];

        for (int i = 0; i < input; i++) {
            if (i == 0) {
                dp[i][0] = new Wine(inputs[i],0,1);
                dp[i][1] = new Wine(-1,-1,-1);
                dp[i][2] = new Wine(-1,-1,-1);
            }

            if (i == 1) {
                int current = inputs[i];
                dp[i][0] = new Wine(dp[i - 1][0].amount + current, 1,1);
                dp[i][1] = new Wine(inputs[i],0,2);
                dp[i][2] = new Wine(-1,-1,-1);
            }

            if (i > 1) {
                int current = inputs[i];
                dp[i][0] = new Wine(Arrays.stream(dp[i - 2]).max(Comparator.comparingInt(o -> o.amount)).get().amount + current, -1, 2);      // 전전에서 최댓값 : 이것의 출처는 의미없으므로 -1
                dp[i][1] = new Wine(Arrays.stream(dp[i - 1]).filter(wine->wine.to >= 2).max(Comparator.comparingInt(o -> o.amount)).get().amount + current,2,1);
                dp[i][2] = new Wine(-1,-1,-1);
                if (i > 2) {
                    dp[i][2] = new Wine(Arrays.stream(dp[i - 3]).max(Comparator.comparingInt(o -> o.amount)).get().amount + current, -1, 2);
                }
            }
        }


        int last = Arrays.stream(dp[input - 1]).max(Comparator.comparingInt(o -> o.amount)).get().amount;
        int secondLast = Arrays.stream(dp[input - 2]).max(Comparator.comparingInt(o -> o.amount)).get().amount;
        System.out.println(Math.max(last,secondLast));
    }

    static class Wine {
        int amount;
        int from;
        int to;

        public Wine(int amount, int from, int to) {
            this.amount = amount;
            this.from = from;
            this.to = to;
        }

        @Override
        public String toString() {
            return "grapeCup{" +
                    "amount=" + amount +
                    ", from=" + from +
                    ", to=" + to +
                    '}';
        }
    }
}
