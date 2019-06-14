package baekjoon.q1978;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numbers = initNumbers(br);
        findPrimeNumber(numbers);
    }

    private static void findPrimeNumber(int[] numbers) {
        int count = 0;
        loop: for (int number : numbers) {
            if (number  == 2 || number == 3) {
                count++;
                continue;
            }
            if (number == 1) {
                continue;
            }

            for (int j = 2; j <= Math.sqrt(number); j++) {
                if (number % j == 0) {
                    continue loop;
                }
            }
            count++;
        }
        System.out.println(count);
    }

    private static int[] initNumbers(BufferedReader br) throws IOException {
        br.readLine();
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
