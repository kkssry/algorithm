package programmers.q12914;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        assertThat(sol.solution(1)).isEqualTo(5);
    }
}