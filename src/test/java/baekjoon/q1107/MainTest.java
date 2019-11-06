package baekjoon.q1107;

import org.junit.Test;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void containsTest() {
        String a = "0";
        String b = "19789793";
        String c = "19868859";

        System.out.println(a.contains(b));
        System.out.println(b.contains(a));

        System.out.println(c.contains(a));
        System.out.println(a.contains(c));

    }
}