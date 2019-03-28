package programmers.q12973;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        assertThat(new Solution().solution("baabaa")).isEqualTo(1);
    }


    @Test
    public void replaceTest() {
        String a = "aabbaaccaa";

        System.out.println(a.length());

        a.replaceFirst("aa","");
        System.out.println(a.length());
    }

    @Test
    public void 문자열비어있는지() {
        String a = "";
        System.out.println(a.isEmpty());
    }

    @Test
    public void 스트링빌더테스트() {
        StringBuilder sb = new StringBuilder();
        sb.append("a");
        sb.append("a");
        sb.append("b");
        sb.append("b");
        sb.append("c");
        sb.append("c");

        sb.delete(0,2);
        System.out.println(sb);

    }

    @Test
    public void name() {
        String a = "-";
        System.out.println("리미트 :-1 " + a.split("-",-1).length);
        System.out.println(Arrays.toString(a.split("-",-1)));
        System.out.println("--------------------------------------------");

        System.out.println("리미트 :0 " + a.split("-",0).length);
        System.out.println(Arrays.toString(a.split("-",0)));
        System.out.println("--------------------------------------------");

        System.out.println("리미트  " + a.split("-"));
        System.out.println(Arrays.toString(a.split("-")));
        System.out.println("--------------------------------------------");

        System.out.println("리미트 : 1 " + a.split("-",1).length);
        System.out.println(Arrays.toString(a.split("-",1)));
        System.out.println("--------------------------------------------");

//        System.out.println("리미트 : 2 "a.split("-",2).length);
//        System.out.println(Arrays.toString(a.split("-",2)));
    }
}