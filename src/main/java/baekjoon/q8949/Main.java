package baekjoon.q8949;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.next();
        String line2 = sc.next();
        int[] arr = Arrays.stream(line.split("")).mapToInt(Integer::parseInt).toArray();
        int[] arr2 = Arrays.stream(line2.split("")).mapToInt(Integer::parseInt).toArray();
        if (arr.length < arr2.length) {
            saveResultCase1(arr,arr2);
        }
        if (arr.length == arr2.length) {
            saveResultCase2(arr,arr2);
        }
        if (arr.length > arr2.length) {
            saveResultCase3(arr, arr2);
        }
    }

    private static void saveResultCase3(int[] arr, int[] arr2) {
        int difference = arr.length - arr2.length;
        for (int i = 0; i < difference; i++) {
            System.out.print(arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i] + arr[i+difference]);
        }
    }

    private static void saveResultCase2(int[] arr, int[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + arr2[i]);
        }
    }

    private static void saveResultCase1(int[] arr, int[] arr2) {
        int difference = arr2.length - arr.length;
        for (int i = 0; i < difference; i++) {
            System.out.print(arr2[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + arr2[i+difference]);
        }
    }
}
