package programmers.q12987;

import java.util.*;

public class Solution {
    int answer = 0;
    public int solution(int[] A, int[] B) {

        Arrays.sort(A);
        Arrays.sort(B);

        Stack<Integer> sA = new Stack<>();
        Stack<Integer> sB = new Stack<>();

        for (int i = 0; i < A.length; i++) {
            sA.push(A[i]);
            sB.push(B[i]);
        }

        while(!sA.isEmpty()) {
            if (sA.peek() < sB.peek()) {
                sB.pop();
                answer++;
            }
            sA.pop();
        }

        return answer;
    }

}
