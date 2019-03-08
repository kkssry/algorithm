package programmers.q12935;

import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {7,4,7,3,1,3,2,-4,-9};
        System.out.println(Arrays.toString(sol.solution(arr)));
    }

    @Test
    public void name() {
        int[] a = new int[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(20);
        a[0] = queue.poll();
        a[1] = queue.poll();
        System.out.println(queue);
        System.out.println(Arrays.toString(a));
    }
}