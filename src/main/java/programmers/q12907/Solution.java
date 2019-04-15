package programmers.q12907;

public class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        int hunter = 1;

        for (int i = 0; i < money.length; i++) {
            if (hunter < money[i]) {
                break;
            }
            hunter += money[i];
            answer++;
        }

        if (hunter == 1) {
            if (n % money[0] == 0) {
                return 1;
            }
            return 0;
        }
        answer = hunter;
        return answer;
    }
}
