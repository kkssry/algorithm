package programmers.q12935;

import org.junit.Test;

import java.util.*;

public class SolutionTest {
    @Test
    public void mainTest() {
        Solution sol = new Solution();
        int[] arr = {5,345,1,45,3,4,64,74};
        System.out.println(Arrays.toString(sol.solution(arr)));
    }

    @Test
    public void name() {
        int[] a = new int[2];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(10);
        queue.add(20);
        a[0] = queue.poll();
        a[1] = queue.poll();
        System.out.println(queue);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void stringBuilder테스트() {
        StringBuilder sb = new StringBuilder();
        sb.append(5);
        sb.append(4);
        sb.append(3);
        sb.append(2);
        sb.append(1);
        String a = "12345";

        String reverse = sb.reverse().toString();
        System.out.println(reverse);
    }

    @Test
    public void substringTest() {
        String a = "1";
        String b = a.substring(0,a.length()-1);
        if (b.isEmpty()) {
            System.out.println("비었네");
        }
    }

    @Test
    public void arrayElementDecending() {
        int[] num = {76,4,5,5,7,3};
        Integer[] s = Arrays.stream(num).boxed().toArray(Integer[]::new);
        Integer[] arr = s;
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list);
    }

    @Test
    public void listRemoveTest() {
        List<Integer> list= new ArrayList<>(Arrays.asList(1,2,3,4));
        list.remove(3);
        System.out.println(list);

    }
}