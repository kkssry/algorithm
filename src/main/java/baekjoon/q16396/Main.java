package baekjoon.q16396;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        boolean[] bol = new boolean[10000 + 1];
        initBol(count, bol, br);
        System.out.println(saveResult(bol));
    }

    private static int saveResult(boolean[] bol) {
        int count = 0;
        for (boolean b : bol) {
            if (b) {
                count++;
            }
        }
        return count;
    }

    private static void initBol(int count, boolean[] bol, BufferedReader br) throws IOException {
        for (int i = 0; i < count; i++) {
            String[] arr = br.readLine().split(" ");
            int start = Integer.parseInt(arr[0]);
            int end = Integer.parseInt(arr[1]);
            for (int j = start; j < end; j++) {
                bol[j] = true;
            }
        }
    }
}
