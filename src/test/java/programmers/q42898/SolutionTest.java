package programmers.q42898;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        int[][] puddles = {{2, 2}};
        Solution sol = new Solution();
        sol.solution(4, 3, puddles);
//        assertThat(1).isEqualTo(2);
    }
}