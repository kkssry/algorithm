package programmers.q42588;

public class Solution {
    public int[] solution(int[] heights) {
        int[] answer = {};

        answer = new int[heights.length];

        for (int i = heights.length - 1; i >= 0; i--) {
            if (i == 0) {
                break;
            }

            for (int j = i - 1; j >= 0; j--) {
                if (heights[i] < heights[j]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }
}
