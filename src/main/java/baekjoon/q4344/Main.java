package baekjoon.q4344;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());

        double[] count = new double[input];
        for (int i = 0; i < count.length; i++) {
            String[] nums = br.readLine().split(" ",2)[1].split(" ");
            double average = Arrays.stream(nums).mapToInt(Integer::parseInt).average().getAsDouble();
            double averageHighCount = 0;
            for (int j = 0; j < nums.length; j++) {
                if (average < Integer.parseInt(nums[j])) {
                    averageHighCount++;
                }
            }
            double a = (averageHighCount / nums.length) *100000;
            count[i] = Math.round(a)/1000.000;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println(String.format("%.3f",count[i]) + "%");
        }

    }
}
