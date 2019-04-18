package programmers.q12907;

import java.util.Arrays;

public class Solution {
    int answer = 0;

    public int solution(int n, int[] money) {

        Arrays.sort(money);
        int[] moneyCount = new int[money.length];
        int[] num = new int[1];
        num[0] = n;


        for (int i = money.length - 1; i >= 0; i--) {
            moneyCount[i] = n / money[i];
        }

        recursive(moneyCount, money, n, moneyCount.length - 1);

        return answer;
    }


    private void recursive(int[] moneyCount, int[] money, int n, int currentIndex) {
        System.out.println("n : " + n + "currentIndex : " + currentIndex);

        if (currentIndex == -1) {
            if (n == 0) {
                answer++;
            }
            return;
        }

        for (int i = moneyCount[currentIndex]; i >= 0; i--) {
            n -= moneyCount[currentIndex] * money[currentIndex];
            recursive(moneyCount, money, n, currentIndex - 1);
            n += moneyCount[currentIndex] * money[currentIndex];
        }

    }


}
