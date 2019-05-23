package baekjoon.use.string.q1157;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String sentence = br.readLine().toLowerCase();
        String[] words = sentence.split("");
        String[] arr = Arrays.stream(words).distinct().toArray(String[]::new);
        int[] counts = new int[arr.length];

        findMaxword(arr,words,counts);
        List<Integer> maxIndexs = new ArrayList<>();
        findMaxIndex(counts,maxIndexs);
        findCorrect(maxIndexs,arr);

    }

    private static void findCorrect(List<Integer> maxIndexs, String[] arr) {
        if (maxIndexs.size() > 1) {
            System.out.println("?");
            return;
        }

        int maxIndex = maxIndexs.get(0);
        for (int i = 0; i < arr.length; i++) {
            if (i == maxIndex) {
                System.out.println(arr[i].toUpperCase());
            }
        }
    }

    private static void findMaxword(String[] arr, String[] words, int[] counts) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (arr[i].equals(words[j])) {
                    counts[i]++;
                }
            }
        }
    }

    private static void findMaxIndex(int[] counts, List<Integer> maxIndexs) {
        int max = Arrays.stream(counts).max().getAsInt();
        for (int i = 0; i < counts.length; i++) {
            if (max == counts[i]) {
                maxIndexs.add(i);
            }
        }
    }
}
