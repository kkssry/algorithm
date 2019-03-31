package programmers.q12927;


import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int sum = 0;

        for (int i = 0; i < works.length; i++) {
            sum += works[i];
        }

        if (sum < n) {
            return 0;
        }

        while (n != 0) {
            Arrays.sort(works);
            --works[works.length - 1];
            --n;
        }

        for (int i = 0; i < works.length; i++) {
            answer += works[i] * works[i];
        }

        return answer;
    }

}
