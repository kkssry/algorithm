package programmers.q42585;

import org.junit.Test;
import programmers.q42586.Solution;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SolutionTest {
    @Test
    public void mainTest() {
        int[] progresses = {15, 1, 14, 9, 29, 25, 17, 24, 4, 27, 7, 19, 29, 14, 23, 4, 21, 3, 8, 14};
        int[] speeds = {9, 11, 21, 16, 11, 21, 7, 5, 6, 30, 11, 24, 26, 18, 20, 18, 15, 30, 7, 18};
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.solution(progresses, speeds)));
    }

    @Test
    public void queueTest() {
        int[] progresses = {93, 30, 55};
        Queue progressQueue = new LinkedList();
        for (int i = 0; i < progresses.length; i++) {
            progressQueue.add(progresses[i]);
        }
        int a = (int) ((LinkedList) progressQueue).peekFirst();
        System.out.println(a);
        System.out.println(a == 93);
        System.out.println(a > 93);
    }

    @Test
    public void 올림테스트() {
        double a = 3.1;
        System.out.println((int)Math.ceil(a));
    }

    @Test
    public void 큐순서테스트() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(12);
        queue.offer(11);
        queue.offer(6);

        System.out.println(queue.toString());
        for (int i = 0; i < queue.size(); i++) {
            System.out.println(((LinkedList<Integer>) queue).get(i));
        }
    }

    @Test
    public void 나누기타입() {
        double a = (100-15)/(double)9;
        System.out.println(a);
        System.out.println(Math.ceil(a));
    }
}