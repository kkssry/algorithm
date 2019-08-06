package baekjoon.q11053;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class MainTest {
    @Test
    public void 특정범위에서최대값() {
        int[] arr = {1, 5, 2, 1, 4, 3, 4, 5, 2, 1};
        for (int i = 1; i < arr.length; i++) {
            int result = IntStream.of(arr).limit(i).max().getAsInt();
            System.out.println(result);
        }
    }




}