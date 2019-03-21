package programmers.q42862;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        int n = 5;
        int[] lost = {2,4};
        int[] reverse = {3};

        Solution sol = new Solution();
        System.out.println(sol.solution(n, lost, reverse));
    }
}