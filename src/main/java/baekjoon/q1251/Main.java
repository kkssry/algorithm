package baekjoon.q1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static String compareWords;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        initCompareWords();
        String line = br.readLine();
        int depth = 0;
        int[] arr = new int[2];
        callResult(line, depth, arr, 0);
        System.out.println(compareWords);
    }

    private static void initCompareWords() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 51; i++) {
            sb.append("z");
        }
        compareWords = sb.toString();
    }

    private static void callResult(String line, int depth, int[] arr, int index) {
        if (depth == 2) {
            if (checkArr(line, arr)) {
                compareWord(line, arr);
            }
            return;
        }

        for (int i = index; i < line.length(); i++) {
            arr[depth] = i;
            callResult(line, depth + 1, arr, i + 1);
        }
    }

    private static boolean checkArr(String line, int[] arr) {
        return arr[0] < arr[1] && arr[1] <= line.length() - 2;
    }

    private static void compareWord(String line, int[] arr) {
        StringBuilder sb = new StringBuilder();
        initSb(sb, arr, line);
        String reverseWords = sb.toString();
        if (compareWords.compareTo(reverseWords) > 0) {
            compareWords = reverseWords;
        }

    }

    private static void initSb(StringBuilder sb, int[] arr, String line) {
        for (int i = arr[0]; i >= 0; i--) {
            sb.append(line.charAt(i));
        }
        for (int i = arr[1]; i > arr[0]; i--) {
            sb.append(line.charAt(i));
        }
        for (int i = line.length() - 1; i >= arr[1] + 1; i--) {
            sb.append(line.charAt(i));
        }
    }

}
