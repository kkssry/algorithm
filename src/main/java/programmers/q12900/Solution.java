package programmers.q12900;

public class Solution {
    public int solution(int n) {
        long answer;
        answer = fibonacci(n);
        return (int) answer;
    }

    private long fibonacci(int n) {
        long one = 1;
        long two = 1;
        long result = -1;
        if (n <= 2) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            result = (one + two) % 1000000007;
            one = two;
            two = (int) result;
        }
        return result;
    }
}
