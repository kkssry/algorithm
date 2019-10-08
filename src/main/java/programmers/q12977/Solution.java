package programmers.q12977;

public class Solution {
    static int answer = 0;

    public int solution(int[] nums) {
        selectNums(nums);
        return answer;
    }

    private void selectNums(int[] nums) {
        int depth = 0;
        int[] selectNums = new int[3];
        select(depth,0, nums, selectNums);
    }

    private void select(int depth, int index, int[] nums, int[] selectNums) {
        if (depth == 3) {
            if (isPrimeNumber(selectNums)) {
                answer++;
            }
            return;
        }

        for (int i = index; i < nums.length; i++) {
            selectNums[depth] = nums[i];
            select(depth + 1, i + 1, nums, selectNums);
        }
    }

    private boolean isPrimeNumber(int[] selectNums) {
        int sum = getSum(selectNums);
        int square = (int)Math.sqrt(sum);
        for (int i = 2; i <= square; i++) {
            if (sum % i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getSum(int[] selectNums) {
        int sum = 0;
        for (int selectNum : selectNums) {
            sum += selectNum;
        }
        return sum;
    }
}
