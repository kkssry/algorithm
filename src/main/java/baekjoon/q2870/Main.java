package baekjoon.q2870;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int paperCount = Integer.parseInt(br.readLine());
        List<BigInteger> numbers = new ArrayList<>();
        findNumber(paperCount, numbers, br);

        Collections.sort(numbers);
        numbers.forEach(System.out::println);
    }

    private static void findNumber(int paperCount, List<BigInteger> numbers, BufferedReader br) throws IOException {
        for (int i = 0; i < paperCount; i++) {
            String paperSentence = br.readLine();
            String[] numberInpaper = paperSentence.split("[^0-9]");
            numberAddInNumbers(numbers, numberInpaper);
        }
    }

    private static void numberAddInNumbers(List<BigInteger> numbers, String[] numberInpaper) {
        for (String number : numberInpaper) {
            if (!number.equals("")) {
                numbers.add(new BigInteger(number));
            }
        }
    }

}
