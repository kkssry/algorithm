package programmers.q12936;


import org.junit.Test;

import java.math.BigInteger;
import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {3, 1, 2};
        assertThat(sol.solution(5, 96)).isEqualTo(arr);
    }

    @Test
    public void 리스트부분정렬() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 6, 8, 2, 3, 1, 10));

        int[] arr = {5, 4, 3, 2, 1};

        Collections.sort(list.subList(1, list.size()));

        System.out.println(list);
    }

    @Test
    public void 빅인티저테스트() {
        BigInteger big = BigInteger.ONE;
        big = big.multiply(BigInteger.valueOf(2));
        big = big.multiply(BigInteger.valueOf(20));
        big = big.multiply(BigInteger.valueOf(100));
        System.out.println(big.intValue());
    }

    @Test
    public void integer범위테스트() {
        BigInteger a = BigInteger.valueOf(20);

        for (long i = 19; i >= 1; i--) {
            a = a.multiply(BigInteger.valueOf(i));
        }

        System.out.println(a.toString());
    }

    @Test
    public void listAddAllTest() {
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(5, 6, 7, 8));

        list1.addAll(list2);        //list1이 list2의 내용을 흡수함

        System.out.println(list1);
        System.out.println(list2);
    }

    @Test
    public void 인트호출() {
        int a = 10;
        int[] b = {1, 2};
        testMethod(a, b);

        System.out.println(a);
        System.out.println(Arrays.toString(b));
    }

    private void testMethod(int a, int[] b) {
        a -= 4;
        b[0] = 100;

        System.out.println(a);

    }
}