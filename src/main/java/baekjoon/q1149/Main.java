package baekjoon.q1149;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] answers = new int[input];

        int[][] houses = new int[input][3];


        for (int i = 0; i < input; i++) {
            houses[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }

        for (int i = 0; i < houses[0].length; i++) {
            boolean[] isPaint = new boolean[3];
            List<Integer> list = new ArrayList<>();
            answers[i] += houses[0][i];
            isPaint[i] = true;
            recursive(houses, isPaint, 1, answers, i, list);
        }

        System.out.println(Arrays.toString(answers));
    }

    private static void recursive(int[][] houses, boolean[] isPaint, int depth, int[] answers, int i, List<Integer> list) {
        if (depth == houses.length) {
            return;
        }


        for (int j = 0; j < houses[depth].length; j++) {
            if (!isPaint[j]) {
                list.add(houses[depth][j]);
            }
        }

        isPaint[depth -1] = false;
        Collections.sort(list);
        int min = list.get(0);
        list.clear();

        answers[i] += min;

        for (int j = 0; j <houses[depth].length; j++) {
            if (houses[depth][j] == min && !isPaint[j]) {
                isPaint[j] = true;
            }
        }

        recursive(houses, isPaint, depth + 1, answers, i, list);
    }
}
