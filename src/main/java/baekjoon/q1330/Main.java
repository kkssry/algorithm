package baekjoon.q1330;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int firstNum = sc.nextInt();
        int twoNum = sc.nextInt();

        if (firstNum > twoNum) {
            System.out.println(">");
        }

        if (firstNum < twoNum) {
            System.out.println("<");
        }

        if (firstNum == twoNum) {
            System.out.println("==");
        }
    }
}
