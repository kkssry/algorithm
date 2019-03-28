package programmers.q1845;

import java.util.*;
import java.util.Set;

public class Solution {
    public int solution(int[] nums) {
        int answer;

        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int pick = nums.length/2;

        if (set.size() >= pick) {
            answer = pick;
            return answer;
        }
        answer = set.size();

        return answer;
    }
}
