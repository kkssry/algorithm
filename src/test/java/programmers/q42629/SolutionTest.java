package programmers.q42629;

import org.junit.Test;

import java.util.Collections;
import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        int stock = 4;
        int[] dates = {4,10,15};
        int[] supplies = {20,5,10};
        int k = 30;
        int result = 2;

        Solution sol = new Solution();
        System.out.println(sol.solution(stock, dates, supplies, k));
    }

    @Test
    public void priorityQueueTest() {
        int[] supplies = {20 ,5, 10};
        PriorityQueue<Integer> list = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < supplies.length; i++) {
            list.add(supplies[i]);
        }
        System.out.println(list.peek());
        System.out.println(list.peek());
        System.out.println(list.peek());
    }
}