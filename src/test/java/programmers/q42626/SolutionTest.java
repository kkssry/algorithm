package programmers.q42626;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void name() {
        Solution sol = new Solution();
        int[] scovile = {0,0,1};
        int k = 2;

        System.out.println(sol.solution(scovile, k));
    }

    @Test
    public void 함수의매개변수값변화() {
        int a = 3;
        System.out.println( test(a)); // a가 4가리턴

        System.out.println("33 " + a);
    }

    public int test(int a) {
        a++;
        System.out.println("11 " + a);
        return a;
    }
}