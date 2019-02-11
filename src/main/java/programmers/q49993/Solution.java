package programmers.q49993;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        List<String> list = new ArrayList<>();

        String[] skills = skill.split("");

        for (int i = 0; i < skill_trees.length; i++) {
            list.clear();
            if (!skill_trees[i].contains(skills[0])) {
                continue;
            }

            for (int j = 0; j < skill_trees[i].length(); j++) {
                String[] arr = skill_trees[i].split("");
                if (skill.contains(arr[j])) {
                    list.add(arr[j]);
                }
            }
            System.out.println(list);
            for (int k = 0; k < list.size(); k++) {
                if (!list.get(k).equals(skills[k])) {
                    break;
                }
                if (list.get(k).equals(skills[k])) {
                    if (k == list.size()-1) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }
}
