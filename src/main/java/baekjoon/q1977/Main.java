package baekjoon.q1977;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int firstNum = scan.nextInt();
        int secondNum = scan.nextInt();
        List<Integer> completeNumber = new LinkedList<>();
        findCompleteSquare(firstNum, secondNum, completeNumber);
        PrintResult(completeNumber);
    }

    private static void PrintResult(List<Integer> completeNumber) {
        if (completeNumber.size() > 0) {
            System.out.println(completeNumber.stream().mapToInt(i-> i).sum());
            System.out.println(completeNumber.get(0));
            return;
        }
        System.out.println(-1);
    }

    private static void findCompleteSquare(int firstNum, int secondNum, List<Integer> completeNumber) {
        double firstDouble = Math.sqrt(firstNum);
        int first = (int)firstDouble;
        if (firstDouble != first) {
            first += 1;
        }

        int second = (int)Math.sqrt(secondNum);

        for (int i = first; i <= second ; i++) {
            completeNumber.add(i * i);
        }
    }
}
