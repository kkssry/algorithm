package baekjoon.q11655;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int jumpNumber = 13;
        char[] words = line.toCharArray();
        initWordsRot13(words, jumpNumber);
        SaveResult(words);
    }

    private static void SaveResult(char[] words) {
        StringBuilder sb = new StringBuilder();
        for (char word : words) {
            sb.append(word);
        }
        System.out.println(sb.toString());
    }

    private static void initWordsRot13(char[] words, int jumpNumber) {
        for (int i = 0; i < words.length; i++) {
            char word = words[i];
            changeLowerCase(words, word, i, jumpNumber);
            changeUpperCase(words, word, i, jumpNumber);
        }
    }

    private static void changeUpperCase(char[] words, char word, int i, int jumpNumber) {
        if (word >= 'A' && word <= 'Z') {
            if ('Z' >= word + jumpNumber) {
                words[i] = (char)(word + jumpNumber);
            } else {
                words[i] = (char) ('A' - 1 + ((word + jumpNumber) % 'Z'));
            }
        }
    }

    private static void changeLowerCase(char[] words, char word, int i, int jumpNumber) {
        if (word >= 'a' && word <= 'z') {
            if ('z' >= word + jumpNumber) {
                words[i] = (char)(word + jumpNumber);
            } else {
                words[i] = (char)('a' - 1 + ((word + jumpNumber) % 'z'));
            }
        }
    }


}
