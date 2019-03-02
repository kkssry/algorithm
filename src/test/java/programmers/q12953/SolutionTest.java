package programmers.q12953;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {5,15,4,8};
        System.out.println(sol.solution(arr));
    }

    @Test
    public void arr() {
        int[] arr = {1,2,3,4,5};
        System.out.println(Arrays.toString(asdf(arr)));
    }

    public int[] asdf(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + 2;
        }
        return arr;
    }
}