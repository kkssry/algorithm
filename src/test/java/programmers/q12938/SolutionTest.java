package programmers.q12938;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol =new Solution();
        assertThat(sol.solution(2,9)).containsExactly(4,5);
        assertThat(sol.solution(2,1)).containsExactly(-1);
    }
}