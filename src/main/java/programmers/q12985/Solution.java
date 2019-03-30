package programmers.q12985;

public class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;
        int first = a;
        int second = b;

        while (first!=second) {
                if (first % 2 == 0) {
                    first /= 2;
                } else {
                    first = (first + 1) /2;
                }

                if (second % 2 == 0) {
                    second /= 2;
                } else {
                    second = (second + 1) / 2;
                }
            answer++;
        }

        return answer;
    }
}
