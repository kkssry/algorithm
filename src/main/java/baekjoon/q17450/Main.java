package baekjoon.q17450;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Snack[] snack = new Snack[3];
        initSnack(snack, sc);
        initSnackCostEffectiveness(snack);
        Arrays.sort(snack);
        System.out.println(snack[snack.length - 1].name);
    }

    private static void initSnackCostEffectiveness(Snack[] snack) {
        for (Snack value : snack) {
            value.saveCostEffectiveness();
        }
    }

    private static void initSnack(Snack[] snack, Scanner sc) {
        String[] names = {"S", "N", "U"};
        for (int i = 0; i < snack.length; i++) {
            int price = sc.nextInt();
            int weight = sc.nextInt();
            snack[i] = new Snack(names[i], price , weight);
        }
    }

    static class Snack implements Comparable<Snack> {
        String name;
        double price;
        double weight;
        double costEffectiveness;

        Snack(String name, double price, double weight) {
            this.name = name;
            this.price = price;
            this.weight = weight;
        }

        void saveCostEffectiveness() {
            double totalPrice = price * 10;
            if (totalPrice >= 5000) {
                totalPrice -= 500;
            }
            costEffectiveness = (weight * 10) / totalPrice;
        }

        @Override
        public int compareTo(Snack o) {
            return Double.compare(costEffectiveness, o.costEffectiveness);
        }
    }
}
