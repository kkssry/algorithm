package programmers.q42578;

import java.util.*;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 0;
        int flag = 0;
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        for (String[] clothe : clothes) {
            for (String s : clothe) {
                flag++;
                if (flag % 2 == 0) {
                    if (map.containsKey(s)) {
                        map.put(s, map.get(s) + 1);
                        continue;
                    }
                    map.put(s, 1);
                }
            }
        }

        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            list.add(map.get(s)+1);
        }
        answer = list.stream().reduce(1,(a,b)->a*b);
        return answer-1;
    }
}
