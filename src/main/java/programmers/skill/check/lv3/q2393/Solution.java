package programmers.skill.check.lv3.q2393;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] triangle) {
        int answer = 0;
        int[][] results = new int[triangle.length][];
        initResults(results, triangle);
        results[0][0] = triangle[0][0];
        saveResult(results, triangle);
        answer = Arrays.stream(results[triangle.length - 1]).max().getAsInt();
        return answer;
    }

    private void initResults(int[][] results, int[][] triangle) {
        for (int i = 0; i < triangle.length; i++) {
            results[i] = new int[triangle[i].length];
        }
    }

    private void saveResult(int[][] results, int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    results[i][j] = triangle[i][j] + results[i - 1][j];
                    continue;
                }
                if (j == i) {
                    results[i][j] = triangle[i][j] + results[i - 1][j - 1];
                    continue;
                }
                results[i][j] = Math.max(results[i - 1][j], results[i - 1][j - 1]) + triangle[i][j];

            }
        }
    }
}
