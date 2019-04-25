package programmers.skill.check.lv1.q912;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();

        assertThat(sol.solution("try hello world")).isEqualTo("TrY HeLlO WoRlD");
    }

    @Test
    public void splitTest() {
        String a = "asdf";
        String[] arr = a.split("");
        arr[1] = arr[1].toUpperCase();
        System.out.println(Arrays.toString(arr));
    }
}