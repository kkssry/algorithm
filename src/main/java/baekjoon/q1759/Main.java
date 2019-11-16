package baekjoon.q1759;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int vocaCount = Integer.parseInt(inputs[1]);
        String[] vocas = new String[vocaCount];
        initVocas(vocas, br);
        Arrays.sort(vocas);
        int passwordCount = Integer.parseInt(inputs[0]);
        String[] password = new String[passwordCount];
        int passwordIndex = 0;
        int wordIndex = 0;
        makePassword(vocas, wordIndex, password, passwordIndex, passwordCount);
        printResult();
    }

    private static void printResult() {
        for (String s : list) {
            System.out.println(s);
        }
    }

    private static void makePassword(String[] vocas, int wordIndex, String[] password, int passwordIndex, int passwordCount) {
        if (passwordIndex == passwordCount) {
            savePassword(password);
            return;
        }

        for (int i = wordIndex; i <= vocas.length - password.length + passwordIndex; i++) {
            password[passwordIndex] = vocas[i];
            makePassword(vocas, i + 1, password, passwordIndex + 1, passwordCount);
        }

    }

    private static void savePassword(String[] password) {
        StringBuilder sb = new StringBuilder();
        for (String s : password) {
            sb.append(s);
        }
        String word = sb.toString();
        if (isVowelsExist(word)) {
            list.add(word);
        }

    }

    private static boolean isVowelsExist(String word) {
        int vowelCount = 0;
        int notVowelCount = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' ||
                    word.charAt(i) == 'o' || word.charAt(i) == 'u') {
                vowelCount++;
            } else {
                notVowelCount++;
            }
        }

        return vowelCount >= 1 && notVowelCount >= 2;
    }

    private static void initVocas(String[] vocas, BufferedReader br) throws IOException {
        String[] words = br.readLine().split(" ");
        System.arraycopy(words, 0, vocas, 0, vocas.length);
    }
}
