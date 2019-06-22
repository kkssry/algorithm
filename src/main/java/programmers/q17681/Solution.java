package programmers.q17681;

import java.util.Arrays;
import java.util.stream.Stream;

public class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[][] map = new String[n][n];

        for (int i = 0; i < n; i++) {
            String lineMap = String.format("%"+n+"s", Integer.toBinaryString(arr1[i] | arr2[i]));
            System.out.println(lineMap + "  Length : " + lineMap.length());
            for (int j = 0; j < n; j++) {
                if (lineMap.charAt(j) == '1') {
                    map[i][j] = "#";
                } else {
                    map[i][j] = " ";
                }
            }
        }

        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append(map[i][j]);
            }
            answer[i] = sb.toString();
        }
        return answer;
    }

}
