package programmers.school.week4;

import java.util.Arrays;

public class 도둑질 {
    public int solution(int[] money) {
        int answer = 0;

        if (money.length % 2 == 0) {
            return (int)countEven(money);
        }

        if (money.length % 2 == 1) {
            answer = (int)countOdd(money);
        }

        return answer;
    }

    private long countOdd(int[] money) {
        long[] dp = new long[4];
        int moneyCount = money.length;
        for (int i = 0; i < moneyCount; ++i) {
            if (i % 2 == 0 && i < moneyCount - 3) {
                dp[0] += money[i];
                dp[1] += money[i];
            }

            if (i == moneyCount - 3) {
                dp[0] += money[i];
            }

            if (i == moneyCount - 2) {
                dp[1] += money[i];
                dp[2] += money[i];
            }

            if (i % 2 == 1 && i < moneyCount-2) {
                dp[2] += money[i];
                dp[3] += money[i];
            }

            if (i == money.length -1) {
                dp[3] += money[i];
            }
        }
        System.out.println(Arrays.toString(dp));
        return Arrays.stream(dp).max().getAsLong();
    }


    private long countEven(int[] money) {
        long answer;
        long[] dp = new long[2];
        for (int i = 0; i < money.length; i++) {
            if (i % 2 == 0) {
                dp[0] += money[i];
            }
            if (i % 2 == 1) {
                dp[1] += money[i];
            }
        }
        answer = dp[0] <= dp[1] ? dp[1] : dp[0];
        return answer;
    }
}
