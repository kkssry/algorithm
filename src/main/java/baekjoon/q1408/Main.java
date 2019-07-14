package baekjoon.q1408;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Integer[] currentTime = Arrays.stream(br.readLine().split(":")).map(Integer::parseInt).toArray(Integer[]::new);
        Integer[] missionDeadLine = Arrays.stream(br.readLine().split(":")).map(Integer::parseInt).toArray(Integer[]::new);

        Calendar currentTime1 = Calendar.getInstance();
        currentTime1.set(Calendar.HOUR, currentTime[0]);
        currentTime1.set(Calendar.MINUTE, currentTime[1]);
        currentTime1.set(Calendar.SECOND, currentTime[2]);

        Calendar missionDeadLine1 = Calendar.getInstance();
        missionDeadLine1.set(Calendar.HOUR, missionDeadLine[0]);
        missionDeadLine1.set(Calendar.MINUTE, missionDeadLine[1]);
        missionDeadLine1.set(Calendar.SECOND, missionDeadLine[2]);

        if (currentTime1.getTimeInMillis() > missionDeadLine1.getTimeInMillis()) {
            missionDeadLine1.add(Calendar.DATE, 1);
        }

        int seconds = (int) Math.abs(currentTime1.getTimeInMillis() - missionDeadLine1.getTimeInMillis()) / 1000;
        int[] hourMinuteSecond = new int[3];
        initHourMinuteSecond(hourMinuteSecond, seconds);
        printResult(hourMinuteSecond);

    }

    private static void printResult(int[] hourMinuteSecond) {
        for (int i = 0; i < hourMinuteSecond.length; i++) {
            System.out.print(String.format("%02d", hourMinuteSecond[i]));
            if (i != hourMinuteSecond.length - 1) {
                System.out.print(":");
            }
        }
    }

    private static void initHourMinuteSecond(int[] hourMinuteSecond, int seconds) {
        int[] nums = {3600, 60, 1};
        for (int i = 0; i < nums.length; i++) {
            hourMinuteSecond[i] = seconds / nums[i];
            seconds %= nums[i];
        }


    }
}
