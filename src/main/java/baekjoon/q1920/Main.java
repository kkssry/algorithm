package baekjoon.q1920;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import static java.util.Arrays.binarySearch;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        int[] nums = Arrays.stream(inputs).mapToInt(Integer::parseInt).sorted().toArray();

        int input2 = Integer.parseInt(br.readLine());
        String[] inputs2 = br.readLine().split(" ");
        int[] nums2 = Arrays.stream(inputs2).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < nums2.length; i++) {
            if (binarySearch(nums,nums2[i]) >= 0) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
