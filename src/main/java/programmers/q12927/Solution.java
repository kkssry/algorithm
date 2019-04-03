package programmers.q12927;


import java.util.Arrays;

public class Solution {
    public long solution(int n, int[] works) {
        long answer = 0;

        if (Arrays.stream(works).sum() < n) {
            return 0;
        }

        while (n != 0) {
            int diff;
            Arrays.sort(works);
            int max = works[works.length - 1];
            boolean flag = false;
            for (int i = works.length - 2; i >= 0; i--) {
                diff = max - works[i];
                if (diff > 0) {
                    flag = true;
                    if (diff > n) {
                        works[works.length -1] -= n;
                        n = 0;
                    } else {
                        works[works.length -1] -= diff;
                        n -= diff;
                    }
                    break;
                }
            }

            if (!flag) {
                if (works.length < n) {
                    int mock = n / works.length;
                    for (int i = 0; i < works.length; i++) {
                        works[i] = works[i] - mock;
                    }
                    n-= mock * works.length;
                    for (int i = 0; i < n; i++) {
                        --works[i];
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        --works[i];
                    }
                }
                n=0;
            }
        }


        for (int i = 0; i < works.length; i++) {
            answer += (works[i] * works[i]);
        }

        return answer;

    }
}
