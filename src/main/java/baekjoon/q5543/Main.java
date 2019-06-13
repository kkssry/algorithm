package baekjoon.q5543;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] burger = new int[3];
        int[] beverage = new int[2];
        initburgerAndBeverage(burger,beverage, br);

        int price = IntStream.of(burger).min().getAsInt() + IntStream.of(beverage).min().getAsInt() - 50;
        printPrice(price);
    }

    private static void printPrice(int price) {
        System.out.println(price);
    }


    private static void initburgerAndBeverage(int[] burger, int[] beverage, BufferedReader br) throws IOException {
        for (int i = 0; i < burger.length; i++) {
            burger[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < beverage.length; i++) {
            beverage[i] = Integer.parseInt(br.readLine());
        }
    }
}
