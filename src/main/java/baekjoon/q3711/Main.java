package baekjoon.q3711;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCount = scan.nextInt();
        int[] results = new int[testCount];
        runTests(testCount, results, scan);
        IntStream.of(results).forEach(System.out::println);
    }

    private static void runTests(int testCount, int[] results, Scanner scan) {
        for (int i = 0; i < testCount; i++) {
            int peopleCount = scan.nextInt();
            int[] peopleNumber = new int[peopleCount];
            initPeopleNumber(peopleNumber, scan);
            results[i] = saveMinDivider(peopleNumber);
        }
    }

    private static int saveMinDivider(int[] peopleNumber) {
        int divder = 0;
        int[] rests = new int[peopleNumber.length];
        for (int i = 1; i < Integer.MAX_VALUE; i++) {
            for (int j = 0; j < peopleNumber.length; j++) {
                rests[j] = peopleNumber[j] % i;
            }
            if (isDuplicateExist(rests)) {
                initRests(rests);
                continue;
            }
            divder = i;
            break;
        }
        return divder;
    }

    private static void initRests(int[] rests) {
        for (int i = 0; i < rests.length; i++) {
            rests[i] = 0;
        }
    }

    private static boolean isDuplicateExist(int[] rests) {
        for (int i = 0; i < rests.length; i++) {
            for (int j = 0; j < rests.length; j++) {
                if (i == j) {
                    continue;
                }
                if (rests[i] == rests[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void initPeopleNumber(int[] peopleCount, Scanner scan) {
        for (int i = 0; i < peopleCount.length; i++) {
            peopleCount[i] = scan.nextInt();
        }
    }
}
