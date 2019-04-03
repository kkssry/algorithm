package programmers.school.week3;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 네트워크Test {
    @Test
    public void solutionTest() {
        네트워크 sol = new 네트워크();
        int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        int[][] computers2 = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};

        assertThat(sol.solution(3, computers)).isEqualTo(2);
//        assertThat(sol.solution(3, computers2)).isEqualTo(1);
    }

}