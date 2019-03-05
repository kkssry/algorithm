package programmers.q49993;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        String b = "bbadcefgh";
        String[] a = {"a","b","c","d","e"};
//        System.out.println(b.substring(b.charAt(b.indexOf(a[1]))));

        System.out.println(b.substring(b.indexOf(a[2]),b.indexOf(a[2])+1));
    }

    @Test
    public void containsTest() {
        String a = "abcdefg";
        System.out.println(!a.contains("b"));
    }

    @Test
    public void substringTest() {
        String a = "abcdefgh";
        System.out.println(a.substring(1));
    }

    @Test
    public void lengthTest() {
        String a = "asdf";
        System.out.println(a.length());
    }

    @Test
    public void list() {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("b");
        list.add("a");
        list.add("d");

        System.out.println(list);

//        list.remove("a");
        list.removeAll(Collections.singleton("a"));
        System.out.println(list);

    }

    @Test
    public void Test() {
        String[] a = {"BACDE", "CBAD", "AECB", "BDA","DBC"};
        Solution sol = new Solution();
        System.out.println(sol.solution("CB", a));
    }


}