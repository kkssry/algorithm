package programmers.q42587;

import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        int[] priorities = {1,1,9,1,1,1};
        int location = 0;
        Solution sol = new Solution();
        System.out.println(sol.solution(priorities, location));
    }

    @Test
    public void queueTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        for (Integer integer : queue) {
            int a = integer;
            System.out.println(a);
        }

        int num = ((LinkedList<Integer>) queue).get(0);
        System.out.println("num : " + num);
        ((LinkedList<Integer>) queue).add(0,1);

    }

    @Test
    public void stackTest() {
        Stack<Integer> stack = new Stack<>();
        stack.add(0,100);
        stack.add(1, 200);
        stack.add(2, 300);

        System.out.println(stack.get(1));
    }

    @Test
    public void queueSequenceTest() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);

        queue.add(queue.poll());
        System.out.println(queue);
    }

    @Test
    public void priorityQueueTest() {

        List<Integer> list = new ArrayList<>(Arrays.asList(6,5,8,4,3,2));
        PriorityQueue<Integer> queue = new PriorityQueue<>(list);

        System.out.println(queue);

        while(!queue.isEmpty()) {
            System.out.println(queue.poll());
        }

    }
}