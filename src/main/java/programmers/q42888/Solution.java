package programmers.q42888;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        Map<String, String> idAndName = new HashMap<>();
        initIdAndName(idAndName, record);
        int answerCount = initAnswer(record);
        answer = new String[answerCount];
        printResult(idAndName, record, answer);
        return answer;
    }

    private int initAnswer(String[] record) {
        int count = 0;
        for (int i = 0; i < record.length; i++) {
            String[] sentence = record[i].split(" ");
            if (sentence[0].equals("Enter") || sentence[0].equals("Leave")) {
                count++;
            }
        }
        return count;
    }

    private void printResult(Map<String, String> idAndName, String[] record, String[] answer) {
        int count = 0;
        for (int i = 0; i < record.length; i++) {
            String[] sentence = record[i].split(" ");
            if (sentence[0].equals("Enter")) {
                answer[count] = idAndName.get(sentence[1])+"님이 들어왔습니다.";
                count++;
            }
            if (sentence[0].equals("Leave")) {
                answer[count] = idAndName.get(sentence[1])+"님이 나갔습니다.";
                count++;
            }
        }
    }

    private void initIdAndName(Map<String, String> idAndName, String[] record) {
        for (int i = 0; i < record.length; i++) {
            String[] sentence = record[i].split(" ");
            if (sentence[0].equals("Enter")) {
                idAndName.put(sentence[1], sentence[2]);
            }
            if (sentence[0].equals("Change")) {
                idAndName.replace(sentence[1],idAndName.get(sentence[1]), sentence[2]);
            }
        }
    }
}
