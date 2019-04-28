package programmers.q12946;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[][] arr = {{1,2},{1,3},{2,3}};
        assertThat(sol.solution(2)).isEqualTo(arr);
    }
}