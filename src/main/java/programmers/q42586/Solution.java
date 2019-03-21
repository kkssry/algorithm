package programmers.q42586;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<>();

        Queue<Integer> progressQueue = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            progressQueue.offer(progresses[i]);
        }

        Queue<Integer> speedsQueue = new LinkedList();
        for (int i = 0; i < speeds.length; i++) {
            speedsQueue.offer(speeds[i]);
        }

        while (!progressQueue.isEmpty()) {
            int count = 0;
            double progreeQueueFirst = ((LinkedList<Integer>) progressQueue).peekFirst();
            double speedQueueFirst = ((LinkedList<Integer>) speedsQueue).peekFirst();
            double completeDays = (100 - progreeQueueFirst) / speedQueueFirst;
            int completeCount = (int) Math.ceil(completeDays);

            int percent = (int) ((LinkedList) speedsQueue).peekFirst() * completeCount + (int)progreeQueueFirst;

            while (percent >= 100) {
                count++;
                ((LinkedList) progressQueue).pollFirst();
                ((LinkedList) speedsQueue).pollFirst();

                if (progressQueue.isEmpty()) {
                    break;
                }
                percent = (int) ((LinkedList) speedsQueue).peekFirst() * completeCount + (int) ((LinkedList) progressQueue).peekFirst();
            }

            if (count >= 1) {
                list.add(count);
            }
        }


        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i).intValue();
        }
        return answer;

    }
}
