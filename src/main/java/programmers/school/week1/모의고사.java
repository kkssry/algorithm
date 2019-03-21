package programmers.school.week1;

import java.util.*;

public class 모의고사 {
    public int[] solution(int[] answers) {
        int[] answer = new int[3];
        List<Integer> list = new ArrayList<>();

        int[] mathLoser = {1,2,3,4,5};
        int[] mathLoser2 = {2,1,2,3,2,4,2,5};
        int[] mathLoser3 = {3,3,1,1,2,2,4,4,5,5};

        for (int i = 0; i < answers.length; i++) {
            int correct = answers[i];

            if (correct == mathLoser[i % mathLoser.length]) {
                answer[0]++;
            }
            if (correct == mathLoser2[i % mathLoser2.length]) {
                answer[1]++;
            }
            if (correct == mathLoser3[i % mathLoser3.length]) {
                answer[2]++;
            }
        }

        System.out.println(Arrays.toString(answer));

        int max = answer[0];

        for (int i = 1; i < answer.length; i++) {
            if (max < answer[i]) {
                max = answer[i];
            }
        }
        System.out.println(max);

        for (int i = 0; i < answer.length; i++) {
            if (answer[i] > 0 && answer[i] == max) {
                list.add(i+1);
            }
        }

        answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}
