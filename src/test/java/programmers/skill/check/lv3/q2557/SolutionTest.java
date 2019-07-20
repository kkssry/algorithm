package programmers.skill.check.lv3.q2557;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void maintest() {
        Solution sol = new Solution();
        int n = 6;
        int[][] vertex = new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        sol.solution(n,vertex);
    }
}