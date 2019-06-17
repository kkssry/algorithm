package baekjoon.q1546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] scores = new int[input];
        double max = initScores(scores, br);
        double sum = saveNewAverage(max, scores);
        printResult(sum);
    }

    private static void printResult(double sum) {
        double roundSum = Math.round(sum * 1000000) / 1000000.00;
        if (roundSum * 100 == sum * 100) {
            System.out.println(String.format("%.2f",sum));
            return;
        }
        System.out.println(roundSum);
    }

    private static double saveNewAverage(double max, int[] scores) {
        double sum = 0;
        for (int score : scores) {
            sum += score / max;
        }
        return sum / scores.length * 100;
    }

    private static double initScores(int[] scores, BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < scores.length; i++) {
            scores[i] = Integer.parseInt(st.nextToken());
        }
        return saveMaxValue(scores);
    }

    private static int saveMaxValue(int[] scores) {
        return Arrays.stream(scores).max().getAsInt();
    }
}
