package programmers.q42588;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] heights = {1,5,3,6,7,6,5};
        System.out.println(Arrays.toString(sol.solution(heights)));
    }

    @Test
    public void 큐출력() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(9);
        queue.add(4);
        queue.add(3);

        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    @Test
    public void 스택출력() {
        Stack<Integer> stack = new Stack<>();
        stack.add(9);
        stack.add(4);
        stack.add(3);

        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}