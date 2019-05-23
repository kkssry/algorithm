package baekjoon.q2908;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        for (int i = nums[0].length()-1; i >=0 ; i--) {
            if (nums[0].charAt(i) < nums[1].charAt(i)) {
                StringBuilder sb = new StringBuilder(nums[1]);
                System.out.println(sb.reverse());
                return;
            }

            if(nums[0].charAt(i) > nums[1].charAt(i)) {
                StringBuilder sb = new StringBuilder(nums[0]);
                System.out.println(sb.reverse());
                return;
            }
        }
    }

}
