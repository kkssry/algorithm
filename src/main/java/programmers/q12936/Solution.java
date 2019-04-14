package programmers.q12936;

import java.util.*;

public class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        List<Integer> list = new LinkedList<>();
        int index = 0;

        if (n == 2) {
            if ((int) k == 1) {
                return new int[]{1, 2};
            }
            return new int[]{2, 1};
        }

        long fac = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            fac *= i;
        }

        while (k > 0) {
            fac /= n--;
            long findFirstIndex = k / fac;
            k %= fac;
            if (k == 0) {
                findFirstIndex--;
            }

            answer[index] = list.get((int)findFirstIndex);
            list.remove((int)findFirstIndex);

            index++;

        }


        if (k == 0) {
            Collections.reverse(list);
        }

//        System.out.println(list);

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] == 0) {
                answer[i] = list.get(0);
                list.remove(0);
            }
        }

//        System.out.println(Arrays.toString(answer));

        return answer;
    }

}

