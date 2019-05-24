package programmers.skill.check.lv2.q477;

public class Solution {
    public int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (isSosu(nums[i],nums[j],nums[k])) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

    private boolean isSosu(int num, int num1, int num2) {
        int total = num + num1 + num2;
        int number = (int)Math.sqrt(total) + 1;
        for (int i = 0; i < number; i++) {
            if (total % i == 0) {
                return false;
            }
        }
        return true;
    }
}
