package programmers.school.week2;


public class 올바른괄호 {
    boolean solution(String s) {
        boolean answer = true;
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                sum++;
            }
            else {
                if (sum == 0) {
                    return false;
                }
                --sum;
            }
        }

        if (sum > 0) {
            return false;
        }

        return answer;
    }
}
