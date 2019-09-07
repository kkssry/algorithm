package programmers.q42891;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void solutionTest() {
        Solution sol = new Solution();
        int[] food_items = {4,1,1,5};
        System.out.println(sol.solution(food_items, 4));
    }
}