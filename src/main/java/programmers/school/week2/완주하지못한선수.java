package programmers.school.week2;

import java.util.*;
import java.util.Arrays;
import java.util.List;

public class 완주하지못한선수 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";

        Map<String,Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                int add = map.get(participant[i])+1;
                map.put(participant[i],add);
                continue;
            }
            map.put(participant[i],1);
        }

        for (int i = 0; i < completion.length; i++) {
            if (map.containsKey(completion[i])) {
                int sub = map.get(completion[i]) - 1;
                map.put(completion[i],sub);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            if (map.get(participant[i]) == 1) {
                answer = participant[i];
                break;
            }
        }

        return answer;
    }
}
