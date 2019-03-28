package programmers.q42885;

import java.util.*;

public class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        List<Integer> persons = new LinkedList<>();
        for (int i = 0; i < people.length; i++) {
            persons.add(people[i]);
        }
        Collections.sort(persons);

        while (true) {
            if (persons.size() <= 1) {
                answer++;
                return answer;
            }

//            persons.remove(persons.get(persons.size()-1));
            persons.remove(persons.size() - 1);

            answer++;
            if (limit- persons.get(persons.size()-1) >= persons.get(0)) {
                persons.remove(0);
            }
        }
    }

}
