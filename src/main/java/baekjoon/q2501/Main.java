package baekjoon.q2501;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        int st = sc.nextInt();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                list.add(i);
            }
        }
        try {
            System.out.println(list.get(st - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(0);
        }
    }
}
