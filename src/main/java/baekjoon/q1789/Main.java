package baekjoon.q1789;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long number = sc.nextLong();
        long maxN = 0;

        for (long i = 0; i < Long.MAX_VALUE; i++) {
            BigInteger big = new BigInteger(String.valueOf(i*i));
            if (big.add(new BigInteger(String.valueOf(i))).compareTo(new BigInteger(String.valueOf(number * 2))) > 0) {
                maxN = i - 1;
                break;
            }
        }
        System.out.println((int)maxN);
    }
}
