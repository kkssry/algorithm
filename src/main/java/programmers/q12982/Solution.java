package programmers.q12982;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        int rest = budget;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < d.length; i++) {
            queue.add(d[i]);
        }
        System.out.println(queue);

        while(rest > 0) {
            if (queue.isEmpty() || rest < queue.peek() ) {
                break;
            }
            rest -= queue.poll();
            answer++;
        }

        return answer;
    }
}
