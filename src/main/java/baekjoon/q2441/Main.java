package baekjoon.q2441;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = input; i > 0; i--) {
            for (int j = input; j > i; j--) {
                System.out.print(" ");
            }

            for (int j = i; j > 0; j--) {
                System.out.print("*");
            }

            System.out.println();
        }
    }
}
