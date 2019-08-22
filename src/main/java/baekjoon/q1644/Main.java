package baekjoon.q1644;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        if (number == 0) {
            System.out.println(0);
            return;
        }
        List<Integer> primeNumbers = new ArrayList<>();
        initPrimeNumbers(primeNumbers, number);
        int result = saveResult(primeNumbers, number);
        System.out.println(result);
    }

    private static int saveResult(List<Integer> primeNumbers, int number) {
        int count = 0;
        for (int i = 0; i < primeNumbers.size(); i++) {
            int first = primeNumbers.get(i);
            if (first == number) {
                count++;
            }
            for (int j = i + 1; j < primeNumbers.size(); j++) {
                if (first + primeNumbers.get(j) > number) {
                    break;
                }
                if (first + primeNumbers.get(j) == number) {
                    count++;
                    break;
                }
                if (first + primeNumbers.get(j) < number) {
                    first += primeNumbers.get(j);
                }
            }
        }
        return count;
    }

    private static void initPrimeNumbers(List<Integer> primeNumbers, int number) {
        for (int i = 2; i <= number; i++) {
            if (isPrimeNumber(i)) {
                primeNumbers.add(i);
            }
        }
    }

    private static boolean isPrimeNumber(int i) {
        int endIndex = (int) Math.sqrt(i);
        for (int j = 2; j <= endIndex; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }
}
