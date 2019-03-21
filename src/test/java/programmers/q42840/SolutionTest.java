package programmers.q42840;

import org.junit.Test;

import java.util.*;

public class SolutionTest {
    @Test
    public void 리스트정렬() {
        List<Integer> list = new ArrayList<>();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);
        Collections.sort(list);
        //default 오름차순
        System.out.println(list);
    }

    @Test
    public void 배열정렬() {
        int[] a ={4,3,2,1};
        Arrays.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void 나눈나머지를인덱스() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i%4));
        }
    }

    @Test
    public void 테스트() {
        Solution solution = new Solution();
        int[] answers = {1,3,2,4,2};
        int[] arr = solution.solution(answers);
        System.out.println(Arrays.toString(arr));
    }

    @Test
    public void treeset테스트() {
        TreeSet<Integer> tree = new TreeSet<>();
        tree.add(2);
        tree.add(1);
        tree.add(4);
        tree.add(3);
        int a = Objects.requireNonNull(tree.pollFirst()).intValue();
        System.out.println(a);
    }
}