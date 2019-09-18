package baekjoon.q14889;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static int minTotalDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[][] scores = new int[count][count];
        initScores(scores, br);
        boolean[] isChecked = new boolean[count];
        isChecked[0] = true;
        int st = 1;
        int previousIndex = 1;
        saveResult(isChecked, scores, st, previousIndex);
        System.out.println(minTotalDifference);
    }
    
    private static void saveResult(boolean[] isChecked, int[][] scores, int st, int previousIndex) {
        if (scores.length / 2 == st) {
            compare(scores, isChecked);
            return;
        }

        for (int i = previousIndex; i <= (isChecked.length / 2) + st; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                saveResult(isChecked, scores, st + 1, i + 1);
                isChecked[i] = false;
            }
        }
    }

    private static void compare(int[][] scores, boolean[] isChecked) {
        int[] trues = new int[isChecked.length / 2];
        int[] falses = new int[isChecked.length / 2];
        initTruesFalses(trues, isChecked, falses);
        int truesScores = saveScores(trues, scores);
        int falsesScores = saveScores(falses, scores);

        int difference = Math.abs(truesScores - falsesScores);
        if (minTotalDifference > difference) {
            minTotalDifference = difference;
        }
    }

    private static int saveScores(int[] arr, int[][] scores) {
        int sum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                sum += (scores[arr[i]][arr[j]] + scores[arr[j]][arr[i]]);
            }
        }
        return sum;
    }

    private static void initTruesFalses(int[] trues, boolean[] isChecked, int[] falses) {
        int trueIndex = 0;
        int falseIndex = 0;
        for (int i = 0; i < isChecked.length; i++) {
            if (isChecked[i]) {
                trues[trueIndex++] = i;
            } else {
                falses[falseIndex++] = i;
            }
        }
    }

    private static void initScores(int[][] scores, BufferedReader br) throws IOException {
        for (int i = 0; i < scores.length; i++) {
            String[] line = br.readLine().split(" ");
            for (int j = 0; j < scores[i].length; j++) {
                scores[i][j] = Integer.parseInt(line[j]);
            }
        }
    }
}
