package baekjoon.q2003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int numCount = Integer.parseInt(st.nextToken());
        int targetNum = Integer.parseInt(st.nextToken());

        int[] nums = new int[numCount];
        initNums(nums,br,st);

        saveCaseCount(nums,targetNum);
    }

    private static void saveCaseCount(int[] nums, int targetNum) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int copyTargetNum = targetNum;
            for (int j = i; j < nums.length; j++) {
                copyTargetNum -= nums[j];
                if (copyTargetNum < 0) {
                    break;
                }
                if (copyTargetNum == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    private static void initNums(int[] nums, BufferedReader br, StringTokenizer st) throws IOException {
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
    }
}
