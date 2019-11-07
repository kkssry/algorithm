package baekjoon.q1343;

import org.junit.Test;

import java.util.Arrays;

public class MainTest {
    @Test
    public void splitTest() {
        String a = "XX.XXXXXXXXXX..XXXXXXXX...XXXXXX";
        String c = "XXXXXX";
        System.out.println(Arrays.toString(c.split("\\.")));

        String[] splitA = a.split("\\.");
        for (String s : splitA) {
            System.out.println(s.length());
        }
        System.out.println(Arrays.toString(a.split("\\.")));
    }

    @Test
    public void replaceTest() {
        String a = "XX.XXXXXXXXXX..XXXXXXXX...XXXXXX";
        System.out.println(Arrays.toString(a.split("X",3)));
        System.out.println(Arrays.toString(a.split("X")));
    }

    @Test
    public void stringBuilderTest() {
        StringBuilder sb = new StringBuilder();


        System.out.println(sb.toString());
        System.out.println(sb.toString().length());

    }
}