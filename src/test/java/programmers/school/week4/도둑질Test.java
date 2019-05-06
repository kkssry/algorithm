package programmers.school.week4;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Java6Assertions.assertThat;


public class 도둑질Test {
    @Test
    public void finalTest() {
        도둑질 sol = new 도둑질();
        int[] money = {9,9,9,9,5};
        System.out.println(sol.solution(money));
    }

    @Test
    public void mainTest() {
        도둑질 sol = new 도둑질();
        int[] arr = {1,2,3,1};
        int[] arr2 = {8,9,5,14,11,12,10};

        assertThat(sol.solution(arr2)).isEqualTo(35);
    }

    @Test
    public void arrayCopyTest() {
        int[] arr = {1,2,3,4,5};
        int[] arr2 = new int[4];

        System.arraycopy(arr,1,arr2,0,4);
        System.out.println(Arrays.toString(arr2));
    }

    @Test
    public void mathMaxTest() {
        System.out.println(Math.max(1,1));
    }
}