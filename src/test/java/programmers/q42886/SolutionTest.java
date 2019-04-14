package programmers.q42886;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {3, 1, 6, 2, 7, 30, 1};
        assertThat(sol.solution(arr)).isEqualTo(21);

    }
}