package programmers.q1829;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        Solution sol = new Solution();
        int[][] picture = {{1,1,1,0},{1,2,2,0},{1,0,0,1},{0,0,0,1},{0,0,0,3},{0,0,0,3}};
        System.out.println(Arrays.toString(sol.solution(6,4, picture)));
    }
}