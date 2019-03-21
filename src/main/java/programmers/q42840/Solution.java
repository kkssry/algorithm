package programmers.q42840;

import java.util.*;

public class Solution {
    public int[] solution(int[] answers) {
        int[] answer={};
        Set<Integer> set = new TreeSet<>();

        int[] student = {1, 2, 3, 4, 5};
        int studentCorrect = 0;
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int student2Correct = 0;
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int student3Correct = 0;

        for (int i = 0; i < answers.length; i++) {
            int correct = answers[i];
            if (correct == student[i % 5]) {
                studentCorrect++;
            }
            if (correct == student2[i % 8]) {
                student2Correct++;
            }
            if (correct == student3[i % 10]) {
                student3Correct++;
            }
        }

        set.add(studentCorrect);
        set.add(student2Correct);
        set.add(student3Correct);

        if (set.size() == 3) {
            int correctAnswerCount = ((TreeSet<Integer>) set).last().intValue();

            if (studentCorrect == correctAnswerCount) {
                answer = new int[]{1};
            }
            if (student2Correct == correctAnswerCount) {
                answer = new int[]{2};
            }
            if (student3Correct == correctAnswerCount) {
                answer = new int[]{3};
            }
        }

        if (set.size() == 2) {  // 1등이 1명 혹은 2명
            int correctAnswerCount = ((TreeSet<Integer>) set).last();

            if (studentCorrect == correctAnswerCount) {
                if (student2Correct == correctAnswerCount) {
                    answer = new int[]{1,2};
                }else if(student3Correct == correctAnswerCount) {
                    answer = new int[]{1,3};
                }else {
                    answer = new int[]{1};
                }

            }

            if (student2Correct == correctAnswerCount) {
                if (studentCorrect == correctAnswerCount) {
                    answer = new int[]{1,2};
                }else if(student3Correct == correctAnswerCount) {
                    answer = new int[]{2,3};
                }else {
                    answer = new int[]{2};
                }

            }

            if (student3Correct == correctAnswerCount) {
                if (student2Correct == correctAnswerCount) {
                    answer = new int[]{2,3};
                }else if(studentCorrect == correctAnswerCount) {
                    answer = new int[]{1,3};
                }else {
                    answer = new int[]{3};
                }

            }
        }

        if (set.size() == 1) {
            answer = new int[]{1,2,3};
        }

        return answer;
    }
}
