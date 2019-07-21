package baekjoon.q1212;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String number = br.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            int ox = number.charAt(i) - '0';
            sb.append(String.format("%3s", Integer.toBinaryString(ox)));
        }

        String answer = sb.toString().trim().replace(" ","0");
        System.out.println(answer);
    }
}
