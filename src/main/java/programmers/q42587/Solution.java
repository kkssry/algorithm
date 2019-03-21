package programmers.q42587;

import java.util.*;

public class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        LinkedList<NumberManage> priorityManage = new LinkedList<>();
        PriorityQueue<Integer> order = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            if (i == location) {
                NumberManage numberManage = new NumberManage(priorities[i]);
                numberManage.setChoice(true);
                priorityManage.add(numberManage);
                order.add(priorities[i]);
                continue;
            }
            order.add(priorities[i]);
            priorityManage.add(new NumberManage(priorities[i]));
        }       // 셋팅

        for (int i = 0; i < priorities.length; i++) {
            while(order.peek() != priorityManage.get(i).getPriorityDegree()) {
                int top = order.peek();
                if (priorityManage.get(i).getPriorityDegree() < top) {
                    priorityManage.add( priorityManage.remove(i));
                }
            }
            order.poll();
        }

        for (int i = 0; i < priorityManage.size(); i++) {
            if (priorityManage.get(i).isChoice()) {
                answer = i + 1;
            }
        }

        return answer;
    }

    class NumberManage {
        int priorityDegree;
        boolean choice = false;

        public NumberManage(int priorityDegree) {
            this.priorityDegree = priorityDegree;
        }

        public void setChoice(boolean choice) {
            this.choice = choice;
        }

        public boolean isChoice() {
            return choice;
        }

        public int getPriorityDegree() {
            return priorityDegree;
        }
    }

}


