package baekjoon.q1065;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int count = 0;

        count = calculateCount(input, count);

        System.out.println(count);
    }

    private static int calculateCount(int input, int count) {
        for (int i = 1; i <= input; i++) {
            if (i < 100) {
                count++;
            }

            if (i >= 100) {
                count += arithmeticalProgression(i);
            }
        }
        return count;
    }

    private static int arithmeticalProgression(int number) {
        char[] singleDigit = Integer.toString(number).toCharArray();
        int difference = singleDigit[0] - singleDigit[1];
        for (int i = 1; i < singleDigit.length - 1; i++) {
            if (difference != singleDigit[i] - singleDigit[i + 1]) {
                return 0;
            }
        }
        return 1;
    }
}
