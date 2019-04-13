package programmers.q12936;

import java.util.Arrays;

public class Solution {
    long grade = 0;

    public int[] solution(int n, long k) {
        int[] answer = {};
        int[] nums = new int[n];

        for (int i = 0; i < nums.length; i++) {
            nums[i] = i + 1;
        }

        int findfirstIndex = factorial(n-1);

        long firstIndex = k / findfirstIndex;
        long findRest = k % findfirstIndex;

        swap(firstIndex,nums);


        return answer;
    }

    private void swap(long firstIndex, int[] nums) {
        int tmp = nums[0];
        nums[0] = nums[(int)firstIndex -1];
        nums[(int)firstIndex -1] = tmp;
    }

    private int factorial(int i) {
        int num = i;
        for (int j = num-1; j >=1 ; j--) {
            num *= j;
        }
        return num;
    }


}

