package baekjoon.q11399;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(br.readLine());
        int[] personalWaitTime = new int[input];
        initWaitTime(personalWaitTime,br);

        Arrays.sort(personalWaitTime);
        calculateTimes(personalWaitTime);
    }

    private static void calculateTimes(int[] personalWaitTime) {
        int totalTime = personalWaitTime[0];

        for (int i = 1; i < personalWaitTime.length; i++) {
            for (int j = 0; j <= i; j++) {
                totalTime += personalWaitTime[j];
            }
        }
        System.out.println(totalTime);
    }

    private static void initWaitTime(int[] waitTime, BufferedReader br) throws IOException {
        int[] times = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < waitTime.length; i++) {
            waitTime[i] = times[i];
        }
    }
}
