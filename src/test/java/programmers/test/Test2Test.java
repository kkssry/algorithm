package programmers.test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Test2Test {
    @Test
    public void name() {
        Test2 test2 = new Test2();
        int[] people = {2,3};
        int[] tshirts = {1,2,3};
        System.out.println(test2.solution(people, tshirts));
    }

    @Test
    public void name1() {
        int[] arr = {1,2,3,4};
        List<Integer> list =
                Arrays.stream(arr).boxed().collect(Collectors.toList());
        System.out.println(list);
    }
}