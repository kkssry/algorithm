package baekjoon.q10804;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] cardNumbers = new int[20 + 1];
        initCardNumbers(cardNumbers);
        startReverse(cardNumbers, sc);
        String reslt = Arrays.stream(cardNumbers)
                             .filter(i -> i != 0)
                             .mapToObj(String::valueOf)
                             .collect(Collectors.joining(" "));
        System.out.println(reslt);
    }

    private static void initCardNumbers(int[] cardNumbers) {
        for (int i = 1; i < cardNumbers.length; i++) {
            cardNumbers[i] = i;
        }
    }

    private static void startReverse(int[] cardNumbers, Scanner sc) {
        for (int i = 0; i < 10; i++) {
            int startIndex = sc.nextInt();
            int endIndex = sc.nextInt();
            reverseCardNumber(cardNumbers, startIndex, endIndex);
        }
    }

    private static void reverseCardNumber(int[] cardNumbers, int startIndex, int endIndex) {
        int[] copyCardNumbers = new int[endIndex - startIndex + 1];
        for (int i = startIndex; i <= endIndex; i++) {
            copyCardNumbers[endIndex - i] = cardNumbers[i];
        }


        for (int i = startIndex; i <= endIndex; i++) {
            cardNumbers[i] = copyCardNumbers[i-startIndex];
        }
    }

}
