package baekjoon.star.dot.q2442;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        for (int i = 1; i <= input; i++) {
            for (int j = input - i; j >0; j--) {
                System.out.print(" ");
            }

            for (int j = 1; j <= 2*i-1; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }

}
