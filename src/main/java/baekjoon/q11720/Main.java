package baekjoon.q11720;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int sum = 0;

        String arr = br.readLine();
        String[] numsstr = arr.split("");

        for (String s : numsstr) {
            sum +=Integer.parseInt(s);
        }

        System.out.println(sum);
    }
}
