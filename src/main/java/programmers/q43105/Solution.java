package programmers.q43105;


import java.util.Arrays;

public class Solution {
//    int comparisonNum = 0;                            // 주석처리 : 재귀 (but 시간초과)

    public int solution(int[][] triangle) {
        int answer = 0;
//        int[] path = new int[triangle.length];
//
//        path[0] = triangle[0][0];
//        recursive(0, triangle, path, 1, 1);
//        answer = comparisonNum;

        int[][] dp = new int[triangle.length][];

        for (int i = 0; i < triangle.length; i++) {
            dp[i] = new int[triangle[i].length];
        }

        dp[0][0] = triangle[0][0];

        for (int i = 1; i < triangle.length; i++) {
            int floorIndexCount = triangle[i].length;
            for (int j = 0; j < floorIndexCount; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                    continue;
                }

                if (j == floorIndexCount -1) {
                    dp[i][j] = dp[i -1][j - 1] + triangle[i][j];
                    continue;
                }
                int num = triangle[i][j];
                dp[i][j] = dp[i - 1][j -1] <= dp[i - 1][j] ? dp[i - 1][j] + num : dp [i -1][j -1] + num;

            }
        }

        answer = Arrays.stream(dp[triangle.length-1]).max().getAsInt();


        return answer;
    }

//    private void recursive(int currentIndex, int[][] triangle, int[] path, int depth, int currentFloor) {
//        if (depth == path.length) {
//            int sum = Arrays.stream(path).sum();
//            if (comparisonNum  < sum) {
//                comparisonNum = sum;
//            }
//            return;
//        }
//
//        int nextIndex = currentIndex + 1;
//        for (int i = currentIndex; i <= nextIndex; i++) {
//            path[currentFloor] = triangle[currentFloor][i];
//            recursive(i, triangle, path, depth + 1, currentFloor + 1);
//
//        }
//    }


}
