package programmers.q12936;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {3,1,2};
        assertThat(sol.solution(3,5)).isEqualTo(arr);
    }
}