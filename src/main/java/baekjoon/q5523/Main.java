package baekjoon.q5523;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] results = new int[2];
        for (int i = 0; i < count; i++) {
            int aScore = sc.nextInt();
            int bScore = sc.nextInt();
            if (aScore > bScore) {
                results[0]++;
            }
            if (aScore < bScore) {
                results[1]++;
            }
        }
        System.out.println(results[0] + " " + results[1]);
    }
}
