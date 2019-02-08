package programmers.q42747;

import java.util.*;

public class Solution {
    public int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        for(int i = citations.length - 1; i >= 0; i--) {
            if(citations[i] <= answer)
                return answer;

            answer++;
        }

        return answer;
    }
}
