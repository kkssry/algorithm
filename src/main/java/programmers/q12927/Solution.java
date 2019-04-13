package programmers.q12927;


import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;
        int length = works.length;

//        if (works.length == 1) {
//            while (n != 0) {
//                return works[0] - n;
//            }
//        }

        for (int j = 0; j < n; j++) {
            int maxIndex = 0;
            int maxValue = 0;
            for (int i = 0; i < works.length; i++) {
                if (maxValue < works[i]) {
                    maxValue = works[i];
                    maxIndex = i;
                }
            }
            if (works[maxIndex] == 0) {
                return 0;
            }
            works[maxIndex]--;
        }

        for (int i = 0; i < works.length; i++) {
            answer += (works[i] * works[i]);
        }

        return answer;

    }
}
