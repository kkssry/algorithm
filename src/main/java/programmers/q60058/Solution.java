package programmers.q60058;

import java.util.Stack;

public class Solution {
    public String solution(String p) {
        String answer = "";
        StringBuilder sb = new StringBuilder();

        if (isCorrectBracket(p)) {
            answer = p;
            return answer;
        }

        answer = productCorrectBracket(p, sb);

        return answer;
    }

    private boolean isCorrectBracket(String p) {
        Stack<Character> stack = new Stack<>();
        for (char c : p.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private String productCorrectBracket(String w, StringBuilder sb) {
        if (w.isEmpty()) {
            return "";
        }

        int index = balancedBracketIndex(w);
        String u = w.substring(0, index + 1);
        String v = w.substring(index + 1);

        if (isCorrectBracket(u)) {
            sb.append(u);
            productCorrectBracket(v, sb);
        } else {
            sb.append('(');
            productCorrectBracket(v, sb);
            sb.append(')');
            addBracket(u, sb);
        }

        return sb.toString();
    }

    private void addBracket(String u, StringBuilder sb) {
        String firstRemoveBrackets = u.substring(1);
        String cuttingBrackets = firstRemoveBrackets.substring(0,firstRemoveBrackets.length() - 1);
        for (char c : cuttingBrackets.toCharArray()) {
            if (c==')') {
                sb.append('(');
            } else {
                sb.append(')');
            }
        }
    }

    private int balancedBracketIndex(String w) {
        int[] bracketCounts = new int[2];
        int index = w.length() - 1;
        for (int i = 0; i < w.length(); i++) {
            char ch = w.charAt(i);
            if (ch == '(') {
                bracketCounts[0]++;
                if (compare(bracketCounts)) {
                    return i;
                }
            } else {
                bracketCounts[1]++;
                if (compare(bracketCounts)) {
                    return i;
                }
            }
        }
        return index;
    }

    private boolean compare(int[] bracketCounts) {
        return bracketCounts[0] > 0 && bracketCounts[0] == bracketCounts[1];
    }
}
