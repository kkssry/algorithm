package programmers.q43164;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        String[][] arr = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String[][] arr2 = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"},{"ATL", "SFO"}};
        String[][] arr3 = {{"ICN","COO"},{"COO","ICN"},{"ICN","BOO"}};

        System.out.println(sol.solution(arr2));
    }
}