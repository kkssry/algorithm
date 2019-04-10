package programmers.q12987;


import org.junit.Test;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] a = {5, 1, 3, 7, 9, 5};
        int[] b = {2, 2, 6, 8, 10, 3};


//        sol.permutation(b,0);


        assertThat(sol.solution(a, b)).isEqualTo(4);
    }

    @Test
    public void name() {
        Queue<Integer> pr = new LinkedList<>();
        pr.add(10);
        pr.add(7);
        pr.add(3);
        pr.add(1);
        pr.add(2);

        for (int i = pr.size(); i >=0 ; i--) {
            System.out.println(pr.poll());
        }
    }
}