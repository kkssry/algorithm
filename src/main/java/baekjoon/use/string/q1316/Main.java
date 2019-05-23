package baekjoon.use.string.q1316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] words = new String[input];
        List<Integer> list = new ArrayList<>();
        int resultValue = 0;

        for (int i = 0; i < input; i++) {
            words[i] = br.readLine();
        }

        for (String word : words) {
            resultValue += checkContinuousWord(word, list);
        }

        System.out.println(resultValue);
    }

    private static int checkContinuousWord(String word, List<Integer> list) {
        String[] words = word.split("");
        for (int i = 0; i < words.length; i++) {
            list.add(i);
            for (int j = 0; j < words.length; j++) {
                if (i == j) {
                    continue;
                }

                if (words[i].equals(words[j])) {
                    list.add(j);
                }
            }
            if (!isAsc(list)) {
                list.clear();
                return 0;
            }
            list.clear();
        }

        return 1;
    }

    private static boolean isAsc(List<Integer> list) {
        Collections.sort(list);
        for (int i = 0; i < list.size() - 1; i++) {
            if (Math.abs(list.get(i) - list.get(i + 1)) != 1) {
                return false;
            }
        }
        return true;
    }
}
