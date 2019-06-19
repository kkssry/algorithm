package programmers.q42889;

import java.util.Arrays;

public class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = {};

        Stage[] peopleStage = new Stage[N];

        initPeopleStageForNumber(peopleStage);

        initPeopleStageForCount(peopleStage, stages);

        initPeopleStageForRate(peopleStage, stages.length);

        Arrays.sort(peopleStage);
        answer = new int[N];
        initAnswer(answer,peopleStage);

        return answer;
    }

    private void initAnswer(int[] answer, Stage[] peopleStage) {
        for (int i = 0; i < answer.length; i++) {
            answer[i] = peopleStage[i].stageNumber + 1;
        }
    }

    private void initPeopleStageForNumber(Stage[] peopleStage) {
        for (int i = 0; i < peopleStage.length; i++) {
            peopleStage[i] = new Stage(i);
        }
    }

    private void initPeopleStageForCount(Stage[] peopleStage, int[] stages) {
        int length = peopleStage.length;
        for (int i = 0; i < stages.length; i++) {
            if (length - 1 >= stages[i] - 1) {
                peopleStage[stages[i] - 1].count += 1;
            }
        }
    }

    private void initPeopleStageForRate(Stage[] peopleStage, double length) {
        double newLength = length;
        for (int i = 0; i < peopleStage.length; i++) {
            if (i > 0) {
                newLength -= peopleStage[i - 1].count;
            }

            if(newLength == 0) {
                peopleStage[i].failRate = 0;
                continue;
            }

            peopleStage[i].failRate = peopleStage[i].count / newLength;
        }
    }

    class Stage implements Comparable<Stage> {
        int stageNumber = 0;
        int count = 0;
        double failRate = 0;

        public Stage(int stageNumber) {
            this.stageNumber = stageNumber;
        }

        @Override
        public int compareTo(Stage o) {
            if (o.failRate > failRate) {
                return 1;
            }
            return -Double.compare(failRate,o.failRate);
        }

        @Override
        public String toString() {
            return "Stage{" +
                    "stageNumber=" + stageNumber +
                    ", count=" + count +
                    ", failRate=" + failRate +
                    '}';
        }
    }
}


