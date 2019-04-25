package programmers.skill.check.lv1;


import org.junit.Test;
import programmers.skill.check.lv1.q911.Solution;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void maintest() {
        Solution sol = new Solution();
        String[] s = {"Jane, Kim"};
        System.out.println(sol.solution(s));
        assertThat(sol.solution(s)).isEqualTo("김서방은 1에 있다.");
    }
}