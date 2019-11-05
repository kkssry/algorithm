package programmers.q17677;

import java.util.*;
import java.util.List;


public class Solution {
    public int solution(String str1, String str2) {
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        initList(list1, str1);
        initList(list2, str2);

        if (list1.size() == 0 && list2.size() == 0) {
            return 65536;
        }

        boolean[] ischecked = new boolean[list2.size()];
        initIsChecked(list1, list2, ischecked);

        return (int) saveJacadeRatio(list1, ischecked);
    }


    private double saveJacadeRatio(List<String> list1, boolean[] ischecked) {
        double common = commonCount(ischecked);
        if (common == 0) {
            return 0;
        }
        double sum = list1.size() + OnlyList2Count(ischecked);
        double ratio = common / sum;
        System.out.println("ratio : " + ratio);
        return  ratio * 65536;
    }

    private double commonCount(boolean[] ischecked) {
        double common = 0;
        for (int i = 0; i < ischecked.length; i++) {
            if (ischecked[i]) {
                common++;
            }
        }
        return common;
    }

    private double OnlyList2Count(boolean[] ischecked) {
        double count = 0;
        for (boolean flag : ischecked) {
            if (!flag) {
                count++;
            }
        }
        return count;
    }

    private void initIsChecked(List<String> list1, List<String> list2, boolean[] ischecked) {
        for (int i = 0; i < list1.size(); i++) {
            for (int j = 0; j < list2.size(); j++) {
                if (list1.get(i).equalsIgnoreCase(list2.get(j)) && !ischecked[j]) {
                    ischecked[j] = true;
                    break;
                }
            }
        }
    }

    private void initList(List<String> list, String str) {
        for (int i = 0; i < str.length() - 1; i++) {
            char word1 = str.charAt(i);
            char word2 = str.charAt(i + 1);
            if (isWord(word1) && isWord(word2)) {
                list.add(word1 + "" + word2);
            }
        }
    }

    private boolean isWord(char word) {
        if ((word >= 'a' && word <= 'z') || (word >= 'A' && word <= 'Z')) {
            return true;
        }
        return false;
    }
}
