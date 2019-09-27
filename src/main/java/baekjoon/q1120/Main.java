package baekjoon.q1120;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] vocas = br.readLine().split(" ");
        int difference = vocas[1].length() - vocas[0].length();
        int result = 51;
        for (int i = 0; i <= difference; i++) {
            int count = 0;
            for (int j = 0; j < vocas[0].length(); j++) {
                if (vocas[1].charAt(i + j) != vocas[0].charAt(j)) {
                    count++;
                }
            }
            if (result > count) {
                result = count;
            }
        }

        System.out.println(result);
    }
}
