package programmers.q42839;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        String num = "011";
        Solution sol = new Solution();
        System.out.println(sol.solution(num));
    }

    @Test
    public void 문자열을숫자로() {
        String a = "17";
        int b = Integer.parseInt(a);
        System.out.println(b);
    }

    @Test
    public void char와string관계() {
        char a = 'a';
        String b = a + "";
        System.out.println(b.getClass());
        System.out.println(b);
    }

    @Test
    public void stringTest() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");

        String a = list.get(0) + list.get(1);
        System.out.println(a);
    }

    @Test
    public void 문자배열스트링() {
        String[] a = "abcdefg".split("");
        System.out.println(Arrays.asList(a));
        String b = Arrays.toString(a);
        System.out.println(b);

        List<String> list = Arrays.asList(a);
        System.out.println(list);
    }

    @Test
    public void 대소비교() {
        double a = 2.0;
        int b = 2;
        System.out.println(a > b);
        System.out.println(a == b);
        System.out.println(a < b);
    }

    @Test
    public void 문자열추출() {
        Set<String> a = new HashSet<>();
        Set<String> b = new HashSet<>();
        a.add("abcdef");
        a.add("aqcdasdef");
        a.add("accdeasdf");
        a.add("awcdasdfef");


        System.out.println(a);
        System.out.println(b);
    }

    @Test
    public void substringTest() {
        String a = "abcdef";
        String b = a.substring(0,0);
        System.out.println(a);
        System.out.println(b);
    }
}