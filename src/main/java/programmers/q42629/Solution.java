package programmers.q42629;

import java.util.*;

public class Solution {
    public int solution(int stock, int[] dates, int[] supplies, int k) {
        int answer = 0;
        int rest = stock;
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < dates.length; i++) {
            map.put(dates[i],supplies[i]);
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 1; i < k; i++) {
            while (rest <= i) {
                if (queue.isEmpty()) {
                    break;
                }
                rest += queue.poll();
                answer++;
            }
            if (map.containsKey(i)) {
                 queue.add(map.get(i));
            }

        }

        return answer;
    }
}
