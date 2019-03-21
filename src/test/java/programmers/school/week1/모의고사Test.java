package programmers.school.week1;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class 모의고사Test {
    @Test
    public void mainTest() {
        int[] arr = {1,3,2,4,2};
        모의고사 sol = new 모의고사();
        System.out.println(Arrays.toString(sol.solution(arr)));
    }

    @Test
    public void 배열정렬() {
        int[] arr = { 1,3,4,6,3};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}