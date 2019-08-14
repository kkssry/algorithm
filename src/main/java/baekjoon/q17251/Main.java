package baekjoon.q17251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();
        int[] arr = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int maxValue = Arrays.stream(arr).max().getAsInt();
        List<Integer> maxIndex = new ArrayList<>();
        initMaxIndex(arr,maxValue,maxIndex);
        int rCount = arr.length - maxIndex.get(maxIndex.size() - 1) - 1;
        int bCount = maxIndex.get(0);
        saveResult(rCount, bCount);
    }

    private static void saveResult(int rCount, int bCount) {
        if (rCount > bCount) {
            System.out.println("R");
        }
        if (rCount < bCount) {
            System.out.println("B");
        }
        if (rCount == bCount) {
            System.out.println("X");
        }
    }

    private static void initMaxIndex(int[] arr, int maxValue, List<Integer> maxIndex) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maxValue) {
                maxIndex.add(i);
            }
        }
    }
}
