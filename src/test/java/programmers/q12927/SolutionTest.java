package programmers.q12927;


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] works = {1,1};
        assertThat(sol.solution(3,works)).isEqualTo(12);
    }

    @Test
    public void 리스트최대값() {
        List<Integer> list = new ArrayList<>(Arrays.asList(5,4,7,9,23,4));
        for (Integer integer : list) {
            if (integer == 5) {
                --integer;
            }
        }
        System.out.println(list);
    }

    @Test
    public void 배열정렬() {
        int[] arr = {1,8,4,3,7,9};

        callFunction(arr);
        System.out.println("호출 하는 함수 : " + Arrays.toString(arr));
    }

    private void callFunction(int[] arr) {
        Arrays.sort(arr);
        arr[0] = 3;
        System.out.println("호출 받는 함수 : " + Arrays.toString(arr));
    }
}