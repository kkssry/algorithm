package programmers.q43105;


import org.assertj.core.util.Arrays;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[][] triangle = {{7}, {3, 8},
                            {8, 1, 0}, {2, 7, 4, 4},{4,5,2,6,5}
                            };
        assertThat(sol.solution(triangle)).isEqualTo(30);
    }

    @Test
    public void 배열역정렬() {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(4);
        list.add(8);
        list.add(12);
        list.add(5);
        list.add(9);
        list.add(10);
        Collections.sort(list,((o1, o2) -> o2-o1));
        System.out.println(list);
    }
}