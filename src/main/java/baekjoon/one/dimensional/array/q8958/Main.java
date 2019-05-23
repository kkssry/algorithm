package baekjoon.one.dimensional.array.q8958;

import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner copy = new Scanner(System.in);
        int input = Integer.parseInt(copy.next());

        for (int i = 0; i < input; i++) {
            calculateSum(copy.next());
        }
    }

    private static void calculateSum(String correctTable) {
        String[] corrects = correctTable.split("");
        int sum = 0;
        sum += isFirstValueCorrect(corrects[0], sum);
        sum += calculateDetatilCorrect(corrects);
        System.out.println(sum);
    }

    private static int calculateDetatilCorrect(String[] corrects) {
        int originSum = 0;
        int one = 1;
        for (int i = 1; i < corrects.length; i++) {
            if (corrects[i].equals("X")) {
                one = 1;
            }

            if (corrects[i - 1].equals(corrects[i]) && corrects[i].equals("O")) {
                one += 1;
                originSum += one;
                continue;
            }

            if (corrects[i].equals("O")) {
                originSum += one;
            }
        }
        return originSum;
    }

    private static int isFirstValueCorrect(String correct, int currentSum) {
        if (correct.equals("O")) {
            currentSum++;
        }
        return currentSum;
    }
}
