package programmers.q12987;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] a = {5, 1, 3, 7};
        int[] b = {2, 2, 6, 8};


//        sol.permutation(b,0);


        assertThat(sol.solution(a,b)).isEqualTo(3);
    }

}