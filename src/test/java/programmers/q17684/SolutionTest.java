package programmers.q17684;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void charTest() {
        char a = 'a';
        char b = 'b';
        StringBuilder sb = new StringBuilder();
        sb.append(a).append(b);
        System.out.println(sb.toString());
    }

    @Test
    public void solutionTest() {
        Solution sol = new Solution();
        sol.solution("ABABABABABABABAB");
    }
}