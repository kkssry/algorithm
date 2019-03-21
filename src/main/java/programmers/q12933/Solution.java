package programmers.q12933;

import java.util.Collections;
import java.util.PriorityQueue;

public class Solution {
    public long solution(long n) {
        long answer = 0;

        String arr = n + "";
        String[] a = arr.split("");
        PriorityQueue<Long> queue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < a.length; i++) {

            queue.add(Long.parseLong(a[i]));
        }

        String b = "";

        while(!queue.isEmpty()) {
            b = b + queue.poll();
        }

        answer = Long.parseLong(b);
        return answer;
    }
}
