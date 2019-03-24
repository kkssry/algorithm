package programmers.school.week2;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 주식가격Test {
    @Test
    public void mainTest() {
        int[] prices = {1,2,3,2,3};
        주식가격 sol = new 주식가격();

//        assertThat(sol.solution(prices)).containsExactly(4,3,1,1,0);
        System.out.println(Arrays.toString(sol.solution(prices)));
    }

}