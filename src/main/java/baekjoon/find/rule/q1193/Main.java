package baekjoon.find.rule.q1193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int times = 0;
        int different = 0;

        if (input == 1) {
            System.out.println("1/1");
            return;
        }

        if (input == 2) {
            System.out.println("1/2");
            return;
        }

        for (int i = 1; i < input; i++) {
            int sum = i * (i + 1) / 2;
            if (sum >= input) {
                times = i;
                different = sum - input;
                break;
            }
        }


        int plusUpAndDowm = times + 1;
        int up = 1;
        int down = 1;

        if (times % 2 == 1) {
            down = times - different;
            up = plusUpAndDowm - down;
        } else {
            up = times -different;
            down = plusUpAndDowm - up;
        }


        System.out.println(up+"/"+down);

    }
}
