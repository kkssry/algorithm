package baekjoon.q1110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finalNum = Integer.parseInt(br.readLine());
        int changableNum = finalNum;
        int resultNum = -1;
        int answer = 0;

        while (finalNum != resultNum) {
            resultNum = callFunc(changableNum);
            changableNum = resultNum;
            answer++;
        }

        System.out.println(answer);
    }

    private static int callFunc(int input) {
        int one = input % 10;
        int two = (input % 10) + (input / 10);
        return (one * 10) + (two % 10);
    }
}
