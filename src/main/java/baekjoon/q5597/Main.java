package baekjoon.q5597;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] isAttend = new boolean[31];
        checkAttend(isAttend,br);
        printResult(isAttend);
    }

    private static void printResult(boolean[] isAttend) {
        for (int i = 1; i < isAttend.length; i++) {
            if (!isAttend[i]) {
                System.out.println(i);
            }
        }
    }

    private static void checkAttend(boolean[] isAttend, BufferedReader br) throws IOException {
        for (int i = 0; i < 28; i++) {
            isAttend[Integer.parseInt(br.readLine())] = true;
        }
    }

}
