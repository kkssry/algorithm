package programmers.q43237;

import org.junit.Test;

import java.util.Arrays;
import java.util.OptionalInt;

public class SolutionTest {
    @Test
    public void mainTest() {
        int[] budgets = {120, 140, 150, 149};
        int m = 550;
        Solution sol = new Solution();
        System.out.println(sol.solution(budgets, m));
    }

    @Test
    public void 나누기테스트() {
        int a = 485;
        int b = 4;
        int c = a/b;
        System.out.println(c);
    }

    @Test
    public void 배열스트림합테스트() {
        int[] budgets = {120, 110, 140, 150};
        OptionalInt a = Arrays.stream(budgets).max();
        int b = a.getAsInt();
        System.out.println(b);
    }

    @Test
    public void binarySearchTest() {
        int[] budgets = {120, 110, 140, 150};
        Arrays.sort(budgets);
        System.out.println(Arrays.binarySearch(budgets, 0,3,120));
        System.out.println(Arrays.binarySearch(budgets,150));
    }

    @Test
    public void 인트합() {
        int a = 1 + (int)0.6;
        System.out.println(a);
    }
}