package programmers.q12927;

import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] works) {
        if (Arrays.stream(works).sum() < n) {
            return 0;
        }

        int max = Arrays.stream(works).max().getAsInt();
        loop:
        while (true) {
            for (int j = 0; j < works.length; j++) {
                if (works[j] == max) {
                    works[j]--;
                    n -= 1;
                }

                if (n == 0) {
                    break loop;
                }
            }
            max -= 1;
        }

//        int length = works.length;

//        for (int j = 0; j < n; j++) {               // 감소할때 마다 정렬하니 시간초과
//            Arrays.sort(works);
//            works[length - 1]--;
//        }

        return Arrays.stream(works).mapToLong(i -> i * i).sum();
    }
}
