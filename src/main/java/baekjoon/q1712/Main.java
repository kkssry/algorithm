package baekjoon.q1712;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int fixCost = sc.nextInt();
        int variableCost = sc.nextInt();
        int labtopPrice = sc.nextInt();
        if (variableCost >= labtopPrice) {
            System.out.println(-1);
            return;
        }

        int count = fixCost / (labtopPrice - variableCost);
        count++;
        System.out.println(count);
    }
}
