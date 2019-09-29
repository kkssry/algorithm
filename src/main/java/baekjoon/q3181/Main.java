package baekjoon.q3181;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ignoreWords = {"i", "pa", "te", "ni", "niti", "a", "ali", "nego", "no", "ili"};
        String[] language = br.readLine().split(" ");
        List<String> list = new ArrayList<>();
        saveResult(language, ignoreWords, list);
        printResult(list);
    }

    private static void printResult(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String s : list) {
            sb.append(s);
        }
        System.out.println(sb.toString());
    }

    private static void saveResult(String[] language, String[] ignoreWords, List<String> list) {
        list.add(String.valueOf(language[0].charAt(0)).toUpperCase());
        boolean isChecked;
        for (int i = 1; i < language.length; i++) {
            isChecked = false;
            for (String ignoreWord : ignoreWords) {
                if (language[i].equals(ignoreWord)) {
                    isChecked = true;
                    break;
                }
            }
            if (!isChecked) {
                list.add(String.valueOf(language[i].charAt(0)).toUpperCase());
            }
        }
    }
}
