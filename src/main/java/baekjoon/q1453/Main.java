package baekjoon.q1453;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        boolean[] fullState = new boolean[101];
        countOccupySeat(fullState,count,sc);
    }

    private static void countOccupySeat(boolean[] fullState, int count, Scanner sc) {
        int occupySeatCount = 0;
        for (int i = 0; i < count; i++) {
            int seatNum = sc.nextInt();
            if (!fullState[seatNum]) {
                fullState[seatNum] = true;
            } else {
                occupySeatCount++;
            }
        }

        System.out.println(occupySeatCount);
    }
}
