package baekjoon.q1620;


import org.junit.Test;

import java.util.Arrays;



public class MainTest {
    @Test
    public void name() {
        String a = "Asdf";
        a.equals("a");
    }

    @Test
    public void binarySearchTest() {
        String[] arr = {"a","b","c","d","e"};

        System.out.println(Arrays.binarySearch(arr,"e"));
    }

    @Test
    public void recursiveTest() {
        System.out.println(Main.binarySearch(0,25,2));
    }
}