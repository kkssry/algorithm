package baekjoon.q8741;

import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        BigInteger two = BigInteger.valueOf(2);
        BigInteger twoPow = two.pow(num);
        BigInteger twoPowMinusOne = twoPow.subtract(BigInteger.ONE);
        System.out.println(twoPow.multiply(twoPowMinusOne).divide(two).toString(2));
    }
}
