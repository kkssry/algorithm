package programmers.q12946;

public class Solution {
    int count = 0;

    public int[][] solution(int n) {
        int[][] answer;
        answer = new int[(int) Math.pow(2, n) - 1][2];

        int[] path = new int[2];

        hanoi(n, 1, 2, 3, answer);

        return answer;
    }

    private void hanoi(int n, int from, int by, int to, int[][] answer) {
        if (n == 1) {
            answer[count][0] = from;
            answer[count][1] = to;
            count++;
        } else {
            hanoi(n - 1, from, to, by, answer);
            answer[count][0] = from;
            answer[count][1] = to;
            count++;
            hanoi(n - 1, by, from, to, answer);
        }
    }
}
