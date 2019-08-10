package baekjoon.q1436;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int st = sc.nextInt();
        int result = 0;
        int firstIndex = 666;
        while(st != 0) {
            for (int i = firstIndex; i <Integer.MAX_VALUE; i++) {
                if (String.valueOf(i).contains("666")) {
                    st--;
                    result = i;
                    firstIndex = i + 1;
                    break;
                }
            }
        }
        System.out.println(result);

    }
}
