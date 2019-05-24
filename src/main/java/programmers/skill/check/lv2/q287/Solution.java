package programmers.skill.check.lv2.q287;

public class Solution {
    boolean solution(String s) {
        boolean answer = true;

        if (s.length() % 2 ==1) {
            return false;
        }


        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {
                count--;
            }
            if (count < 0) {
                return  false;
            }
        }

        if (count != 0) {
            return false;
        }

        return answer;
    }
}
