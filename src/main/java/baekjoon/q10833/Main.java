package baekjoon.q10833;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int[] results = new int[count];
        for (int i = 0; i < count; i++) {
            int studentCount = sc.nextInt();
            int appleCount = sc.nextInt();
            results[i] = saveResult(studentCount, appleCount);
        }
        System.out.println(IntStream.of(results).sum());
    }

    private static int saveResult(int studentCount, int appleCount) {
        if (studentCount > appleCount) {
            return appleCount;
        }
        return appleCount % studentCount;
    }
}
