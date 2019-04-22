package baekjoon.q10866;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MainTest {
    @Test
    public void mainTest() {
        String a = "asf 9";
        String b = "abc";
        String[] arr = a.split(" ");
        String[] arr2 = b.split(" ");

        if (arr.length == 2) {
            System.out.println(Arrays.toString(arr));
        }
        System.out.println(Arrays.toString(arr2));
    }
}
