package baekjoon.q4539;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] results = new int[count];
        for (int i = 0; i < count; i++) {
            String number = br.readLine();
            int num = Integer.parseInt(number);
            int digitCount = number.length();
            if (digitCount == 1) {
                results[i] = num;
                continue;
            }

            for (int j = 1; j <= digitCount - 1; j++) {
                double bigDigit = Math.pow(10, j);
                num = (int)(Math.round(num / bigDigit) * bigDigit);
            }

            results[i] = num;
        }
        Arrays.stream(results).forEach(System.out::println);
    }
}
