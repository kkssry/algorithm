package baekjoon.q36293;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        for (int i = 0; i < input; i++) {
            int[] nums = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int[] copy = Arrays.copyOf(nums,nums.length);
            int gcd = gcd(copy);
            System.out.println(gcd * nums[0] / gcd * nums[1] / gcd);
        }
    }

    private static int gcd(int[] nums) {
        int rest;
        Arrays.sort(nums);
        rest = nums[0] % nums[1];
        while(rest != 0) {
            nums[0] = nums[1];
            nums[1] = rest;
            rest = nums[0] % nums[1];
        }

        return Math.min(nums[0],nums[1]);

    }
}
