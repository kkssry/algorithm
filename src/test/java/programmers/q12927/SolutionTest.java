package programmers.q12927;


import org.junit.Test;

import java.util.*;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] works = {4,3,3};
        assertThat(sol.solution(4,works)).isEqualTo(12);
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

    @Test
    public void treeMapTest() {
        PriorityQueue<Integer> pr = new PriorityQueue<>();
        pr.add(5);pr.add(6);pr.add(3);pr.add(7);pr.add(9);pr.add(10);
        System.out.println(pr.poll());

        PriorityQueue<Integer> pr2 = new PriorityQueue<>(Comparator.reverseOrder());
        pr.add(5);pr.add(6);pr.add(3);pr.add(7);pr.add(9);pr.add(1);
        System.out.println(pr2.poll());
    }
}