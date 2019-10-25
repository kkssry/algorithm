package programmers.q12978;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        Solution sol = new Solution();
        int[][] road = {{1,2,1}, {2,3,3}, {5,2,2}, {1,4,2}, {5,3,1}, {5,4,2}};
        int[][] road2 = {{1,2,1}, {1,3,2}, {2,3,2}, {3,4,3}, {3,5,2}, {5,6,1}};
        System.out.println(sol.solution(6, road2, 4));
    }
}