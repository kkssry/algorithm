package programmers.q17684;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int[] solution(String msg) {
        List<Integer> list = new ArrayList<>();
        Map<String, Integer> words = new HashMap<>();
        initWords(words);
        startCompress(list , words, msg + " ");
        int[] answer = new int[list.size()];
        initAnswer(answer , list);
        return answer;
    }

    private void initAnswer(int[] answer, List<Integer> list) {
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }
    }

    private void startCompress(List<Integer> list, Map<String, Integer> words, String msg) {
        int startIndex = -1;
        for (int i = 0; i < msg.length(); i++) {
            if(i < startIndex) {
                continue;
            }
            StringBuilder sb = new StringBuilder();
            char startChar = msg.charAt(i);
            sb.append(startChar);
            for (int j = i+1; j < msg.length(); j++) {
                sb.append(msg.charAt(j));
                if (words.get(sb.toString()) == null) {
                    startIndex = j;
                    words.put(sb.toString(), words.size() + 1);
                    list.add(words.get(sb.deleteCharAt(sb.length() - 1).toString()));
                    break;
                }
            }
        }
    }

    private void initWords(Map<String, Integer> words) {
        for (int i = 65; i <= 90; i++) {
            words.put(String.valueOf((char)i), i -64);
        }
    }
}
