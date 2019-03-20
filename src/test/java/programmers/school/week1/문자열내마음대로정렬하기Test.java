package programmers.school.week1;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 문자열내마음대로정렬하기Test {
        String[] input = {"sun","bed","car"};
        String[] input2 = {"abce","abcd","cdx"};

        String[] answer = {"car","bed","sun"};
        String[] answer2 = {"abcd","abce","cdx"};
        문자열내마음대로정렬하기 sol = new 문자열내마음대로정렬하기();

    @Test
    public void mainTest1() {
        System.out.println(Arrays.toString(sol.solution(input2,2)));
    }

    @Test
    public void mainTest() {
        assertThat(sol.solution(input,1)).isEqualTo(answer);
        assertThat(sol.solution(input2,1)).isEqualTo(answer2);
    }
}