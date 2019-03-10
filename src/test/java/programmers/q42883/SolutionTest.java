package programmers.q42883;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        String number = "1924";
        int k = 2;
        Solution sol = new Solution();
        System.out.println(sol.solution(number, k));
    }

    @Test
    public void name() {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(4);
        queue.add(1);
        queue.add(7);
        queue.add(7);
        queue.add(2);
        queue.add(5);
        queue.add(2);
        queue.add(8);
        queue.add(4);
        queue.add(1);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

        System.out.println(queue);
    }
}