package baekjoon.star.dot.q2444;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int inputNum = scan.nextInt();
        if (inputNum == 1) {
            System.out.println("*");
            return;
        }
        String[] stars = new String[2 * inputNum - 1];
        makeStarShape(stars, inputNum);
        printResult(stars);
    }

    private static void printResult(String[] stars) {
        for (String star : stars) {
            System.out.println(star);
        }
    }

    private static void makeStarShape(String[] stars, int inputNum) {
        int increase = inputNum - 1;
        for (int i = 0; i <= increase; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = increase - i; j > 0; j--) {
                sb.append(" ");
            }
            for (int k = 0; k < 2 * i + 1; k++) {
                sb.append("*");
            }
            stars[i] = sb.toString();
        }
        for (int i = increase + 1; i < stars.length; i++) {
            stars[i] = stars[increase * 2 - i];
        }
    }
}
