package programmers.q12899;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        Solution solution = new Solution();
        String num = solution.solution(3);
        System.out.println(num);
    }

    @Test
    public void asdr() {
        Solution solution = new Solution();
//        System.out.println(solution.reverse("140"));
//        System.out.println(Integer.parseInt(solution.reverse("140")));
    }

    @Test
    public void stringPlusInt() {
        String a = "12";
        int b = 3;
        System.out.println(a + b);
    }

    @Test
    public void name1() {
        String a = "041";
        System.out.println(Integer.parseInt(a));
    }

    @Test
    public void stringBufferTest() {
        StringBuffer sb= new StringBuffer();
        sb.append("4");
        sb.append("5");
        sb.append(1);
        System.out.println(sb.toString());

    }
}