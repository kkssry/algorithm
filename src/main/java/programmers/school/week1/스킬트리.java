package programmers.school.week1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 스킬트리 {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        List<String> list = new ArrayList<>();


        for (String skill_tree : skill_trees) {
            list.clear();
            for (int j = 0; j < skill_tree.length(); j++) {
                if (skill.contains(skill_tree.charAt(j)+"")) {
                    list.add(skill_tree.charAt(j) +"");
                }
            }


            boolean isExist = true;

            for (int i = 0; i < list.size(); i++) {
                if (!list.get(i).equals(skill.charAt(i)+"")) {
                    isExist = false;
                    break;
                }
            }

            if (isExist) {
                ++answer;
            }

        }

        return answer;
    }
}
