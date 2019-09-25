package baekjoon.q2991;

import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] dogs = new int[2][2];
        initDogs(dogs, sc);
        int[][] deliver = new int[3][2];
        initDeliver(deliver, sc);
        saveResult(deliver, dogs);
        printResult(deliver);
    }

    private static void printResult(int[][] deliver) {
        for (int[] deliverBite : deliver) {
            System.out.println(deliverBite[1]);
        }
    }

    private static void saveResult(int[][] deliver, int[][] dogs) {
        int firstDog = IntStream.of(dogs[0]).sum();
        int secondDog = IntStream.of(dogs[1]).sum();

        for (int i = 0; i < deliver.length; i++) {
            int firstDogBiteCycle = deliver[i][0] % firstDog;
            int secondDogBiteCycle = deliver[i][0] % secondDog;

            if ( firstDogBiteCycle >= 1 && firstDogBiteCycle <= dogs[0][0]) {
                deliver[i][1]++;
            }
            if (secondDogBiteCycle >= 0 && secondDogBiteCycle <= dogs[1][0]) {
                deliver[i][1]++;
            }
        }
    }

    private static void initDeliver(int[][] deliver, Scanner sc) {
        for (int i = 0; i < deliver.length; i++) {
            for (int j = 0; j < 1; j++) {
                deliver[i][j] = sc.nextInt();
            }
        }
    }

    private static void initDogs(int[][] dogs, Scanner sc) {
        for (int i = 0; i < dogs.length; i++) {
            for (int j = 0; j < dogs[i].length; j++) {
                dogs[i][j] = sc.nextInt();
            }
        }
    }
}
