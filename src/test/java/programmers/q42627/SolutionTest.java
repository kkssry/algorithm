package programmers.q42627;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        assertThat(new Solution().solution(new int[][]{{0, 3}, {1, 9}, {2, 6}})).isEqualTo(9);
    }

    @Test
    public void priorityQueueTest() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Arrays.asList(5, 2, 4, 3, 1));

        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());

    }

    @Test
    public void recurssiveTest() {
        int[] a = {1, 2, 3, 4};
        callRecurssive(a, 0);
    }

    private void callRecurssive(int[] a, int depth) {
        if (depth == a.length - 1) {
            print(a);
            return;
        }

        for (int i = depth; i < a.length; i++) {
            swap(a, i, depth);
            callRecurssive(a, depth + 1);
            swap(a, i, depth);
        }

    }

    private void swap(int[] a, int i, int depth) {
        int temp = a[i];
        a[i] = a[depth];
        a[depth] = temp;
    }

    private void print(int[] a) {
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void listTest() {
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        callList(list);
        System.out.println(list);
    }

    private void callList(List<Integer> list) {
        list.set(0,9);
        list.set(1,100);
    }
}