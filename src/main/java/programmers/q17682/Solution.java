package programmers.q17682;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solution(String dartResult) {
        int answer;
        List<Integer> scores = new ArrayList<>();
        List<String> bonus = new ArrayList<>();
        List<String> options = new ArrayList<>();
        initBonusAndOptions(bonus, options, dartResult);
        String changeResult = remainScores(dartResult);
        initScores(scores, changeResult);
        adaptBonus(scores,bonus);
        adpatOptions(scores, options);
        answer = saveScores(scores);
        return answer;
    }

    private int saveScores(List<Integer> scores) {
        return scores.stream().mapToInt(i-> i).sum();
    }

    private void adpatOptions(List<Integer> scores, List<String> options) {
        for (int i = 0; i < 3; i++) {
            if (options.get(i).equals("*")) {
                scores.set(i, scores.get(i) * 2);
                if (i > 0) {
                    scores.set(i - 1, scores.get(i - 1) * 2);
                }
            }

            if (options.get(i).equals("#")) {
                scores.set(i, scores.get(i) * -1);
            }
        }
    }

    private String remainScores(String eachCharacter) {
        for (int i = 0; i < eachCharacter.length(); i++) {
            try {
                Integer.parseInt(eachCharacter.charAt(i) + "");
            } catch (NumberFormatException e) {
                eachCharacter = eachCharacter.replace(eachCharacter.charAt(i), 'a');
            }
        }
        return eachCharacter;
    }


    private void initScores(List<Integer> scores, String eachCharacter) {
        String[] onlyNumber = eachCharacter.split("a");
        for (String number : onlyNumber) {
            try {
                scores.add(Integer.parseInt(number));
            } catch (NumberFormatException ignored) { }
        }
    }

    private void adaptBonus(List<Integer> scores, List<String> bonus) {
        for (int i = 0; i < 3; i++) {
            if (bonus.get(i).equals("D")) {
                scores.set(i, scores.get(i) * scores.get(i));
            }
            if (bonus.get(i).equals("T")) {
                scores.set(i, scores.get(i) * scores.get(i) * scores.get(i));
            }
        }
    }

    private void initBonusAndOptions(List<String> bonus, List<String> options, String eachCharacter) {
        for (int i = 0; i < eachCharacter.length(); i++) {
            char character = eachCharacter.charAt(i);
            if (character == 'S' || character == 'D' || character == 'T') {
                bonus.add(character + "");
                if (i + 1 < eachCharacter.length() && (eachCharacter.charAt(i + 1) == '*' || eachCharacter.charAt(i + 1) == '#')) {
                    options.add(eachCharacter.charAt(i + 1) + "");
                } else {
                    options.add("1");
                }
            }
        }
    }

}
