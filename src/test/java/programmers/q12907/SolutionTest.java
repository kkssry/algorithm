package programmers.q12907;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {1,2,5};
        assertThat(sol.solution(5,arr)).isEqualTo(4);
    }
}