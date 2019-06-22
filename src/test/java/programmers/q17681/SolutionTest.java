package programmers.q17681;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void test() {
        Solution sol = new Solution();
        int n = 6;
        int[] arr1 = {46,33,33,22,31,50};
        int[] arr2 = {27,56,19,14,14,10};

        System.out.println(Arrays.toString(sol.solution(n,arr1,arr2)));
    }
}