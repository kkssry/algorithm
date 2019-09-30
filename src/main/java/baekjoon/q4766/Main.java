package baekjoon.q4766;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        initList(list, sc);
        printResult(list);
    }

    private static void printResult(List<Double> list) {
        for (int i = 1; i < list.size(); i++) {
            System.out.println(String.format("%.2f", list.get(i) - list.get(i - 1)));
        }
    }

    private static void initList(List<Double> list, Scanner sc) {
        double num;
        while ((num = sc.nextDouble()) != 999) {
            list.add(num);
        }
    }
}
