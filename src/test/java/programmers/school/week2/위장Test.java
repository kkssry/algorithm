package programmers.school.week2;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 위장Test {
    @Test
    public void mainTest() {
        위장 sol = new 위장();
        String[][] clothes = {{"yellow_hat","headgear"},{"blue_sunglasses","eyegear"},{"green_turban","headgear"}};

        assertThat(sol.solution(clothes)).isEqualTo(5);

    }
}