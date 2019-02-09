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
            if (skill_trees[i].contains(skills[0])) {
                continue;
            }
            for (int j = 0; j < skills.length; j++) {
                list.add(skill_trees[i].substring(skill_trees[i].indexOf(skills[j])));

            }
            
        }

        return answer;
    }
}
