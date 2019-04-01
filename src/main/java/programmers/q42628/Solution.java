package programmers.q42628;

import java.util.*;

public class Solution {
    public int[] solution(String[] operations) {
        int[] answer;
        List<Integer> list = new LinkedList<>();

        for (int i = 0; i < operations.length; i++) {
            System.out.println(operations[i]);
            if (operations[i].startsWith("I ")) {
                list.add(Integer.parseInt(operations[i].split("I ")[1]));
                Collections.sort(list);
                continue;
            }

            if(list.isEmpty()) {
                continue;
            }

            if (operations[i].startsWith("D -")) {
                list.remove(0);
                continue;
            }

            if (operations[i].startsWith("D ")) {
                list.remove(list.size()-1);
            }
        }

        answer = new int[2];
        if (list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
            return answer;
        }

        answer[0] = list.get(list.size() - 1);
        answer[1] = list.get(0);
        return answer;
    }
}
