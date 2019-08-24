package programmers.q17687;

import java.util.Stack;

public class Solution {
    public String solution(int n, int t, int m, int p) {
        int maxSize = t * m;
        StringBuilder sb = new StringBuilder();
        int number = 0;
        while (true) {
            Stack<String> stack = saveN(number, n);
            if (containSB(sb, stack, maxSize)) {
                break;
            }
            ++number;
        }
        return saveResult(m, p, sb);
    }

    private String saveResult(int m, int p, StringBuilder sb) {
        String totalLength = sb.toString();
        StringBuilder sb2 = new StringBuilder();
        int st = p % m;
        for (int i = 0; i < totalLength.length(); i++) {
            if ((i + 1) % m == st) {
                sb2.append(totalLength.charAt(i));
            }
        }
        return sb2.toString();
    }

    private boolean containSB(StringBuilder sb, Stack<String> stack, int maxSize) {
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
            if (sb.length() == maxSize) {
                return true;
            }
        }
        return false;
    }

    private Stack<String> saveN(int number, int n) {
        Stack<String> stack = new Stack<>();
        while (number / n != 0) {
            int rest = number % n;
            containStack(stack, rest);
            number /= n;
        }
        containStack(stack, number);
        return stack;
    }

    private void containStack(Stack<String> stack, int number) {
        if (number >= 10) {
            number += 55;
            System.out.println((char) number);
            stack.push(String.valueOf((char) number));
            return;
        }
        stack.push(String.valueOf(number));
    }
}
