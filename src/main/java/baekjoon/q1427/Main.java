package baekjoon.q1427;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] number = Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(number);
        reversePrint(number);
    }

    private static void reversePrint(int[] number) {
        for (int i = number.length - 1; i >=0 ; i--) {
            System.out.print(number[i]);
        }
    }
}
