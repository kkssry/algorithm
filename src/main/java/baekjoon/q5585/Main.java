package baekjoon.q5585;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] coins = {500,100,50,10,5,1};
        Scanner sc = new Scanner(System.in);
        int value = sc.nextInt();
        int change = 1000-value;
        saveResult(change, coins);
    }

    private static void saveResult(int change, int[] coins) {
        int count = 0;
        for (int i = 0; i < coins.length; i++) {
            int mock = change / coins[i];
            count += mock;
            change -= mock * coins[i];
        }
        System.out.println(count);
    }
}
