package baekjoon.q1037;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int aliquotCount = sc.nextInt();
        int[] aliquots = new int[aliquotCount];
        initAliquots(aliquots, sc);
        if (aliquotCount == 1) {
            System.out.println((int) Math.pow(aliquots[0], 2));
            return;
        }
        int maxValue = IntStream.of(aliquots).max().getAsInt();
        int minValue = IntStream.of(aliquots).min().getAsInt();
        int gcm = saveLCM(aliquots);
        int result = IntStream.of(aliquots).reduce(1, (x, y) -> x * y) * gcm;
        if (result == maxValue) {
            result *= minValue;
        }
        System.out.println(result);
    }

    private static int saveLCM(int[] aliquots) {
        boolean flag = true;
        int semiGCM = 1;
        loop:
        while (flag) {
            int max = IntStream.of(aliquots).max().getAsInt();
            for (int j = 2; j <= max; j++) {
                if (isTwoCount(j, aliquots)) {
                    for (int i = 0; i < aliquots.length; i++) {
                        if (aliquots[i] % j == 0) {
                            aliquots[i] /= j;
                        }
                    }
                    semiGCM *= j;
                    continue loop;
                }
            }
            flag = false;
        }
        return semiGCM;
    }

    private static boolean isTwoCount(int j, int[] aliquots) {
        int count = 0;
        for (int aliquot : aliquots) {
            if (aliquot % j == 0) {
                count++;
            }
        }
        return count >= 2;
    }

    private static void initAliquots(int[] aliquots, Scanner sc) {
        for (int i = 0; i < aliquots.length; i++) {
            aliquots[i] = sc.nextInt();
        }
    }
}
