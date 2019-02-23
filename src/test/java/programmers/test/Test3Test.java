package programmers.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class Test3Test {
    @Test
    public void name() {
        int[] arr = {300,200,500};
        int[][] arr1 = {{1000,600},{400,500},{300,100}};

        Test3 test3 = new Test3();
        int[] srr = test3.solution(arr, arr1);
        System.out.println(Arrays.toString(srr));
    }

    @Test
    public void asdf() {
        int[] arr = {200,150,150};
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void IntegerZoroTest() {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        int arr = list.get(0) + 1;
        System.out.println(arr);
    }

    @Test
    public void name3() {
        int[] arr = {300,200,500};
        int[][] arr1 = {{1000,600},{400,500},{300,100}};
    }

    @Test
    public void asdaf() {
        Integer a = 1;
        System.out.println(a+2);
    }
}