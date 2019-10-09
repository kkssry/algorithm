package baekjoon.q2455;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        for (int i = 0; i < 4; i++) {
            String[] arr = br.readLine().split(" ");
            count -= Integer.parseInt(arr[0]);
            count += Integer.parseInt(arr[1]);
            if (max < count) {
                max = count;
            }
        }
        System.out.println(max);
    }
}
