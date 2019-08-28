package baekjoon.q1259;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        loop:
        while (!(line = br.readLine()).equals("0")) {
            if (line.length() == 1) {
                System.out.println("yes");
                continue;
            }
            String comparisonStr = line.substring((line.length() - 1) / 2 + 1);
            for (int i = comparisonStr.length() - 1; i >= 0; i--) {
                if (line.charAt(i) != comparisonStr.charAt(comparisonStr.length() - 1 - i)) {
                    System.out.println("no");
                    continue loop;
                }
            }
            System.out.println("yes");

        }

    }
}
