package baekjoon.q15926;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;

public class Main {
    private static int finalCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        String line = br.readLine();
        Stack<String> stack = new Stack<>();
        saveResult(line, stack);
        System.out.println(finalCount);
    }

    private static void saveResult(String line, Stack<String> stack) {
        boolean[] bol = new boolean[line.length()];
        for (int i = 0; i < line.length(); i++) {
            if (line.charAt(i) == '(') {
                stack.push("(");
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    bol[i] = true;
                    checkBol(bol, i, line);
                }
            }
        }
//        System.out.println(Arrays.toString(bol));
        finalResult(bol);
    }

    private static void finalResult(boolean[] bol) {
        int sum = 0;
        for (boolean b : bol) {
            if (b) {
                sum++;
                if (finalCount < sum) {
                    finalCount = sum;
                }
            } else {
                sum = 0;
            }
        }
    }

    private static void checkBol(boolean[] bol, int i, String line) {
        for (int j = i; j >= 0; --j) {
            if (line.charAt(j) == '(' && !bol[j]) {
                bol[j] = true;
                break;
            }
        }
    }
}
