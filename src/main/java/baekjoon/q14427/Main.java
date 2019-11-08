package baekjoon.q14427;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int count = Integer.parseInt(br.readLine());
        int[] nums = new int[count];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nums.length; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int queryCount = Integer.parseInt(br.readLine());
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (min > nums[i]) {
                min = nums[i];
                minIndex = i;
            }
        }

        for (int i = 0; i < queryCount; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.nextToken().equals("1")) {
                int index = Integer.parseInt(st.nextToken()) - 1;
                int num = Integer.parseInt(st.nextToken());
                nums[index] = num;
                if (min == num && minIndex > index) {
                    minIndex = index;
                } else if (min > num) {
                    min = num;
                    minIndex = index;
                } else if (minIndex == index && min < num) {
                    min = 100001;
                    for (int j = 0; j < nums.length; j++) {
                        if (min > nums[j]) {
                            min = nums[j];
                            minIndex = j;
                        }
                    }
                }
            } else {
                bw.write(String.valueOf(minIndex + 1) + "\n");
            }
        }
        bw.flush();
    }


}


