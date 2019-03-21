package programmers.q42629;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SolutionTest {
    @Test
    public void mainTest() {
        int stock = 9;
        int[] dates = {3,5,10,15};
        int[] supplies = {1,1,6,20};
        int k = 11 ;

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
        System.out.println(list.poll());
        System.out.println(list.poll());
        System.out.println(list.poll());
    }

    @Test
    public void 맵테스트() {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(2,200);
        map.put(3,300);
        map.put(4,400);
        System.out.println(map.get(4));
        System.out.println(map.containsKey(3));
        System.out.println(map.containsKey(5));
    }
}