package programmers.q12973;

import java.util.*;

public class Solution {
    public int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }
            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }
            stack.push(s.charAt(i));
        }

        if (stack.isEmpty()) {
            return 1;
        }


        return answer;
    }
}
