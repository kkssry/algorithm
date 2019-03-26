package programmers.q42842;

import java.util.*;

public class Solution {
    public int[] solution(int brown, int red) {
        int[] answer = new int[2];
        Map<Integer, Integer> redArea = new HashMap<>();


        for (int i = 1; i <= Math.sqrt(red); i++) {
            if (red % i ==0) {
                redArea.put(i,red/i);
            }
        }
        
        Iterator iterator = redArea.entrySet().iterator();
        while(iterator.hasNext()) {
            Map.Entry entry = (Map.Entry)iterator.next();
            int result = squareArea((int)entry.getKey(), (int)entry.getValue());
            if (brown == result) {
                answer[0] = (int)entry.getKey() + 2;
                answer[1] = (int)entry.getValue() + 2;
            }
        }

        if (answer[0] < answer[1]) {
            int tmp;
            tmp = answer[1];
            answer[1] = answer[0];
            answer[0] = tmp;
        }


        return answer;
    }

    public int squareArea(int a, int b) {
        int area = (a + 2) * (b + 2);
        return area - a * b;
    }
}
