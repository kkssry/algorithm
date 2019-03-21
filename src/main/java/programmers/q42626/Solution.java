package programmers.q42626;

import java.util.PriorityQueue;

public class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        int min;

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i1 : scoville) {
            queue.add(i1);
        }

        while (queue.peek() < K) {
            min = 0;
            min += queue.poll();
            min += queue.poll()*2;
            queue.add(min);
            answer++;
            if (queue.size() == 1 && queue.peek() < K) {
                return -1;
            }
        }
        return answer;
    }
}
