package programmers.q12904;


import org.junit.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void maintTest() {
        Solution sol = new Solution();
        assertThat(sol.solution("abcdcba")).isEqualTo(7);
        assertThat(sol.solution("abacde")).isEqualTo(3);
    }

    @Test
    public void stringTest() {
        String a = "abcde";
        boolean[] bol = new boolean[1];
        a = a.substring(2);

        callMethod(a,bol);
        System.out.println(bol[0]);

        System.out.println(a);
    }

    private void callMethod(String a,boolean[] bol) {
        String b= a;
        bol[0] = true;

        b = "ewew";
        System.out.println(a);
    }

    @Test
    public void stringBufferTest() {
        String a= "abcdefg";
        StringBuilder sb = new StringBuilder(a);
        System.out.println(sb.reverse().toString().equals("gfedcba"));
        System.out.println(sb.reverse().toString());
    }

    @Test
    public void subStringTest() {
        String a = "abcd";
        a = a.substring(3,4);
        System.out.println(a);
    }

    @Test
    public void forTest() {
        int j = 3;
        for (int i=0; i < 20; i+=j) {
//            System.out.println(j);
            System.out.println(i);
        }
    }
}