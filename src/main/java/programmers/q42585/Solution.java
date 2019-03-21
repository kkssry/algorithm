package programmers.q42585;

import java.util.Stack;

public class Solution {
    public int solution(String arrangement) {
        int answer = 0;

        Stack<String> stack = new Stack<>();
        String[] arr = arrangement.split("");

        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("(")) {
                stack.push("(");
            } else {
                if (i == arr.length - 1) {
                    answer += 1;
                    return answer;
                }
                if (arr[i - 1].equals(")")) {
                    stack.pop();
                    answer += 1;
                } else {
                    stack.pop();
                    answer += stack.size();
                }
            }

        }

        return answer;
    }
}
