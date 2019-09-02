package baekjoon.q11727;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int one = 1;
        int mod = 10007;
        int result = one;
        boolean isColumnMultipleOfTwo = false;
        for (int i = one; i < number; i++) {
            isColumnMultipleOfTwo = !isColumnMultipleOfTwo;
            result = (result * 2) % mod;
            if (isColumnMultipleOfTwo) {
                result = (result + one) % mod;
                continue;
            }
            result = (result - one) % mod;
        }
        System.out.println(result);
    }
}
