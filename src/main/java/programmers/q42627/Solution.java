package programmers.q42627;

import java.util.*;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    int maxTime;
    PriorityQueue<Integer> bestTime = new PriorityQueue<>();

    public int solution(int[][] jobs) {
        int answer = 0;
        List<Work> works = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            works.add(new Work(jobs[i][0], jobs[i][1]));
        }

        callRecursive(works, 0);

        System.out.println();
        answer = bestTime.poll();
        return answer;
    }

    private void callRecursive(List<Work> works, int depth) {
        if (depth == works.size()) {
            if (maxTime > progressTime(works)) {
                maxTime = progressTime(works);
            }
            System.out.println(works);
            return;
        }

        for (int i = depth; i < works.size(); i++) {
            swap(works, i, depth);
            callRecursive(works, depth + 1);
            swap(works, i, depth);
        }
    }

    private void swap(List<Work> works, int i, int depth) {
        Work temp = works.get(i);
        works.set(i, works.get(depth));
        works.set(depth, temp);
    }

    private int progressTime(List<Work> works) {
        int totalTime = 0;
        int endTime = 0;
        Work currentWorking = null;


        while(works.stream().filter(i->i.isComplete).count() != works.size()) {
            int time = 0;
            for (Work work : works) {
                if (work.arrive == time) {
                    work.start();
                    currentWorking = work;
                }
            }


            time++;
        }


        return totalTime;
    }


    class Work {
        int arrive;
        int workingTime;
        int waitTime = 0;
        int progress = 0;
        boolean isComplete = false;
        boolean isStart = false;

        public Work(int arrive, int workingTime) {
            this.arrive = arrive;
            this.workingTime = workingTime;
        }

        public void waitting() {
            ++workingTime;
        }

        public void complete() {
            isComplete = !isComplete;
        }

        public void start() {
            isStart = !isStart;
        }

        public void progress() {
            ++progress;
        }

        @Override
        public String toString() {
            return "Work{" +
                    "arrive=" + arrive +
                    ", workingTime=" + workingTime +
                    '}';
        }
    }
}
