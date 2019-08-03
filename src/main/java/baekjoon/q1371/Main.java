package baekjoon.q1371;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Character, Integer> wordManager = new HashMap<>();
        initWordManager(wordManager);
        countWords(wordManager, br);
        int max = maxCount(wordManager);
        printResult(max, wordManager, bw);
        bw.flush();
    }

    private static void printResult(int max, Map<Character, Integer> wordManager, BufferedWriter bw) throws IOException {
        for (int i = 97; i <= 122; i++) {
            char word = (char)i;
            if (wordManager.get(word) == max) {
                bw.write(word);
            }
        }
    }

    private static int maxCount(Map<Character, Integer> wordManager) {
        int max = 0;
        for (Integer value : wordManager.values()) {
            if (max < value) {
                max = value;
            }
        }
        return max;
    }

    private static void countWords(Map<Character, Integer> wordManager, BufferedReader br) throws IOException {
        String sentence;
        while ((sentence = br.readLine()) != null) {
            for (int i = 0; i < sentence.length(); i++) {
                char word = sentence.charAt(i);
                if( word != ' ') {
                    wordManager.put(word, wordManager.get(word) + 1);
                }
            }
        }
    }

    private static void initWordManager(Map<Character, Integer> wordManager) {
        for (int i = 97; i <= 122; i++) {
            wordManager.put((char) i, 0);
        }
    }
}
