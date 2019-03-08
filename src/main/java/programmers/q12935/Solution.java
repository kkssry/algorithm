package programmers.q12935;

import java.util.PriorityQueue;

public class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {-1};
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i1 : arr) {
            queue.add(i1);
        }

        queue.poll();

        if (queue.isEmpty()) {
            return answer;
        }

        answer = new int[queue.size()];

        for (int i = answer.length - 1; i > -1; --i) {
            answer[i] = queue.peek();
            queue.poll();
        }

        return answer;

    }
}
