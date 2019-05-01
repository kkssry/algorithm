package baekjoon.find.rule.q1193;


import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class MainTest {
    @Test
    public void mainTest() {
        int a = 4;
        int[] arr = {1,2,3,4};
        String str = "abcdef";
        String[] strArr = {"a","b","c","d","e"};

        callFunc(a,arr,str,strArr);

        System.out.println(a);
        System.out.println(Arrays.toString(arr));
        System.out.println(str);
        System.out.println(Arrays.toString(strArr));

    }

    private void callFunc(int a, int[] arr, String str, String[] strArr) {
        a= -1;
        arr[0] = 100;
        str = "zyxwvu";
        strArr[0] = "Z";
    }
}