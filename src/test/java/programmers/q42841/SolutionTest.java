package programmers.q42841;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void mainTest() {
        int[][] baseball = {{123,1,1},{356,1,0},{327,2,0},{489,0,1}};
        Solution sol = new Solution();
        System.out.println(sol.solution(baseball));
    }

    @Test
    public void 문자열더하기인트() {
        String a;
        a = ""+ 1 + 2 + 3;
        a = "" + 3 + 4 + 5;
        System.out.println(a);
    }

    @Test
    public void 문자열테스트() {
        String a = "123";
        String b = "134";
        String[] c = b.split("");
        System.out.println(a.contains(c[1]));
    }
}