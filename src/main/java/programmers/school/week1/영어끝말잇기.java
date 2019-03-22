package programmers.school.week1;

import java.util.*;

public class 영어끝말잇기 {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        String first= words[0].charAt(words[0].length() -1) + "";
        List<String> list = new ArrayList<>();
        list.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            if (list.contains(words[i]) || !words[i].startsWith(first)) {
                answer[0] = (i % n) + 1;
                answer[1] = i/n + 1;
                return answer;
            }
            list.add(words[i]);
            first = words[i].charAt(words[i].length()-1) + "";
        }

        answer[0] = 0;
        answer[1] = 0;

        return answer;
    }
}
