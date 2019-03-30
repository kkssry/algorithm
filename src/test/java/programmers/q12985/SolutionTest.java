package programmers.q12985;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        assertThat(sol.solution(16,3,4)).isEqualTo(3);
    }

    @Test
    public void 로그테스트() {
        int a = 16;
        System.out.println(Math.log(16)/Math.log(2));
    }
}