package programmers.school.week1;

import java.util.*;

public class 소수만들기 {
    int substract = 0;

    public int solution(int[] nums) {
        int answer = -1;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = 0; k < ; k++) {
                    isSosu(nums[i] + nums[j] + nums[k])
                }
            }
        }

        return answer;
    }


    private boolean isPrime(int sum) {
        for (int i = 2; i <= Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }


}
