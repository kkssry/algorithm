package baekjoon.q17362;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int problemNumber = sc.nextInt();
        if (problemNumber <= 5) {
            System.out.println(problemNumber % 6);
            return;
        }

        int mock = (problemNumber - 5) / 4;
        int rest = (problemNumber - 5) % 4;
        if (rest > 0) {
            rest = 1;
        }

        int floor = mock + rest + 1;
        int st = floor / 2;

        if (floor % 2 == 1) {
            int endIndex = 5;
            int end = endIndex + 8 * st;
            while(problemNumber != end) {
                end--;
                endIndex--;
            }
            System.out.println(endIndex);
            return;
        }

        int endIndex = 1;
        int end = 1 + 8 * st;
        while(problemNumber != end) {
            end--;
            endIndex++;
        }
        System.out.println(endIndex);

    }
}
