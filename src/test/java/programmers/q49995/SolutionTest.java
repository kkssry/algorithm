package programmers.q49995;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        Solution sol = new Solution();
        int[] cookie = {5,4,5,5,5,1};
        System.out.println(sol.solution(cookie));
    }
}