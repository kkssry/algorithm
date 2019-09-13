package baekjoon.q2018;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long targetNumber = sc.nextLong();
        long count = 0;
        for (long i = 1; i <= 10000000; i++) {
            long number = (i  * (i + 1)) / 2;
            if (number == targetNumber) {
                count++;
            }
            if (number > targetNumber) {
                for (long j = i - 1; j >= 1; j--) {
                    long num = number - (j * (j + 1)) / 2;
                    if (num >= targetNumber) {
                        if (num == targetNumber) {
                            count++;
                        }
                        break;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

