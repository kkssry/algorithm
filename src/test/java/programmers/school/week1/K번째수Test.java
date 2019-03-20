package programmers.school.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;
import static org.junit.Assert.*;

public class K번째수Test {
    @Test
    public void mainTest() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        K번째수 sol = new K번째수();
        System.out.println(Arrays.toString(sol.solution(array, commands)));
    }


    @Test
    public void substringTest() {
        String a = "abcdef";
        System.out.println(a);
        System.out.println(a.substring(0, 3));
        System.out.println(a);
    }

    @Test
    public void 정수배열문자열로() {
        int[] arr = {1,2,3};
//        String a = Arrays.stream(arr).map().toString();
//        System.out.println(a);
        try {
            Class.forName("K번째수");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void 정수배열을문자열로() {
        int[] a = {1,2,3};
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            sb.append(a[i]);
        }
        String b = sb.toString();
        System.out.println(b);
    }


    @Test
    public void 문장열정렬() {
        String a = "54321";
        String[] arr = a.split("");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        String b = Arrays.toString(arr);
        System.out.println(b);
    }

    @Test
    public void name() {
        String a = "2356";
        assertThat(a.charAt(2)).isEqualTo('5');
//        System.out.println(a.charAt(2););
    }

    @Test
    public void chartoInt() {
        char a = '1';
        int b = (int)a;
        int c = Character.getNumericValue(a);
        System.out.println(b);
        System.out.println(c);
    }
}