package programmers.q42886;

import java.util.Arrays;

public class Solution {
    public int solution(int[] weight) {
        long answer;
        int hunter = 1;
        Arrays.sort(weight);            //답봄... 놀라운 공식이 있다니..

        for (int i = 0; i < weight.length; i++) {
            if (hunter < weight[i]) {
                break;
            }
            hunter+=weight[i];
        }

        answer=  hunter;
        return (int)answer;
    }
}
