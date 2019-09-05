package baekjoon.q12015;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
//        int count = Integer.parseInt(br.readLine());
        int[] number = initNumber(br);
        List<Integer> results = new ArrayList<>();
        saveResult(number, results);
        System.out.println(results.size());
    }

    private static void saveResult(int[] number, List<Integer> results) {
        results.add(number[0]);
        for (int i = 1; i < number.length; i++) {
            int compareNumber = number[i];
            if (results.get(results.size() - 1) < compareNumber) {
                results.add(compareNumber);
                continue;
            }
            int index = Collections.binarySearch(results, compareNumber);
            if (index < 0) {
                results.set(Math.abs(index + 1), compareNumber);
            }
        }
    }

    private static int[] initNumber(BufferedReader br) throws IOException {
        return Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
