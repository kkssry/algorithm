package baekjoon.q9095;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int[] numbers = new int[11];
        initNumbers(numbers);
        int count = scan.nextInt();
        saveResult(count,numbers, scan);
    }

    private static void saveResult(int count, int[] numbers, Scanner scan) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < count; i++) {
            int index = scan.nextInt();
            bw.write(numbers[index] + "\n");
        }
        bw.flush();
    }

    private static void initNumbers(int[] numbers) {
        numbers[1] = 1;
        numbers[2] = 2;
        numbers[3] = 4;
        for (int i = 4; i < numbers.length; i++) {
            numbers[i] = numbers[i - 1] + numbers[i - 2] + numbers[i - 3];
        }
    }
}
