package programmers.q42629;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int rest = stock;
        PriorityQueue<Integer> supplyQueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < k; i++) {
           for (int t = 0; t < dates.length; t++) {
                if (dates[t] == i) {
                    supplyQueue.add(supplies[t]);
                }
            }

           if (rest < k ) {
               rest += supplyQueue.poll();
               answer++;
           }

        }

        return answer;
    }
}
