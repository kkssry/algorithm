package programmers.q42747;

import org.junit.Test;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class SolutionTest {
    @Test
    public void 배열정렬출력() {
        int[] a = {3, 0, 1, 2, 2 ,5 ,6};
        Arrays.sort(a);
        for (int i : a) {
            System.out.println(i);
        }
        System.out.println(a);
    }

    @Test
    public void test() {
        Solution solution = new Solution();
        int[] a = {0,0,0,0,0};
//        Arrays.sort(a);
//        System.out.println(Arrays.toString(a));
//        System.out.println();
        System.out.println(solution.solution(a));
    }

    @Test
    public void setTest() {
        Set<Integer> sseett = new TreeSet<>();
        sseett.add(0);
        sseett.add(0);
        sseett.add(1);
        sseett.add(4);
        sseett.add(5);
        sseett.add(6);

        System.out.println(sseett);
        System.out.println("--------------------");

        int a = ((TreeSet<Integer>) sseett).pollLast();
        System.out.println(a);
        int b = ((TreeSet<Integer>) sseett).pollLast();
        System.out.println(b);
        int c = ((TreeSet<Integer>) sseett).pollLast();
        System.out.println(c);
        int d = ((TreeSet<Integer>) sseett).pollLast();
        System.out.println(d);
        int e = ((TreeSet<Integer>) sseett).pollLast();
        System.out.println(e);
        System.out.println(sseett);
    }
}
