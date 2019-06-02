package baekjoon.q2217;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = Integer.parseInt(scan.nextLine());
        int[] ropes = new int[input];
        int[] maxWeightByRopes = new int[input];

        initRopes(ropes, scan);
        Arrays.sort(ropes);
        saveMaxWeights(maxWeightByRopes,ropes);

        System.out.println(Arrays.stream(maxWeightByRopes).max().getAsInt());
    }

    private static void saveMaxWeights(int[] maxWeightByRopes, int[] ropes) {
        int ropeCount = ropes.length;
        for (int i = 0; i < ropeCount; i++) {
            maxWeightByRopes[i] = ropes[i] * (ropeCount - i);
        }
    }

    private static void initRopes(int[] ropes, Scanner scan) {
        for (int i = 0; i < ropes.length; i++) {
            ropes[i] = Integer.parseInt(scan.nextLine());
        }
    }
}

