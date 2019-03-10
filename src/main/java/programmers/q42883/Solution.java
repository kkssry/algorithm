package programmers.q42883;

import java.util.PriorityQueue;

public class Solution {
    public String solution(String number, int k) {
        String answer = "";

        PriorityQueue<Integer> queue = new PriorityQueue<>();

        String[] numbers = number.split("");
        for (int i = 0; i < numbers.length; i++) {
            queue.add(Integer.parseInt(numbers[i]));
        }

        for (int i = 0; i < k; i++) {
            queue.poll();
        }



        return answer;
    }
}
