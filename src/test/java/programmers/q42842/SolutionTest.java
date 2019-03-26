package programmers.q42842;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        assertThat(sol.solution(10,2)).containsExactly(4,3);
        assertThat(sol.solution(8,1)).containsExactly(3,3);
        assertThat(sol.solution(24,24)).containsExactly(8,6);
    }
}