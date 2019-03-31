package programmers.q12938;

import java.util.Arrays;

public class Solution {
    public int[] solution(int n, int s) {
        int[] answer = {};

        if (n > s) {
            return new int[]{-1};
        }

        if (n == s) {
            for (int i = 0; i < n; i++) {
                answer[i] = 1;
            }
            return answer;
        }

        int mock = s/n;
        answer = new int[n];

        for (int i = 0; i < n; i++) {
            answer[i] = mock;
        }

        int restCount = s - (n * mock);
        for (int i = 0; i < restCount; i++) {
            answer[i]++;
        }

        Arrays.sort(answer);
        System.out.println(Arrays.toString(answer));
        return answer;
    }
}
