package baekjoon.q17351;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        String[][] words = new String[size][size];
        initWords(words, br);
        startPositionSetting(words);
        System.out.println(max);
    }

    private static void startPositionSetting(String[][] words) {
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words[i].length; j++) {
                if (words[i][j].equals("M")) {
                    Stack<String> stack = new Stack<>();
                    stack.add(words[i][j]);
                    run(words, i, j, stack);
                }
            }
        }
    }

    private static void run(String[][] words, int fromNorth, int fromWest, Stack<String> stack) {
        if (fromNorth == words.length- 1 && fromWest == words.length - 1) {
            int count = countMOLA(stack);
            if (max < count) {
                max = count;
            }
            return;
        }

        if (fromWest + 1 < words.length) {
            stack.add(words[fromNorth][fromWest + 1]);
            run(words, fromNorth, fromWest + 1, stack);
            stack.pop();
        }

        if (fromNorth + 1 < words.length) {
            stack.add(words[fromNorth + 1][fromWest]);
            run(words, fromNorth + 1, fromWest, stack);
            stack.pop();
        }
    }

    private static int countMOLA(Stack<String> arr) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (String s : arr) {
            sb.append(s);
        }
        String line = sb.toString().replace("MOLA","a");
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == 'a') {
                count++;
            }
        }
        return count;
    }

    private static void initWords(String[][] words, BufferedReader br) throws IOException {
        for (int i = 0; i < words.length; i++) {
            words[i] = br.readLine().split("");
        }
    }
}
