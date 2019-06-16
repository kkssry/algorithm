package baekjoon.q15552;

import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int input = Integer.parseInt(br.readLine());
        int[][] inputNumber = new int[input][2];
        int[] sumNumber = new int[input];
        initInputNumber(inputNumber, br);
        sumInputNumber(inputNumber,sumNumber);
        printResult(sumNumber, bw);
        bw.flush();
        bw.close();
    }

    private static void printResult(int[] sumNumber, BufferedWriter bw) throws IOException {
        for (int sumNum : sumNumber) {
            bw.write(String.valueOf(sumNum));
            bw.newLine();
        }
    }

    private static void sumInputNumber(int[][] inputNumber, int[] sumNumber) {
        for (int i = 0; i < inputNumber.length; i++) {
            sumNumber[i] = Arrays.stream(inputNumber[i]).sum();

        }
    }

    private static void initInputNumber(int[][] inputNumber, BufferedReader br) throws IOException {
        for (int i = 0; i < inputNumber.length; i++) {
            inputNumber[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
    }
}
