package programmers.school.week4;

import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class 도둑질Test {
    @Test
    public void mainTest() {
        도둑질 sol = new 도둑질();
        int[] arr = {1,2,3,1};
        int[] arr2 = {8,9,5,14,11,12,10};

        assertThat(sol.solution(arr2)).isEqualTo(35);
    }
}