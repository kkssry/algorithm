package programmers.school.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class K번째수Test {
    @Test
    public void mainTest() {
        int[] array = {1,5,2,6,3,7,4};
        int[][] commands = {{2,5,3},{4,4,1},{1,7,3}};

        K번째수 sol = new K번째수();
//        System.out.println(Arrays.toString(sol.solution(array, commands)));
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
}