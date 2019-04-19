package baekjoon.find.rule.q1924;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nums = br.readLine().split(" ");

        int[] calendar = new int[nums.length];
        calendar[0] = Integer.parseInt(nums[0]);
        calendar[1] = Integer.parseInt(nums[1]);

        int allDay = 0;

        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        String[] day = {"SUN","MON","TUE","WED","THU","FRI","SAT"};

        for (int i = 1; i < calendar[0]; i++) {
            allDay += days[i-1];
        }
        allDay += calendar[1];
        System.out.println(day[(allDay % 7)]);
    }

}
