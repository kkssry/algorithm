package baekjoon.q2231;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        saveResult(number);
    }

    private static void saveResult(int number) {
        for (int i = 0; i < number; i++) {
            int k = i;
            String[] nums = (i +"").split("");
            for (String num : nums) {
                k += Integer.parseInt(num);
            }
            if (k == number) {
                System.out.println(i);
                break;
            }
        }
    }

}
