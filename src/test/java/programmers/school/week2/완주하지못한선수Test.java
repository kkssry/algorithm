package programmers.school.week2;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class 완주하지못한선수Test {
    @Test
    public void mainTest() {
        완주하지못한선수 sol = new 완주하지못한선수();

        String[] participants = {"mislav", "stanko", "mislav", "ana"};
        String[] completion = {"stanko", "ana", "mislav"};
        assertThat(sol.solution(participants, completion)).isEqualTo("mislav");
    }

    @Test
    public void 배열테스트() {
        String[] arr = {"a","b","c","d"};
        String[] arr2 = {"a","b","c"};
        List<Integer> list = new ArrayList<>();
    }
}