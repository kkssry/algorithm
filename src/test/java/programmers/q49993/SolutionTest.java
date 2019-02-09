package programmers.q49993;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void name() {
        String b = "bbadc";
        String[] a = {"a","b","c"};
//        System.out.println(b.substring(b.charAt(b.indexOf(a[1]))));

        System.out.println(b.substring(b.indexOf(a[2])));
    }
}