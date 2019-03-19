package programmers.q42895;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class SolutionTest {
    @Test
    public void copyOfRange() {
        int[] arr = {1,2,3,4};
//        int[] arr2 = {5,6,7,8};
        int[] arr2 = Arrays.copyOfRange(arr,0,arr.length);
        System.out.println(Arrays.toString(arr2));
    }
}