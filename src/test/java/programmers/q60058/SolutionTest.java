package programmers.q60058;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void SolutionTest() {
        Solution sol = new Solution();
        System.out.println(sol.solution(")))()((())(()))(()(("));
    }

    @Test
    public void StringCutTest() {
        String a  = " ";
        for (char c : a.toCharArray()) {
            System.out.println(c);
        }

    }

    @Test
    public void StringBuilderTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("a").append("");
        System.out.println(sb);
        System.out.println(sb.length());
    }
    @Test
    public void StringBuilderAppendTest() {
        StringBuilder sb = new StringBuilder();
        sb.append("1",0,0);

    }

    @Test
    public void SubStringTest() {
        String a = "ab";
        System.out.println(a.substring(a.length()));
    }
}