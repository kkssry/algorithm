package programmers.school.week3;

import java.util.PriorityQueue;

public class 더맵게 {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> pr = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pr.add(scoville[i]);
        }

        while(pr.peek() < K) {
            if (pr.size() == 1) {
                return -1;
            }
            answer = callScovile(pr,K,answer);
        }

        return answer;
    }

    private int callScovile(PriorityQueue<Integer> pr, int k,int answer) {
        if (pr.peek() < k) {
            int first = pr.poll();
            int secod = pr.poll();
            int sum = first + (secod * 2);
            pr.add(sum);
            answer++;
        }
        return answer;
    }
}
